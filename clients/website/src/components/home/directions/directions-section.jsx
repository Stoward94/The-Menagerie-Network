import React from 'react';
import GoogleMap from './google-map.jsx';

//ES6 Stateless Functional Component
//No State, No Props
const DirectionsSection = () => {
  return(
    <section id="directions-section">
      <div className="container pad-b-80">
        <div className="row">
          <div className="col-lg-8 col-lg-offset-2">
            <div className="wow lightSpeedIn" data-wow-delay="0.1s">
              <div className="sec-heading text-center">
                <h2 className="h-bold">
                  <img width="64px" style={{marginLeft:"-32px"}} src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuQdH2uUFgiS3YAzAMb6zzY7zqw3lcJnq-ayF9QOQ0yv8bylZI5Q"/>
                  Just Follow the Yellow Brick Road</h2>
                <p>Visiting all of our zoos has never been easier</p>
              </div>
            </div>
            <div className="divider-short"></div>
          </div>
        </div>

        <GoogleMap/>
      </div>
    </section>
  );
};

export default DirectionsSection;
