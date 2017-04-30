import React from 'react';
import { browserHistory } from 'react-router';
import Config from 'config.json';
import './css/admin.css';

export default class LoginForm extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password:'',
      disabled: false,
      error: false
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.authenticateUser = this.authenticateUser.bind(this);
    this.updateSessionStorage = this.updateSessionStorage.bind(this);
  }

  handleSubmit(event) {
    event.preventDefault();

    //Disable inputs
    this.setState({disabled: true});

    //Test credentials
    this.authenticateUser();
  }

  handleChange(event) {
    const value = event.target.value;
    const name = event.target.name;

    this.setState({[name]: value});

    if(this.state.error === true){
      this.setState({error: false});
    }
  }

  /* Contacts the API, passing the username and password
   * waits to see if the user is authenticated
   */
  authenticateUser() {
    var self = this;
    const data = {
      email: this.state.email,
      password: this.state.password
    };

    const options = {
      url: Config.apiAuthenticate,
      data: JSON.stringify(data),
      contentType:"application/json"
    }

    //Contact the API
    $.post(options)
      .done(function(response) {
        self.setState({error: false});
        self.updateSessionStorage();

        //On successful authenitcation, direct the user to the
        //intended path.
        const location = self.props.location
        if (location.state && location.state.nextPathname) {
          browserHistory.push(location.state.nextPathname);
        } else {
          browserHistory.push('/administration');
        }
      })
      .fail(function(response) {
        self.setState({error: true});
      })
      .always(function(){
        //Always enable input again
        self.setState({disabled: false});
      });
  }

  /* Stores the authenticated username and password
   * for a user in the session storage
   */
  updateSessionStorage() {
    sessionStorage.email = this.state.email;
    sessionStorage.password = this.state.password;
  }

  render() {
    return (
      <div className="login-page">

        {this.state.error === true &&
          <div className="alert alert-danger">Username and password are incorrect</div>
        }
          <form className="login-form" onSubmit={this.handleSubmit}>
            <fieldset disabled={this.state.disabled}>
              <input name="email" type="email" required
                placeholder="username" onChange={this.handleChange}/>

              <input name="password" type="password" required
                placeholder="password" onChange={this.handleChange}/>

              <button type="submit">login</button>
            </fieldset>
          </form>
      </div>
    );
  }
}

LoginForm.propTypes = {
  redirectUrl: React.PropTypes.string
};
