import { Link, IndexLink } from 'react-router';

//ES6 Stateless Functional Component
const Navigation = () => {
  return (
    <nav className="navbar navbar-custom navbar-fixed-top" role="navigation">
      <div className="container navigation">
        <div className="navbar-header page-scroll">
          <button type="button" className="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i className="fa fa-bars"></i>
                </button>
          <IndexLink to="/" className="navbar-brand">
            <img className="logo" src="media/logo.png" alt="logo" width="46" height="46" />
            <span className="logo-head">Menagerie Network</span>
          </IndexLink>
        </div>

        <div className="collapse navbar-collapse navbar-right navbar-main-collapse">
          <ul className="nav navbar-nav">
            <li><IndexLink to="#intro" activeClassName="active">Home</IndexLink></li>
            <li><Link to="#zoos-section" activeClassName="active">Zoos</Link></li>
            <li><Link to="#animals-section" activeClassName="active">Animals</Link></li>
            <li><Link to="#directions-section" activeClassName="active">Directions</Link></li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navigation;
