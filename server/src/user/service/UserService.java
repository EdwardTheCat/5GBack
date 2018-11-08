package user.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;
import java.time.LocalDate;

import user.business.User;
import user.dao.DaoUser;


@Path("/user")
public class UserService {

	@Context
	private UriInfo uriInfo;

	private DaoUser daoUser;


	@GET
	@Path("/{name}/{firstname}/{mail}/{password}/{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public void getUser (@PathParam("name") String name, @PathParam("firstname") String firstname,
			@PathParam("mail") String mail, @PathParam("password") String password, @PathParam ("login") String login) throws SQLException {
		User user = new User();
		user.setId(0);
		user.setName(name);
		user.setFirstname(firstname);
		user.setMail(mail);
		user.setPassword(password);
		user.setCreationDate(LocalDate.now());
		user.setLogin(login);
		
		daoUser.createUser(user);
	}


}


