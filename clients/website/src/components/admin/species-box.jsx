import React from 'React';
import Config from 'config.json';

export default class SpeciesBox extends React.Component {

  constructor(props) {
    super(props);

    this.state = { species: [] };
  }

  componentDidMount(){
    this.serverRequest = $.get(Config.apiSpeciesBase, (result) => {
        this.setState({ species: result });
    });
  }

  render() {
    return (
      <div className="panel panel-default">
        <div className="panel-body">
          <div>Animal Species</div>
          <hr style={{marginTop:"5px"}}/>
          <ul>
            {this.state.species.map((species, index) =>
              <li key={index}>{species.commonName}</li>
            )}
          </ul>
        </div>
      </div>
    );
  }

}
