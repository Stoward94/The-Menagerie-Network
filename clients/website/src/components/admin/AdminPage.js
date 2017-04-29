import React from 'react';
import { render } from 'react-dom';

import LoginForm from './login.jsx';

//Container Component, represents the layout of the Home Page
export default class HomePage extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      authenticated: false
    };

    this.checkAuthentication();
  }

  checkAuthentication() {

  }

  render() {
    return (
      <div>
        <LoginForm onSuccess={this.checkAuthentication}/>
      </div>
    );
  }
}
