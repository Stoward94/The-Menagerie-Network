import Select from 'react-select';
import './css/animal-search.css'; // import css


function logChange(val) {
    alert("Selected: " + val);
}

export const AnimalSearch = ({search, onSelect}) => (

  <Select
      name="animal-search"
      value={search}
      asyncOptions={getOptions}
      onChange={onSelect}
  />

)


//Temp local data
var getOptions = function(input, callback) {

    //Comment out to perform default search
    if(input == '')
      return callback(null, { options:[]});
    // the above

    $.get('./animals.json', (result) => {

      var options = [];

      result.map((animal, index) => {
        options.push({ value: animal.Id, label: animal.CommonName })
      })

      console.dir(options);

      callback(null, {options});
    });

    // setTimeout(function() {
    //     callback(null, {
    //         options: [
    //             { value: 1, label: 'Royal Python' },
    //             { value: 2, label: 'Chimpanzee' },
    //             { value: 3, label: 'African Lion' },
    //             { value: 4, label: 'Bengal Tiger' },
    //             { value: 5, label: 'Emperor Penguin' },
    //         ],
    //         // CAREFUL! Only set this to true when there are no more options,
    //         // or more specific queries will not be sent to the server.
    //         complete: true
    //     });
    // }, 500);
};
