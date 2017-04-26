package menagerienetwork.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * @author Luke Stoward
 */
public class Authenticator implements IAuthenticator {

    @Override
    public PBKDF2Hash generateHash(String input, byte[] saltHash) {        
        try {
            int iterations = 100;
            char[] chars = input.toCharArray();                       
            byte[] salt;           
            
            //Are we generating a hash with an existing salt (to test)
            //or new salt
            if(saltHash == null){
                salt = generateSalt();
            }
            else{
                salt = saltHash;
            }
            
            PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 512);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = skf.generateSecret(spec).getEncoded();
            
            PBKDF2Hash hashResult = new PBKDF2Hash(
                    Base64.getEncoder().encodeToString(hash),
                    Base64.getEncoder().encodeToString(salt));
            
            return hashResult;
            
        } 
        catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(Authenticator.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @Override
    public byte[] generateSalt() {
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            sr.nextBytes(salt);
            return salt;
        }
        catch(NoSuchAlgorithmException ex){
            //Log error
            return null;
        }
    }

    @Override
    public boolean testHash(String input, String encodedHash, String encodedSalt) {
        Boolean isMatch;
        
        //Decode from its stored encoded base64 state.
        byte[] decodedSalt = Base64.getDecoder().decode(encodedSalt);
        
        //Generate hash from input
        PBKDF2Hash inputHash = generateHash(input, decodedSalt);
        
        //Does this match hash param?
        isMatch = inputHash.getHash().equals(encodedHash);
        
        return isMatch;
    }
    
}
