package menagerienetwork.webservices;

import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A data transfer class, used to combine an animal species, with 
 * the locations of where it can be found.
 * @author Luke Stoward
 */
@XmlRootElement
public class Species {
    
    
    private Integer id;
    private String commonName;
    private String scientificName;
    private String order;
    private String family;
    private String genus;
    private String species;
    private String origin;
    private String imageUrl;
    private String description;
    private Collection<String> ZooNames;
    
    public Species(){}

    public Species(Integer id, String commonName, String scientificName, String order, String family, String genus, String species, String origin, String imageUrl, String description) {
        this.id = id;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.order = order;
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.origin = origin;
        this.imageUrl = imageUrl;
        this.description = description;
    }
    
    

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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<String> getZooNames() {
        return ZooNames;
    }

    public void setZooNames(Collection<String> ZooNames) {
        this.ZooNames = ZooNames;
    }
    
    
}
