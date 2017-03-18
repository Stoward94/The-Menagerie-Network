import React from 'react';
import { AnimalSearch } from './animal-search.jsx';
import { AnimalBlocks } from './animal-blocks.jsx';
import { AnimalDetails } from './animal-details.jsx';

// import css
import './css/animal-section.css';

const processSearch = function(key, value){
    alert("hello: " + key);
}

export const AnimalSection = React.createClass({

    getInitialState: function() {
      return {
        searchTerm: '',
        showDefaultBlocks: true
       };
    },

    handleSearch(key){
      this.setState({
        animalId: key,
        showDefaultBlocks: key == ''
       })
    },

    render(){
      return (
          <div className = "container">
              <div className="row">
                  <div className="col-lg-8 col-lg-offset-2">
                      <div className="wow fadeInDown" data-wow-delay="0.1s">
                          <div className="section-heading text-center">
                              <h2 className="h-bold">"Animalium"</h2>
                              <span className="tiny-text">(Latin for Animal)</span>
                              <p>Discover our network of animals and learn the history of each unique species</p>
                          </div>
                      </div>
                  </div>
                  <div className="col-md-8 col-md-offset-2">
                      <div className="pad-b-80">
                          <AnimalSearch search={this.state.animalId}
                                        onSelect={this.handleSearch}/>
                      </div>
                  </div>
              </div>

                <div className="row">

                    {this.state.showDefaultBlocks ? (
                        <AnimalBlocks/>
                    ) : (
                        <AnimalDetails id={this.state.animalId}/>
                    )}
                </div>
          </div>
      )
    }

});
