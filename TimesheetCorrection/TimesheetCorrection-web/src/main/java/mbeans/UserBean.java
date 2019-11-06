package mbeans;

import java.util.List;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Message;
import entities.Tache;
import entities.User;
import implservices.UserService;

@ManagedBean
@SessionScoped
public class UserBean
{
	private int Id;
	private String Nom;
	private String Role;
	private String Prenom;
	private String Login;
	private String Mdp;
	private User user;
	
	private List<Tache> taches ;
	private List<Message> messages ;

	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Tache> getTaches() {
		return taches;
	}
	

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	@EJB
	UserService userservice ;
	
	
	
	public List<Tache> getProjetByUser(int id)
	{
		taches = userservice.getProjetByUser(id) ;
		
		return taches ;
		
	}
	public List<Message> getMessagebyuser(int id)
	{
		messages = userservice.getMessageByUser(id) ;
		
		return messages ;
		
	}
	
	
	public String addUser()
	{
		String navigateTo="null";

		
		userservice.ajouterUser(new User(Nom, "Member", Prenom, Login, Mdp));

		//navigateTo = "/login?faces-redirect=true";
	navigateTo = "/Login?faces-redirect=true";
		return navigateTo;
	}
	
	public String doLogin(){
		String navigateTo="null";
		user=userservice.getLogin(Login, Mdp);
		   if (user !=null){
		   
		    Id=user.getId();
		   
		   
		   
		   
		if (user.getRole().equals("Member")){
		navigateTo="/myprojects?faces-redirect=true";
		}

		if (user.getRole().equals("TeamLeader")){
		navigateTo="/taskstate?faces-redirect=true";
		}
		   
		   }
		else {
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
		}
		return navigateTo;
		}

	public String doLogout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
		}


	 public String addTeamLeader()
	 {
	 String navigateTo="null";


	 userservice.ajouterUser(new User(Nom, "TeamLeader", Prenom, Login, Mdp));

	 navigateTo = "/Login?faces-redirect=true";
	 return navigateTo;
	 }

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getMdp() {
		return Mdp;
	}

	public void setMdp(String mdp) {
		Mdp = mdp;
	}

	

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	
}
