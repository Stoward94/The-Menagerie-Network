package menagerienetwork.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Luke Stoward
 */
@Entity
@Table(name = "zoo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zoo.findAll", query = "SELECT z FROM Zoo z")
    , @NamedQuery(name = "Zoo.findById", query = "SELECT z FROM Zoo z WHERE z.id = :id")
    , @NamedQuery(name = "Zoo.findByName", query = "SELECT z FROM Zoo z WHERE z.name = :name")})
public class Zoo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "site_url")
    private String siteUrl;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private BigDecimal latitude;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private BigDecimal longitude;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "postcode")
    private String postcode;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "summary")
    private String summary;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zooId")
    private Collection<ZooAnimal> zooAnimalCollection;

    public Zoo() {}

    public Zoo(Integer id, String name, String siteUrl, BigDecimal latitude, BigDecimal longitude, String postcode, String thumbnailUrl, String summary) {
        this.id = id;
        this.name = name;
        this.siteUrl = siteUrl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postcode = postcode;
        this.thumbnailUrl = thumbnailUrl;
        this.summary = summary;
    }
    
    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @XmlTransient
    public Collection<ZooAnimal> getZooAnimalCollection() {
        return zooAnimalCollection;
    }

    public void setZooAnimalCollection(Collection<ZooAnimal> zooAnimalCollection) {
        this.zooAnimalCollection = zooAnimalCollection;
    }    
}
