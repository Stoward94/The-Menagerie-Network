
//ES6 Stateless Functional Component
//No State, No Props
const StepsSection = () => {
  return (
    <section id="step-by-step" className="pad-t-80 pad-b-80 mar-t-40 bg-gray">
      <div className="container">
        <div className="row">
          <div className="col-md-4">
            <div className="wow fadeInUp" data-wow-delay="0.2s">
              <div className="text-center">
                <h1 className="num-circle-green">1</h1>
                <h4 className="h-bold">
                  <img src="/media/icons/tickets.png" width="32" style={{marginRight:"10px", marginTop:"-5px"}}/>
                  Book your tickets</h4>
                <p style={{fontSize: "18px"}}>
                  As a non-profit organisation, including a voluntary 10% donation in your ticket purchase makes a big difference and helps us continue our vital conservation work around the world.
                </p>
              </div>
            </div>
          </div>

          <div className="col-sm-4 col-md-4">
            <div className="wow fadeInUp" data-wow-delay="0.2s">
              <div className="text-center">

                <h1 className="num-circle-blue">2</h1>
                <h4 className="h-bold">
                  <img src="/media/icons/route.png" width="32" style={{marginRight:"10px", marginTop:"-5px"}}/>
                  Plan your day</h4>
                <p style={{fontSize: "18px"}}>
                  Plan your trip to any one of our zoos. Save time by getting directions when travelling by car, train or bus. Opening times vary at each zoo, so make sure to check the specific times for your trip.
                </p>
              </div>
            </div>
          </div>
          <div className="col-sm-4 col-md-4">
            <div className="wow fadeInUp" data-wow-delay="0.2s">
              <div className="text-center">
                <h1 className="num-circle-orange">3</h1>
                <h4 className="h-bold">
                  <img src="/media/icons/gift.png" width="32" style={{marginRight:"10px", marginTop:"-5px"}}/>
                  Shop for gifts</h4>
                <p style={{fontSize: "18px"}}>
                  You won't go home empty handed, with over 3000 unique and amazing animal-themed homeware, toys and gifts available for purchase; all while supporting our work with wildlife.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default  StepsSection;
