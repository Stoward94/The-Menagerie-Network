import React from 'react';
import Config from 'config.json';

/**
 * This component will display 4 animal 'blocks' showing an image,
 * common name and latin name. The 4 blocks are randomly selected, using
 * a random number generator between 1 & 8 for the animal ID.
 */
export class AnimalBlocks extends React.Component{
  constructor() {
    super();

    //empty state
    this.state = {startingBlocks: []};

    //get some random animals
    this.getAnimalData();
  }

  //Generates random ID values
  randomIds(){
    var ids = [];

    while(ids.length < 4){
        //Random number between 1 & 8.
        var n = Math.floor((Math.random() * 8) + 1);

        //Only push unique numbers
        if(ids.indexOf(n) === -1)
          ids.push(n);
    }
    return ids;
  }

  //Makes the http request to the API to get the animal data.
  getAnimalData(){
    var ids = this.randomIds();
    var url = Config.apiAnimalBase;

    //loop through ids
    ids.map((id, index) => {
      this.serverRequest = $.get(url + id, (result) => {

        //Get blocks currently in state
        var blocks = this.state.startingBlocks;

        //Add new block object
        blocks.push({
          commonName: result.commonName,
          latinName: result.scientificName,
          imageUrl: result.imageUrl
        })

        //Set the state to update view
        this.setState({
          startingBlocks: blocks
        });
      });
    });
  }

  render(){
    return <div>
      {this.state.startingBlocks.map((animal, index) =>

        <div className="col-md-3 col-sm-4" key={index}>
            <div className="ani-block wow fadeInUp" data-wow-delay="0.1s">
                <div>
                    <img className="ani-block-img" src={animal.imageUrl}/>
                </div>
                <div className="ani-block-h">
                    {animal.commonName}
                </div>
                <div className="ani-block-body">
                    "{animal.latinName}"
                </div>                
            </div>
        </div>

      )}
    </div>
  }
};
