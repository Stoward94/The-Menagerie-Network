package menagerienetwork.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "zoo_animal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZooAnimal.findAll", query = "SELECT z FROM ZooAnimal z")
    , @NamedQuery(name = "ZooAnimal.findById", query = "SELECT z FROM ZooAnimal z WHERE z.id = :id")
    , @NamedQuery(name = "ZooAnimal.findByPetName", query = "SELECT z FROM ZooAnimal z WHERE z.petName = :petName")})
public class ZooAnimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pet_name")
    private String petName;
    
    @Column(name = "age_months")
    private Integer ageMonths;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "male")
    private boolean male;
    
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Animal animalId;
    
    @JoinColumn(name = "zoo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Zoo zooId;

    public ZooAnimal() {}

    public ZooAnimal(Integer id, String petName, boolean male) {
        this.id = id;
        this.petName = petName;
        this.male = male;
    }

    //Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(Integer ageMonths) {
        this.ageMonths = ageMonths;
    }

    public boolean getMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
    }

    public Zoo getZooId() {
        return zooId;
    }

    public void setZooId(Zoo zooId) {
        this.zooId = zooId;
    }    
}
