package implservices;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Message;
import entities.Tache;
import entities.User;
import interfservices.UserServiceRemote;

@Stateless
@LocalBean
public class UserService implements UserServiceRemote {
	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em ;
	
	private int id ;

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	@Override
	public void ajouterUser(User user) 
	{

		em.persist(user);
	}
	
	
	
	
	public List<Tache> getProjetByUser(int id) 
	{
		User user = em.find(User.class, id);
		
		return user.getTaches() ;
	}
	public List<Message> getMessageByUser(int id) 
	{
		User user = em.find(User.class, id);
		
		return user.getMessages() ;
	}
	
	public User getLogin(String Login, String Mdp) {
		TypedQuery<User> query= em.createQuery("Select e from User e " + "where e.Login=:Login and "+"e.Mdp=:Mdp", User.class);
		query.setParameter("Login", Login);
		query.setParameter("Mdp", Mdp);
		User user = null;
		try{
			user = query.getSingleResult();
			id=user.getId();
		}
		catch(NoResultException e){
			Logger.getAnonymousLogger().info("Not found");
		}
		return user;
	}
	
	
	public List<User> getAllUser1()
	{
		
    List<User> users =  em.createQuery("from User").getResultList();
		
		
		
		
			
			
		
		return em.createQuery("from User").getResultList();
	}

	
	public List<User> getAllUsers()
	{
		return em.createQuery("from User").getResultList();
	}




	
	

}
