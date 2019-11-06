package interfservices;

import java.util.List;
import entities.Tache;

public interface TacheServiceRemote  {
	
  public void ajoutTache(Tache tache);
  
  public void affectTP(int tacheid, int projectid,int userid) ;
  
  public List <Tache> getLater();
  
 
  public List<Tache> alltasks();


}
