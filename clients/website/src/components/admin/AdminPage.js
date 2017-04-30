import React, {PropTypes} from 'react';
import { Link, IndexLink } from 'react-router';

//Container Component, represents the layout of the Admin Page
export default class AdminPage extends React.Component {

  constructor(props) {
    super(props);

    this.handleLogOut = this.handleLogOut.bind(this);
  }

  handleLogOut() {
    sessionStorage.removeItem("email");
    sessionStorage.removeItem("password");
  }

  render() {
    return (
      <div>

        <nav className="navbar navbar-custom" role="navigation" style={{marginBottom:"40px"}}>
          <div className="container navigation">
            <div className="navbar-header page-scroll">
              <button type="button" className="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                        <i className="fa fa-bars"></i>
                    </button>
              <IndexLink to="/" className="navbar-brand">
                <img className="logo" src="/media/logo.png" alt="logo" width="46" height="46" />
                <span className="logo-head">Menagerie Network</span>
              </IndexLink>
            </div>

            <div className="collapse navbar-collapse navbar-right navbar-main-collapse">
              <ul className="nav navbar-nav">
                <li><IndexLink to="/administration" activeClassName="active">Dashboard</IndexLink></li>
                <li><Link to="/administration/zoos" activeClassName="active">Zoos</Link></li>
                <li><Link to="/administration/animals" activeClassName="active">Animals</Link></li>
                <li><Link to="/administration/users" activeClassName="active">Users</Link></li>
                <li><a href="/" onClick={this.handleLogOut}>Logout</a></li>
              </ul>
            </div>
          </div>
        </nav>

        <div className="container">
          {this.props.children}
        </div>
      </div>
    );
  }
}

AdminPage.propTypes = {
  children: PropTypes.object.isRequired
};
