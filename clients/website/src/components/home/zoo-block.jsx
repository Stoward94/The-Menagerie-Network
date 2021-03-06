//import css
import './css/zoo-block.css'

//Stateless functional component
//Used as sub component to render a zoo location block
export const ZooBlock = (props) => (

    <div className="loc-block wow fadeInUp" data-wow-delay="0.1s">
        <div className="loc-block-header-img">
            <img className="img-responsive" src={props.thumbnailUrl}/>
        </div>

        <div className="loc-block-body">
            <h4 className="loc-block-h">{props.name}</h4>
            <span>{props.summary}</span>
        </div>
        <a href={props.siteUrl} target="_blank">
            <div className="loc-block-footer">
                <span>
                    <i className="fa fa-map-marker"></i>
                </span>
                <span style={{paddingLeft:"10px" }}>
                    <b>Visit</b>
                </span>
                <span className="loc-block-arrow">
                    <i className="fa fa-angle-right" aria-hidden="true"></i>
                </span>
            </div>
        </a>
    </div>

)
