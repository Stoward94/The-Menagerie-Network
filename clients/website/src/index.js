//index.js is responsible for all of the component rendering :)

import React from 'react';
import { render } from 'react-dom';
import { ZooSection } from './components/zoo-section.jsx';
import { AnimalSection } from './components/animal-section.jsx';
import { DirectionsSection } from './components/directions-section.jsx';

window.React = React;


render(
    <ZooSection />,
    document.getElementById('zoos-section')
)

render(
    <AnimalSection />,
    document.getElementById('animals-section')
)

render(
    <DirectionsSection />,
    document.getElementById('directions-section')
)
