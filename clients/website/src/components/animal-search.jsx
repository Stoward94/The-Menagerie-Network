import React from 'react';
import Select from 'react-select';
import Config from '../config.json';
import './css/animal-search.css'; // import css

/**
 * This component will display a search input field that provides
 * auto-complete functionality and has data drawn from the API. A third
 * party component is used to handle the 'Select' element.
 */
export class AnimalSearch extends React.Component{

  shouldComponentUpdate(){
    //Avoids the parent component updating this component.
    //Stops text input field being cleared.
    return false;
  }

  getOptions(input, callback){
    //Only search if an input is provided
    if(input == '')
      return callback(null, { options:[]});

    var url = Config.apiAnimalSearch + input

    $.get(url, (result) => {
      var options = [];

      result.map((a, index) => {
        options.push({ value: a.id, label: a.commonName })
      })

      callback(null, {options});
    });
  }

  render(){
    return <Select
              name="animal-search"
              asyncOptions={this.getOptions}
              onChange={this.props.onSelect}
            />
  }

}
