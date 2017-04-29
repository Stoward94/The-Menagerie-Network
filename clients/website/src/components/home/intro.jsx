import React from 'react';

//ES6 Stateless Functional Component
//No State, No Props
const Intro = () => {
  return (
    <section id="intro" className="intro">
      <div className="intro-content">
        <div className="container">
          <div className="row">
            <div className="col-lg-6">
              <div className="wow fadeInDown" data-wow-offset="0" data-wow-delay="0.1s">
                <h2 className="h-ultra" style={{color:"white", fontSize:"2.1em"}}>The Menagerie Network Experience</h2>
              </div>
              <div className="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.1s">
                <h4 className="h-light" style={{color:"white", fontSize:"1.3em"}}><i className="fa fa-paw" aria-hidden="true"></i> Home to the most amazing animals</h4>
              </div>
              <div className="well well-trans">
                <div className="wow fadeInRight" data-wow-delay="0.1s">

                  <ul className="lead-list">
                    <li>
                      <span className="fa fa-ticket fa-2x icon-success" style={{height:"60px", marginRight:"12px"}}></span><span><strong> Save 10% when booking online</strong><br />Know when you’re planning to visit? Book online to save 10% and take advantage of family and group discounts!</span>
                    </li>
                    <li>
                      <span className="fa fa-birthday-cake fa-2x icon-success" style={{height:"60px", marginRight:"12px"}}></span><span><strong> Become part of the Menagerie Family</strong><br />Enjoy unlimited annual visits to any Menagerie Network Zoo plus a host of other benefits. From only £63.</span>
                    </li>
                    <li>
                      <span className="fa fa-shopping-bag fa-2x icon-success" style={{height:"60px", marginRight:"12px"}}></span><span><strong> Visit the online Gift shop</strong><br />Every product you purchase supports the charity and this means that when you shop with us you are also working for wildlife.</span>
                    </li>
                  </ul>
                  <p className="text-right wow bounceIn" data-wow-delay="0.4s" style={{marginBottom:0}}>
                    <a href="#" className="btn btn-skin btn-lg">Learn more <i className="fa fa-angle-right"></i></a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Intro;
