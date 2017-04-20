package menagerienetwork.webservices;

/**
 * @author Luke Stoward
 */
public class NewZooAnimal {
    
    private String petName;
    private boolean male;
    private Integer ageInMonths;
    
    private Integer speciesId;
    private Integer zooId;
   
    public NewZooAnimal(){}

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Integer getAgeInMonths() {
        return ageInMonths;
    }

    public void setAgeInMonths(Integer ageInMonths) {
        this.ageInMonths = ageInMonths;
    }

    public Integer getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Integer speciesId) {
        this.speciesId = speciesId;
    }

    public Integer getZooId() {
        return zooId;
    }

    public void setZooId(Integer zooId) {
        this.zooId = zooId;
    }
    
    /**
     * Validates the class instance ensuring all data necessary 
     * for persistence is present.
     * @return Whether the entity is valid
     */
    public boolean isValid() {
        
        boolean valid = !petName.isEmpty();
        valid = valid && speciesId != null;
        valid = valid && zooId != null;
        
        return valid;
    }
    
}
