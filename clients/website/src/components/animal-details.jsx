import React from 'react';

export class AnimalDetails extends React.Component {

    constructor(props){
      super(props);

      this.state = {
        isLoading: true,
      };
    }

    retrieveData(){
      this.serverRequest = $.get('./animals.json', (result) => {

        var id = this.props.id;

        function findById(element){
          return element.Id == id;
        };

        var animal = result.find(findById);

        this.setState({
          isLoading: false,
          animal: {
            commonName: animal.CommonName,
            latinName: animal.LatinName,
            family: animal.Family,
            genus: animal.Genus,
            order: animal.Order,
            species: animal.Species,
            imageUrl: animal.ImageUrl,
            description: animal.Description,
            zoo: animal.Zoo
          }
        });

      });
    }

    componentWillReceiveProps(nextProps){
      if(this.props.id != nextProps.id){
        this.state.isLoading = true;
        this.retrieveData();
      }
    }

    componentDidMount() {
      //Fetch external data
      this.retrieveData();
    }

    componentWillUnmount() {
      this.serverRequest.abort();
    }

    renderLoading(){
      return (
        <div style={{minHeight:"250px"}}>
            {/*<h1>Loading...</h1>*/}
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
        </div>
      );
    }

    renderContent(){
      return (
        <div className="ani-details">
            <div>
              <div className="row">
                <div className="col-md-4">
                  <img src={this.state.animal.imageUrl} className="img-responsive"/>
                </div>

                <div className="col-md-8" style={{paddingLeft:"0px"}}>
                  <h2 className="h-medium">{this.state.animal.commonName} <small>"{this.state.animal.latinName}"</small></h2>
                  <p style={{paddingRight:"5px"}}>
                    <b>Order:</b> {this.state.animal.order} |
                    <b> Family:</b> {this.state.animal.family} |
                    <b> Genus:</b> {this.state.animal.genus} |
                    <b> Species:</b> {this.state.animal.species}
                    <br/>
                  </p>
                  <p>{this.state.animal.description}</p>
                </div>
              </div>
            </div>

            <div className="ani-location">
    					<div className="wow bounceInUp" data-wow-delay="0.3s">
      					<div className="row">
                  <div className="col-md-4">
                    <h2><i className="fa fa-globe" aria-hidden="true"></i> Come and Visit Me</h2>
                  </div>
                  <div className="col-md-8">
                    <ul>
                      {this.state.animal.zoo.map((zoo, index) =>
                        <li key={index}>{zoo}</li>
                      )}
                    </ul>
                  </div>


      					</div>
    					</div>
	          </div>

        </div>
      );
    }

    render() {
      return (
        <div>
          {this.state.isLoading ?
            this.renderLoading() :
            this.renderContent()}
        </div>
      )
    };
}


AnimalDetails.propTypes = {
  id: React.PropTypes.number.isRequired
}
