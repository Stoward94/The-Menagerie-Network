import React from 'react';
import Config from 'config.json';

/**
 * This component will display the details about a given animal. A prop of
 * 'id' is passed from the parent to indicate which animal should be displayed.
 */
export class AnimalDetails extends React.Component {

    constructor(props){
      super(props);

      //Configure state
      this.state = {
        isLoading: true,
        animalId: props.id
      };
    }

    retrieveData(){

      var id = this.state.animalId;
      var url = Config.apiBase + 'animal/' + id;

      //Make the GET request
      this.serverRequest = $.get(url, (result) => {

        this.setState({
          isLoading: false,
          animal: {
            commonName: result.commonName,
            latinName: result.scientificName,
            family: result.family,
            genus: result.genus,
            order: result.order,
            species: result.species,
            origin: result.origin,
            imageUrl: result.imageUrl,
            description: result.description,
            zoo: result.zooNames
          }
        });
      });
    }

    componentWillReceiveProps(nextProps){

      //Is the new animal id different?
      if(this.state.animalId != nextProps.id){

        //update state
        this.state.isLoading = true;
        this.state.animalId = nextProps.id;

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

    //Basic HTML to stop the section height changing
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
        <div>
            <div className="ani-details wow bounceInLeft">
                <div className="row">
                  <div className="col-md-4">
                    <img src={this.state.animal.imageUrl} className="img-responsive"/>
                  </div>

                  <div className="col-md-8" style={{paddingLeft:"0px"}}>
                    <h2 className="h-medium">{this.state.animal.commonName} <small>"{this.state.animal.latinName}"</small>
                      <span className="pull-right wow bounceInLeft" style={{fontSize: "0.4em", paddingRight:"15px"}}>
                        <img src="./media/icons/globe.png" style={{height:"32px", width:"32px", marginRight:"5px"}}/> Origin: {this.state.animal.origin}
                      </span>
                    </h2>
                    <p style={{paddingRight:"5px"}}>
                      <span>
                        <b>Order:</b> {this.state.animal.order} |
                      </span>
                      <span>
                        <b>Family:</b> {this.state.animal.family} |
                      </span>
                      <span>
                        <b>Genus:</b> {this.state.animal.genus} |
                      </span>
                      <span>
                        <b>Species:</b> {this.state.animal.species}
                      </span>
                    </p>
                    <p>{this.state.animal.description}</p>
                  </div>
                </div>

                <div className="ani-location">
        					<div>
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
