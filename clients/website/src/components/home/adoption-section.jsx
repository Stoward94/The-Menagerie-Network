
//ES6 Stateless Functional Component
//No State, No Props
const AdoptionSection = () => {
  return (
    <section id="animal-adoption" className="bg-gray pad-t-80 pad-b-80 mar-t-40">
    <div className="container">
      <div className="row">
        <div className="col-md-12">
          <div className="row">
            <div className="col-md-8">
              <div className="wow fadeInUp" data-wow-delay="0.1s">
                <h3 className="h-ultra">Every Wanted to Adopt an Animal?</h3>
                <p>By adopting an animal with the Menagerie Network you are helping support our conservation work worldwide, as well as help care for our animals at every single one of our zoos. In return you will receive a fantastic gift pack which can
                  be personalised.</p>
              </div>
            </div>
            <div className="col-md-4">
              <div className="wow lightSpeedIn" data-wow-delay="0.1s">
                <div className="pull-right">
                  <a href="#" className="btn btn-skin btn-lg">Find out more</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  );
};

export default  AdoptionSection;
