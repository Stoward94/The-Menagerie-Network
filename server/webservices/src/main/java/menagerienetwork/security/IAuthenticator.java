package menagerienetwork.security;

/**
 * @author Luke Stoward
 */
public interface IAuthenticator {
    
    PBKDF2Hash generateHash(String input, byte[] salt);
    byte[] generateSalt();
    boolean testHash(String input, String encodedHash, String encodedSalt);
    
}
