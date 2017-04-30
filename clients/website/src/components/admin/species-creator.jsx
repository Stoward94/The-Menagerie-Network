import React from 'react';
import Config from 'config.json';

import SpeciesBox from './species-box.jsx';

export default class SpeciesCreator extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      message: '',
      error: '',
      disabled: false
    }

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  handleSubmit(event){
    event.preventDefault();

    //Disable inputs
    this.setState({
      disabled: true,
      error: '',
      message: ''
    });

    this.postRequest();
  }

  handleChange(event) {
    const value = event.target.value;
    const name = event.target.name;

    this.setState({[name]: value});
  }

  postRequest() {

    var self = this;
    const data = {
      commonName: this.state.commonName,
      scientificName: this.state.scientificName,
      order: this.state.order,
      family: this.state.family,
      genus: this.state.genus,
      species: this.state.species,
      origin: this.state.origin,
      description: this.state.description,
      imageUrl: this.state.imageUrl,
    };

    const auth = sessionStorage.email + ":" + sessionStorage.password;

    const options = {
      url: Config.apiSpeciesBase,
      data: JSON.stringify(data),
      contentType:"application/json",
      headers: {
        "Authorization": "Basic " + btoa(auth)
      }
    }

    //Contact the API
    $.post(options)
      .done(function(response) {
        self.setState({
          message: "Species registered successfully"
        });
      })
      .fail(function(response) {

        //Check for authenitcation error
        if(response.status === 401){
          self.setState({error: "Authentication failed"});
        }
        else{
          self.setState({error: "Unable to register species at this time"});
        }
      })
      .always(function(){
        //Always enable input again
        self.setState({disabled: false});
      });
  }

  render() {
    return (
      <div>
        <h3 className="h-ultra">Species Creator</h3>

        {this.state.error !== '' &&
          <div className="alert alert-danger">{this.state.error}</div>
        }

        {this.state.message !== '' &&
          <div className="alert alert-success">{this.state.message}</div>
        }

        <div className="row">
          <div className="col-md-8">
            <div className="panel panel-default">
              <div className="panel-body">
                <form onSubmit={this.handleSubmit}>
                  <div>Specification</div>
                  <hr style={{marginTop:"5px"}}/>

                  <div className="row">
                    <div className="col-md-6">
                      <div className="form-group">
                        <label htmlFor="common-name">Common Name</label>
                        <input id="common-name" name="commonName" type="text" className="form-control" required maxLength="45" onChange={this.handleChange}/>
                      </div>
                    </div>

                    <div className="col-md-6">
                      <div className="form-group">
                        <label htmlFor="scientific-name">Scientific (Latin) Name</label>
                        <input id="scientific-name" name="scientificName" type="text" className="form-control" required maxLength="45" onChange={this.handleChange}/>
                      </div>
                    </div>
                  </div>

                  <div className="row">
                    <div className="col-md-6">
                      <div className="form-group">
                        <label htmlFor="order">Order</label>
                        <input id="order" name="order" type="text" className="form-control" required maxLength="45" onChange={this.handleChange}/>
                      </div>
                    </div>

                    <div className="col-md-6">
                      <div className="form-group">
                        <label htmlFor="family">Family</label>
                        <input id="family" name="family" type="text" className="form-control" required maxLength="45" onChange={this.handleChange}/>
                      </div>
                    </div>
                  </div>

                  <div className="row">
                    <div className="col-md-6">
                      <div className="form-group">
                        <label htmlFor="genus">Genus</label>
                        <input id="genus" name="genus" type="text" className="form-control" required maxLength="45" onChange={this.handleChange}/>
                      </div>
                    </div>

                    <div className="col-md-6">
                      <div className="form-group">
                        <label htmlFor="species">Species</label>
                        <input id="species" name="species" type="text" className="form-control" required maxLength="45" onChange={this.handleChange}/>
                      </div>
                    </div>
                  </div>

                  <div className="row">
                    <div className="col-md-6">
                      <div className="form-group">
                        <label htmlFor="origin">Origin</label>
                        <input id="origin" name="origin" type="text" className="form-control" required maxLength="45" onChange={this.handleChange}/>
                      </div>
                    </div>
                  </div>

                  <div className="form-group">
                    <label htmlFor="imageUrl">Image Url</label>
                    <input id="imageUrl" name="imageUrl" type="url" className="form-control" required maxLength="100" onChange={this.handleChange}/>
                  </div>

                  <div className="form-group">
                    <label htmlFor="description">Description</label>
                    <textarea id="description" name="description" type="text" className="form-control" rows="5" required maxLength="750" onChange={this.handleChange}></textarea>
                  </div>

                  <button type="submit" className="btn btn-skin btn-lg" disabled={this.state.disabled}>Create</button>
                </form>
              </div>
            </div>
          </div>

          <div className="col-md-4">
            <SpeciesBox/>
          </div>
        </div>
      </div>
    );
  }

};
