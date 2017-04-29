import React from 'react';
import { Route, IndexRoute } from 'react-router';
import App from './components/app.jsx';
import HomePage from './components/home/HomePage.jsx';
import AdminPage from './components/admin/AdminPage';

//App component is always loaded, nested components
//are passed as children to the App component.
export default (
  <Route path="/" component={App}>
    <IndexRoute component={HomePage} />
    <Route path="administration" component={AdminPage} />
  </Route>
)
