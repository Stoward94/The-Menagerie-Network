//index.js is responsible for all of the component rendering :)

import React from 'react';
import { render } from 'react-dom';
import { ZooSection } from './components/zoo-section.jsx';
import { AnimalSection } from './components/animal-section.jsx';

window.React = React;


render(
    <ZooSection />,
    document.getElementById('zoos-section')
)

render(
    <AnimalSection />,
    document.getElementById('animals-section')
)
