package menagerienetwork.webservices;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import menagerienetwork.annotations.RoleSecured;
import menagerienetwork.dataaccess.UserRepository;

/**
 * @author Luke Stoward
 */
@Stateless
@Path("administration")
public class AdministrationService {
    
    @PersistenceContext(unitName = "MenagerieNetwork")
    private EntityManager em;
    
    private UserRepository repo;
    
    public AdministrationService(){}
    
    @POST
    @Path("authenticate")
    @Consumes(MediaType.APPLICATION_JSON)    
    public Response login(RegisterRequest model) {
        
        repo = new UserRepository(em);
        boolean valid = repo.authenticateLogin(model.getEmail(), model.getPassword());
        
        if(valid){
            return Response.status(Response.Status.OK).build();
        }
        else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
    
    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)    
    @RoleSecured("admin")
    public Response register(RegisterRequest model) {       
        
        //Check the values
        if(!model.isValid()){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Please check the values provided")
                    .build();
        }
        
        repo = new UserRepository(em);
        boolean success = repo.registerUser(model);
        
        
        if(success){
            return Response.created(null).build();
        }
        
        //Return error
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("Unable to process the request")
                .build();
    }    
}
