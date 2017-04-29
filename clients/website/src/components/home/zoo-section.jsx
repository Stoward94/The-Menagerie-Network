import React from 'react';
import { ZooBlock } from './zoo-block.jsx';
import Config from 'config.json';

/**
 * This component is responsible for rendering a summary block for each
 * zoo in the network. A request is made fetching the data from the API,
 * before passing the data to a child component.
 */
export class ZooSection extends React.Component {

    constructor(){
      super();

      //Configure state
      this.state = { zoos: [] };

      this.getZooData();
    }

    getZooData(){
      //Make the GET request
      this.serverRequest = $.get(Config.apiZooBase, (result) => {
          this.setState({ zoos: result });
      });
    }

    componentWillUnmount() {
        this.serverRequest.abort();
    }

    render() {
      return (
            <section id="zoos-section">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-8 col-lg-offset-2">
                            <div className="wow lightSpeedIn" data-wow-delay="0.1s">
                                <div className="sec-heading text-center">
                                    <h2 className="h-bold">Explore The Menagerie Network</h2>
                                    <p>Discovery and meet all of the spectacular animals throughout our network</p>
                                </div>
                            </div>
                            <div className="divider-short"></div>
                        </div>
                    </div>
                </div>

                <div className="container">
                    <div className="row">

                        {this.state.zoos.map((zoo, index) =>
                          <div className="col-md-4 col-sm-6" key={index}>
                            <ZooBlock {...zoo}/>
                          </div>
                        )}

                    </div>
                </div>
            </section>
        )
    }
};
