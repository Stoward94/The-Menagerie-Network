import React from 'react';
import ZooBox from './zoos-box.jsx';
import SpeciesBox from './species-box.jsx';
import ZooAnimalBox from './zoo-animal-box.jsx';

const Dashboard = () => {

  return (
    <div className="row">
      <div className="col-md-6">
        <ZooBox/>
      </div>
      <div className="col-md-6">
        <SpeciesBox/>
      </div>
      <div className="col-md-12">
        <ZooAnimalBox/>
      </div>
    </div>
  );

}

export default Dashboard;
