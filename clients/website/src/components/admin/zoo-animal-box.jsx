import React from 'react';
import Config from 'config.json';

export default class ZooAnimalBox extends React.Component {

  constructor(props) {
    super(props);

    this.state = { animals: [] };
  }

  componentDidMount(){
    this.serverRequest = $.get(Config.apiAnimalBase, (result) => {
        this.setState({ animals: result });
    });
  }

  render() {
    return (
      <div className="panel panel-default">
        <div className="panel-body">
          <div>Animals at our zoos</div>
          <hr style={{marginTop:"5px"}}/>
          <table className="table">
            <thead>
              <tr>
                <th>Pet Name</th>
                <th>Species Common Name</th>
                <th>Zoo</th>
              </tr>
            </thead>
            <tbody>
              {this.state.animals.map((animal, index) =>
                <tr key={index}>
                  <td>{animal.petName}</td>
                  <td>{animal.species.commonName}</td>
                  <td>{animal.zoo.name}</td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    );
  }

}
