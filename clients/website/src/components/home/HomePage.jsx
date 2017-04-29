import React from 'react';
import { render } from 'react-dom';

import Navigation from 'components/shared/navigation.jsx';
import Intro from './intro.jsx';
import StepsSection from './steps-section.jsx';
import Adoption from './adoption-section.jsx';
import { ZooSection } from './zoo-section.jsx';
import { AnimalSection } from './animal-section.jsx';
import DirectionsSection from './directions/directions-section.jsx';
import Footer from 'components/shared/footer.jsx';

//Container Component, represents the layout of the Home Page
export default class HomePage extends React.Component {

  render() {
    return (
      <div>
        <Navigation/>
        <Intro/>
        <ZooSection/>
        <StepsSection/>
        <AnimalSection/>
        <Adoption/>
        <DirectionsSection/>
        <Footer/>
      </div>
    );
  }
}
