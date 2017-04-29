//ES6 Stateless Functional Component
//No State, No Props
const GoogleMap = () => {
  return(
    <div className="map-container">

      {/* Placeholder for the google map */}
      <div id="map"></div>

      <div id="directions-info-panel" className="map-panel">
        <i className="fa fa-car" style={{position:"absolute", padding:"10px"}} aria-hidden="true"></i>
        <div style={{marginLeft:"40px"}}>
          <span id="route-notes"></span>
          <br/>
          <small><b id="route-time" style={{color:"#7db53b"}}></b></small>
          <br/>
          <small id="route-distance"></small>
        </div>
      </div>

    <div className="map-search form-inline">
      <div className="text-center">
        <h4 className="h-xlight" style={{marginBottom:"5px"}}>Want directions? No problem...</h4>
      </div>
      <img src="./media/icons/icon-directions.png" alt="directions-icon" width="64"/>
      <div className="form-group" style={{width:"40%", marginRight:"20px"}}>
        <input id="origin-input" className="form-control" type="text" placeholder="Enter a start location"/>
      </div>
      <div className="form-group" style={{width:"40%"}}>
        <select id="destination-select" className="form-control">
            <option selected disabled>-- Select the zoo you would like to visit --</option>
        </select>
      </div>

    </div>
  </div>
  );
};

export default GoogleMap;
