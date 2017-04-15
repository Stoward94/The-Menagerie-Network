package menagerienetwork.webservices;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Luke Stoward
 */
@XmlRootElement
public class AnimalSearchResult{
    
    private Integer id;
    private String commonName;
    private String scientificName;
    
    public AnimalSearchResult(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }
}
