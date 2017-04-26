package menagerienetwork.filters;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import menagerienetwork.annotations.RoleSecured;
import menagerienetwork.dataaccess.UserRepository;
import menagerienetwork.entities.User;
import menagerienetwork.security.Authenticator;
import menagerienetwork.security.IAuthenticator;

/**
 * This authentication filter focuses only on Role based access.
 * Roles based accessed is controlled and evaluated using the 'RolesAllowed'
 * annotation. This class only looks at annotations applied to the method, not
 * the class as well. If a web service method does NOT have the annotation, it
 * will NOT be intercepted and checked for authentication.
 * @author Luke Stoward
 */
public class AuthenticationFilter implements ContainerRequestFilter {
    
    private static final Response ACCESS_DENIED = 
            Response.status(Response.Status.UNAUTHORIZED).build();
    private static final Response ACCESS_FORBIDDEN = 
            Response.status(Response.Status.FORBIDDEN).build();
    
    @Context
    private ResourceInfo resourceInfo;
    
    @PersistenceContext(unitName = "MenagerieNetwork")
    private EntityManager em;
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
     
        //Get the target method
        Method method = resourceInfo.getResourceMethod();        
                
        //Test for the 'RolesAllowed' annotation
        if(method.isAnnotationPresent(RoleSecured.class))
        {
            //Get the authorization header
            final List<String> authorization = requestContext.getHeaders()
                    .get("Authorization");

            //If no authorization information present; block access
            if(authorization == null || authorization.isEmpty())
            {
                requestContext.abortWith(ACCESS_DENIED);
                return;
            }

            //Get encoded username and password
            final String encodedUserPassword = authorization.get(0)
                    .replaceFirst("Basic ", "");

            //Decode username and password
            String usernameAndPassword = new String(Base64.getDecoder()
                    .decode(encodedUserPassword));

            //Split username and password tokens
            final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
            final String username = tokenizer.nextToken();
            final String password = tokenizer.nextToken();
            
            //Get the specied roles annotated on the method
            RoleSecured rolesAnnotation = method.getAnnotation(RoleSecured.class);            
            Set<String> rolesSet = new HashSet<>(Arrays.asList(rolesAnnotation.value()));

            //Does this user have the access role?            
            if(!isUserAllowed(username, password, rolesSet))
            {
                requestContext.abortWith(ACCESS_DENIED);
            }
        }
    }   
    
    private boolean isUserAllowed(final String email, final String password, final Set<String> rolesSet)
    {                
        //Step 1. Fetch user from the database
        UserRepository repo = new UserRepository(em);
        User user = repo.getByEmail(email);
        
        //Does the user exist?
        if(user == null)
            return false;
         
        //Step 2. Use the provided password and test against the stored hash
        IAuthenticator auth = new Authenticator();
        boolean isMatch = auth.testHash(password, user.getPasswordHash(), user.getPasswordSalt());
        
        //If the password is wrong, deny access
        if(isMatch == false)
            return false;
        
        //Step 3. Check if the user is Authorised to access the resource
        for(String role : rolesSet){            
            if(role.toLowerCase().equals(user.getRole().toLowerCase())){
                return true;
            }
        }
        
        //User authenticated but NOT authorised!
        return false;
    }
}
