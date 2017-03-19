import React from 'react';
import { ZooBlock } from './zoo-block.jsx';

//temp usage of data
import zooData from '../zoos.json'


const fetchZooData = function(){
  //Perform ajax request to fetch JSON data
  //[Here]
}

export const ZooSection = React.createClass({

    getInitialState : function() {
        return {zoos: []}
    },

    componentDidMount : function() {
        //Set the initial state by fetching the data
        var _this = this;
        _this.setState({zoos: zooData});
    },

    componentWillUnmount : function() {
        this.serverRequest.abort();
    },

    render() {
      return (
              <div>
                  <div className="container mar-b-40">
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
                            <div className="col-md-4" key={index}>
                              <ZooBlock {...zoo}/>
                            </div>
                          )}

                      </div>
                  </div>
              </div>
            )
      }
});
