import { Link, IndexLink } from 'react-router';

//ES6 Stateless Functional Component
const Footer = () => {
  return (
    <footer>
      <div className="container">
        <div className="row">
          <div className="col-sm-6 col-md-4">
          <div className="wow fadeInDown" data-wow-delay="0.1s">
            <div className="widget">
              <h5>About Menagerie Network</h5>
              <p>
                Lorem ipsum dolor sit amet, ne nam purto nihil impetus, an facilisi accommodare sea
              </p>
            </div>
          </div>
          <div className="wow fadeInDown" data-wow-delay="0.1s">
            <div className="widget">
              <h5>Information</h5>
              <ul>
                <li><a href="#">Contact Us</a></li>
                <li><a href="#">Cookie Information</a></li>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Terms & conditions</a></li>
              </ul>
            </div>
          </div>
        </div>

        <div className="col-sm-6 col-md-4">
          <div className="wow fadeInDown" data-wow-delay="0.1s">
            <div className="widget">
              <h5>Animal Inbox</h5>
              <p>Subscribe to email updates from our network and expect to hear all about our exciting activities</p>
              <ul>
                <li>
                  <span className="fa-stack fa-lg">
                    <i className="fa fa-circle fa-stack-2x"></i>
                    <i className="fa fa-calendar-o fa-stack-1x fa-inverse"></i>
  								</span> Monday - Sunday, 9am to 5:30pm
                </li>
                <li>
                  <span className="fa-stack fa-lg">
                    <i className="fa fa-circle fa-stack-2x"></i>
  									<i className="fa fa-phone fa-stack-1x fa-inverse"></i>
                  </span> 04235 456932
                </li>
                <li>
                  <span className="fa-stack fa-lg">
                    <i className="fa fa-circle fa-stack-2x"></i>
                    <i className="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
                  </span> zoo@menagerienetwork.com
                </li>
              </ul>
            </div>
          </div>
        </div>

        <div className="col-sm-6 col-md-4">
          <div className="wow fadeInDown" data-wow-delay="0.1s">
            <div className="widget">
              <h5>Our base</h5>
              <p>The Menagerie Nework, Made Upium, Someplace, PO BOX 124 56</p>

            </div>
          </div>
          <div className="wow fadeInDown" data-wow-delay="0.1s">
            <div className="widget">
              <h5>Follow us</h5>
              <ul className="company-social">
                <li className="social-facebook"><a href="#"><i className="fa fa-facebook"></i></a></li>
                <li className="social-twitter"><a href="#"><i className="fa fa-twitter"></i></a></li>
                <li className="social-google"><a href="#"><i className="fa fa-google-plus"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
  );
};

export default Footer;
