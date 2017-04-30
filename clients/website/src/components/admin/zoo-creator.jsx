import React from 'react';
import Config from 'config.json';

import ZooBox from './zoos-box.jsx';

export default class ZooCreator extends React.Component {

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
      name: this.state.name,
      siteUrl: this.state.siteUrl,
      thumbnailUrl: this.state.thumbnailUrl,
      summary: this.state.summary,
      longitude: this.state.longitude,
      latitude: this.state.latitude,
      postcode: this.state.postcode,
    };

    const auth = sessionStorage.email + ":" + sessionStorage.password;

    const options = {
      url: Config.apiZooBase,
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
          message: "Zoo created successfully"
        });
      })
      .fail(function(response) {
        self.setState({
          error: "Unable to create zoo at this time",
        });
      })
      .always(function(){
        //Always enable input again
        self.setState({disabled: false});
      });
  }

  render() {
    return (
      <div>
        <h3 className="h-ultra">Zoo Creator</h3>

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
                  <div>Details</div>
                  <hr style={{marginTop:"5px"}}/>
                  <div className="form-group">
                    <label htmlFor="zoo-name">Name</label>
                    <input id="zoo-name" name="name" type="text" className="form-control" required maxLength="75" onChange={this.handleChange}/>
                  </div>

                  <div className="form-group">
                    <label htmlFor="site-url">Website URL</label>
                    <input id="site-url" name="siteUrl" type="url" className="form-control" required maxLength="100" onChange={this.handleChange}/>
                  </div>

                  <div className="form-group">
                    <label htmlFor="thumbnail-url">Thumbnail URL</label>
                    <input id="thumbnail-url" name="thumbnailUrl" type="url" className="form-control" required  maxLength="200" onChange={this.handleChange}/>
                  </div>

                  <div className="form-group">
                    <label htmlFor="summary">Zoo Summary</label>
                    <textarea id="summary" name="summary" className="form-control" required rows="5" maxLength="255" onChange={this.handleChange}></textarea>
                  </div>

                  <div>Location</div>
                  <hr style={{marginTop:"5px"}}/>
                  <div className="row">
                    <div className="col-md-6">
                      <div className="form-group">
                        <label htmlFor="longitude">Longitude</label>
                        <input id="longitude" name="longitude" type="number" step="any" className="form-control" required onChange={this.handleChange}/>
                      </div>
                    </div>

                    <div className="col-md-6">
                      <div className="form-group">
                        <label htmlFor="latitude">Latitude</label>
                        <input id="latitude" name="latitude" type="number" step="any" className="form-control" required onChange={this.handleChange}/>
                      </div>
                    </div>
                  </div>

                  <div className="form-group">
                    <label htmlFor="postcode">Postcode</label>
                    <input id="postcode" name="postcode" type="text" className="form-control" required onChange={this.handleChange}/>
                  </div>

                  <button type="submit" className="btn btn-skin btn-lg" disabled={this.state.disabled}>Create</button>
                </form>
              </div>
            </div>
          </div>

          <div className="col-md-4">
            <ZooBox/>
          </div>
        </div>
      </div>
    );
  }

};
