import React from 'react';
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
    this.handleInputChange = this.handleInputChange.bind(this);
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

  handleInputChange(event) {
    const value = event.target.value;
    const name = event.target.name;

    this.setState({[name]: value});
  }

  /* Contacts the API, passing the username and password
   * waits to see if the user is authenticated
   */
  authenticateUser() {
    var self = this;
    const url = Config.apiAuthenticate;
    const data = {
      email: this.state.email,
      password: this.state.password
    };

    //Contact the API
    $.post(url, data)
      .done(function(response) {
        console.dir("Success " + response);
        self.updateSessionStorage();

        //Notify the parent of the success
        self.props.onSuccess();
      })
      .fail(function(response) {
        console.dir("Fail " + response);
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
  onSuccess: React.PropTypes.func.isRequired
};
