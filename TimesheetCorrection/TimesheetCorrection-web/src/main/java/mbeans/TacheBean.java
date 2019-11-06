package mbeans;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import entities.Project;
import entities.Tache;
import entities.User;
import implservices.ProjectService;
import implservices.TacheService;
import implservices.UserService;

@ManagedBean
public class TacheBean 
{
	private int id;
	private String Nom;
	private Date DateDeb;
	private Date DateFin;
	private Date Date_fin_real;
	private Project project ;
	private int projectid;
	private int userid ;
	private int Difficulte ;
	private int enabled ;
	private int points ;
	
	
	private int max ;
	
	private String idprojmax ;
	
	private String idusmax ;
	
	private List<Tache> mymax ;



	
	private Long ret ;

	
	
	
	

	public Long getRet() {
		return ret;
	}

	public void setRet(Long ret) {
		this.ret = ret;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getIdprojmax() {
		return idprojmax;
	}

	public void setIdprojmax(String idprojmax) {
		this.idprojmax = idprojmax;
	}

	public String getIdusmax() {
		return idusmax;
	}

	public void setIdusmax(String idusmax) {
		this.idusmax = idusmax;
	}

	public List<Tache> getMymax() {
		return mymax;
	}

	public void setMymax(List<Tache> mymax) {
		this.mymax = mymax;
	}

	public TacheService getTacheservice() {
		return tacheservice;
	}

	public void setTacheservice(TacheService tacheservice) {
		this.tacheservice = tacheservice;
	}

	public ProjectService getProjectservice() {
		return projectservice;
	}

	public void setProjectservice(ProjectService projectservice) {
		this.projectservice = projectservice;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getDifficulte() {
		return Difficulte;
	}

	public void setDifficulte(int difficulte) {
		Difficulte = difficulte;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	private int selectedtacheid ;
	
	private int selectedprojectid ;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSelectedtacheid() {
		return selectedtacheid;
	}

	public void setSelectedtacheid(int selectedtacheid) {
		this.selectedtacheid = selectedtacheid;
	}

	public int getSelectedprojectid() {
		return selectedprojectid;
	}

	public void setSelectedprojectid(int selectedprojectid) {
		this.selectedprojectid = selectedprojectid;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	@EJB
	TacheService tacheservice ;
	
	@EJB
	ProjectService projectservice ;
	
	@EJB
	UserService userservice ;
	
	
	public String afftache(){
		String navigateTo="null";
	    tacheservice.affectTP(id, selectedprojectid,userid);
		return navigateTo;
	}
	


	
	
	public List<Tache> alltasks() 
	{
		return tacheservice.alltasks();
	}
	
	
	
	
	
	
	public List<Tache> getLater() {
		
		
		
		
	 return tacheservice.getLater();
		
		
		
	
	}
	
	public List<Project> getAllProjects() {
		return projectservice.getAllProject();
	}
	
	public List<User> getAllUsers() {
		return userservice.getAllUsers() ;
	}
	
	public String ajoutTache()
	{
         String navigateTo="null";

		
		
		tacheservice.ajoutTache(new Tache( Nom,  DateDeb, DateFin));

		
		return navigateTo;
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public Date getDateDeb() {
		return DateDeb;
	}
	public void setDateDeb(Date dateDeb) {
		DateDeb = dateDeb;
	}
	public Date getDateFin() {
		return DateFin;
	}
	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}
	public Date getDate_fin_real() {
		return Date_fin_real;
	}
	public void setDate_fin_real(Date date_fin_real) {
		Date_fin_real = date_fin_real;
	}
	
	

}
