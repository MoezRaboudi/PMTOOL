package implservices;


import java.util.Date;
import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import entities.Project;
import entities.Tache;
import entities.User;
import interfservices.TacheServiceRemote;

@Stateless
@LocalBean
public class TacheService implements TacheServiceRemote {
	
	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em ;
	
	
	private long ret ;
	
	private String retardch ;


	public String getRetardch() {
		return retardch;
	}

	public void setRetardch(String retardch) {
		this.retardch = retardch;
	}

	@Override
	public void ajoutTache(Tache tache) {
		
		em.persist(tache);
	

	}
	
	public List<Tache> alltasks()
	{
		return em.createQuery("from Tache").getResultList();
	}
	
	
	public long getRet() {
		return ret;
	}

	public void setRet(long ret) {
		this.ret = ret;
	}

	public List<Tache> getLater()
	{
		List<Tache> ts =  em.createQuery("from Tache").getResultList();

		
		
		Date nw = new  Date();
		
		
		for(Tache t : ts)
		{
			
		
			long retard = nw.getTime() - t.getDateFin().getTime() ; 
			
			ret = retard / (1000*60*60*24) ; 
			
			t.setNbjour((int)ret);
			
			if(t.getNbjour()>0)
			{
				t.setVr("Terminée il ya" +" "+ ret +" "+ "jour(s)");
			
			}
			
			
			else if(t.getNbjour()==0)
			{
				t.setVr("Terminée Aujourd'hui");
			
			}
			
			else if(t.getNbjour() <0)
			{
				t.setVr("Pas encore Terminée" );
				
			}
		}
			
		
		
		
		return ts ;
	}
	
	
	
	
	
	public void affectTP(int tacheid, int projectid,int userid)
	{
		Tache t = em.find(Tache.class, tacheid);
		Project p = em.find(Project.class, projectid);
		User u = em.find(User.class, userid);
		t.setUser(u);
		t.setProject(p);
	}


	
	
	
	


}
