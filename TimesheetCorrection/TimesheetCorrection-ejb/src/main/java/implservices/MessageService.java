package implservices;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Message;
import entities.User;
import interfservices.MessageServiceRemote;

@Stateless
@LocalBean
public class MessageService implements MessageServiceRemote{
	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em ;
	
	public void envoyerMessageAUser(Message message)
	{
		
		em.persist(message);
	}
	public List<Message> toutemessage()
	{
		return em.createQuery("from Message").getResultList();
	}
	
	

	
	
}
