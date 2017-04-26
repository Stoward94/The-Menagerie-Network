package menagerienetwork.webservices;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import menagerienetwork.annotations.RoleSecured;
import menagerienetwork.dataaccess.UserRepository;

/**
 * @author Luke Stoward
 */
@Path("administration")
public class AdministrationService {
    
    @PersistenceContext(unitName = "MenagerieNetwork")
    private EntityManager em;
    
    private UserRepository repo;
    
    public AdministrationService(){}
    
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
