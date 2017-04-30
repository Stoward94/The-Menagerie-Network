import React from 'React';
import Config from 'config.json';

export default class ZooBox extends React.Component {

  constructor(props) {
    super(props);

    this.state = { zoos: [] };
  }

  componentDidMount(){
    this.serverRequest = $.get(Config.apiZooBase, (result) => {
        this.setState({ zoos: result });
    });
  }

  render() {
    return (
      <div className="panel panel-default">
        <div className="panel-body">
          <div>Our Zoos</div>
          <hr style={{marginTop:"5px"}}/>
          <ul>
            {this.state.zoos.map((zoo, index) =>
              <li key={index}>{zoo.name}</li>
            )}
          </ul>
        </div>
      </div>
    );
  }

}
