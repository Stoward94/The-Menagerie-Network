import Config from 'config.json';

export default function initMap() {

    $.get(Config.apiZooBase, (result) => {

      //Configure destination select list with zoos
      initDestinationSelectList(result);

        var mapOptions = {
            zoom: 6,
            center: {
                lat: 53.775537,
                lng: -4.006032
            }
        };

        var map = new google.maps.Map(document.getElementById("map"), mapOptions);

        //Configure directions handler
        new AutocompleteDirectionsHandler(map);

        var infoWindows = [];

        var markers = result.map((zoo, i) => {
            var marker = new google.maps.Marker({
                position: {
                    lat: zoo.latitude,
                    lng: zoo.longitude
                },
                title: zoo.name,
                animation: google.maps.Animation.DROP,
                map: map
            });

            var contentString =
                '<div id="content"><b>' + zoo.name + '</b>' +
                '<div id="bodyContent">' +
				'<span>Open hours: 09:30 - 17:30</span><br/>' +
                '<a href="' + zoo.siteUrl + '">' + zoo.siteUrl + '</a> ' +
                '</div></div>';

            //Create window and add to array
            var infowindow = new google.maps.InfoWindow({
                content: contentString
            });
            infoWindows.push(infowindow);

            marker.addListener('click', function() {
                //First close all windows
                infoWindows.map((w, i) => {
                    w.close();
                });
                infowindow.open(map, marker);
            });
            return;
        });
    });
}

var AutocompleteDirectionsHandler = function(map) {
    this.map = map;
    this.originPlaceId = null;
    this.destination = null;
    this.travelMode = "DRIVING";

    var originInput = document.getElementById('origin-input');
    var destinationInput = document.getElementById('destination-select');

    this.directionsService = new google.maps.DirectionsService;
    this.directionsDisplay = new google.maps.DirectionsRenderer;
    this.directionsDisplay.setMap(map);

    var originAutocomplete = new google.maps.places.Autocomplete(
        originInput, { placeIdOnly: true });

    //Handle origin selection
    this.setupPlaceChangedListener(originAutocomplete);

    //Handle zoo selection change
    destinationInput.addEventListener("change", () => {
      this.destination = destinationInput.value;
      this.route();
    });
};

AutocompleteDirectionsHandler.prototype.setupPlaceChangedListener = function(autocomplete) {
    var me = this;
    autocomplete.bindTo('bounds', this.map);

    autocomplete.addListener('place_changed', function() {
        var place = autocomplete.getPlace();
        if (!place.place_id) {
            window.alert("Please select an option from the dropdown list.");
            return;
        }
        me.originPlaceId = place.place_id;
        me.route();
    });

};

AutocompleteDirectionsHandler.prototype.route = function() {

    if (!this.originPlaceId || !this.destination) {
        return;
    }

    var me = this;

    //Object containing the input terms
    var directionsRequest = {
      origin: { 'placeId': this.originPlaceId },
      destination: this.destination,
      travelMode: this.travelMode
    };

    this.directionsService.route(directionsRequest, function(response, status) {
        if (status === 'OK') {

            me.directionsDisplay.setDirections(response);

            //update summary panel
            var route = response.routes[0];
            document.getElementById('route-notes').innerHTML = "via " + route.summary;
            document.getElementById('route-distance').innerHTML = route.legs[0].distance.text;
            document.getElementById('route-time').innerHTML = route.legs[0].duration.text;
            document.getElementById('directions-info-panel').style.visibility = 'visible';

        } else {
            //window.alert('Directions request failed due to ' + status);
        }
    });
};

var initDestinationSelectList = function(items){

    items.map((opt, index) => {
      $("#destination-select").append(new Option(opt.name, opt.postcode));
    });
}
