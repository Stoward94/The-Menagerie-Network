import React from 'react';
import { Route, IndexRoute } from 'react-router';
import App from './components/app.jsx';
import HomePage from './components/home/HomePage.jsx';

import AdminPage from './components/admin/AdminPage';
import Dashboard from './components/admin/dashboard.jsx';
import LoginForm from './components/admin/login.jsx';
import ZooCreator from './components/admin/zoo-creator.jsx';
import SpeciesCreator from './components/admin/species-creator.jsx';
import UserCreator from './components/admin/user-creator.jsx';


const requireAuth = (nextState, replace) => {

  if(sessionStorage.email === undefined
    || sessionStorage.password === undefined) {
        // Redirect to Home page if not an Admin
        //replace({ pathname: '/administration/login?returnUrl=' + target })
        replace({
          pathname: '/login',
          state: { nextPathname: nextState.location.pathname }
        });
    }
}


//App component is always loaded, nested components
//are passed as children to the App component.
export default (
  <Route path="/" component={App}>
    <IndexRoute component={HomePage} />
    <Route path="/login" component={LoginForm} />

    <Route path="/administration" component={AdminPage} onEnter={requireAuth}>
      <IndexRoute component={Dashboard} />
      <Route path="/administration/zoos" component={ZooCreator} />
      <Route path="/administration/animals" component={SpeciesCreator} />
      <Route path="/administration/users" component={UserCreator} />
    </Route>
  </Route>


)
