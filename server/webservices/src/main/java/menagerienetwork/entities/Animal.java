package menagerienetwork.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Luke Stoward
 */
@Entity
@Table(name = "animal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a")
    , @NamedQuery(name = "Animal.findById", query = "SELECT a FROM Animal a WHERE a.id = :id")
    , @NamedQuery(name = "Animal.findByCommonName", query = "SELECT a FROM Animal a WHERE a.commonName = :commonName")
    , @NamedQuery(name = "Animal.findByCommonScientificName" , query = "SELECT a FROM Animal a WHERE a.commonName LIKE :search OR a.scientificName LIKE :search")})
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "common_name")
    private String commonName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "scientific_name")
    private String scientificName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "\"order\"")//Note escaped characters, reserved word in sql
    private String order;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "family")
    private String family;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "genus")
    private String genus;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "species")
    private String species;
    
    @Size(max = 45)
    @Column(name = "origin")
    private String origin;
    
    @Size(max = 100)
    @Column(name = "image_url")
    private String imageUrl;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 750)
    @Column(name = "description")
    private String description;
    
    
    public Animal() {} 
    
    public Animal(Integer id) {
        this.id = id;
    } 

    public Animal(Integer id, String commonName, String scientificName, String order, String family, String genus, String species, String description) {
        this.id = id;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.order = order;
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.description = description;
    }

    //Getters & Setters
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

    /**
     * Validates the class instance ensuring all data necessary 
     * for persistence is present.
     * @return Whether the entity is valid
     */
    public boolean isValid() {
        
        boolean valid = !commonName.isEmpty();
        valid = valid && !scientificName.isEmpty();
        valid = valid && !order.isEmpty();
        valid = valid && !family.isEmpty();
        valid = valid && !genus.isEmpty();
        valid = valid && !species.isEmpty();
        valid = valid && !description.isEmpty();
        
        return valid;
    }
}
