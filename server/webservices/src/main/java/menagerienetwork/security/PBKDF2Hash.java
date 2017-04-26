package menagerienetwork.security;

/**
 * @author Luke Stoward
 */
public class PBKDF2Hash {
    
    private String hash;
    private String salt;
    
    public PBKDF2Hash(String hash, String salt){
        this.hash = hash;
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public String getSalt() {
        return salt;
    }
}
