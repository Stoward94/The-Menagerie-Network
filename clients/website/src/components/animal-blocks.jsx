const blockDefaults = [
  {
    commonName: "African Lion",
    latinName: "Panthera Leo",
    imageUrl: "media/animals/african-lion.jpg"
  },
  {
    commonName: "Bengal Tiger",
    latinName: "Panthera Tigris Tigris",
    imageUrl: "media/animals/bengal-tiger.jpg"
  },
  {
    commonName: "Emperor Penguin",
    latinName: "Aptenodytes Forsteri",
    imageUrl: "media/animals/emperor-penguin.jpg"
  },
  {
    commonName: "Bonobo",
    latinName: "Pan Paniscus",
    imageUrl: "media/animals/bonobo.jpg"
  },

];


//Stateless functional component
//Used as sub component to render a zoo location block
export const AnimalBlocks = () => (

  <div>
    {blockDefaults.map((animal, index) =>

      <div className="col-md-3" key={index}>
          <div className="ani-block wow fadeInUp" data-wow-delay="0.1s">
              <a href="#">
                  <div className="ani-block-header-img">
                      <img className="img-responsive" src={animal.imageUrl}/>
                  </div>
                  <div className="ani-block-h">
                      {animal.commonName}
                  </div>
                  <div className="ani-block-body">
                      "{animal.latinName}"
                  </div>
              </a>
          </div>
      </div>

    )}
  </div>





)
