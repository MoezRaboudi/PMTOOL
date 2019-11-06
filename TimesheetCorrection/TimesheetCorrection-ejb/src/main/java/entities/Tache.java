package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tache
 *
 */
@Entity

public class Tache implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Nom;
	private Date DateDeb;
	private Date DateFin;
	private int nbjour ;
	@Transient
	private String vr ;
	
	
	
	
	







	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
	
	
	

	

	


	



	@ManyToOne
     private Project project ;
	
	@ManyToOne
    private User user ;
	
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Tache(String nom, Date dateDeb, Date dateFin) {
		super();
		Nom = nom;
		DateDeb = dateDeb;
		DateFin = dateFin;
	}
	
	

	public Tache( String vr) {
		super();
		this.vr = vr;
	}
	
	
	
	public String getVr() {
		return vr;
	}
	public void setVr(String vr) {
		this.vr = vr;
	}
	public Tache() {
		super();
	}   
	public int getNbjour() {
		return nbjour;
	}
	public void setNbjour(int nbjour) {
		this.nbjour = nbjour;
	}
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getNom() {
		return this.Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}   
	public Date getDateDeb() {
		return this.DateDeb;
	}

	public void setDateDeb(Date DateDeb) {
		this.DateDeb = DateDeb;
	}   
	public Date getDateFin() {
		return this.DateFin;
	}

	public void setDateFin(Date DateFin) {
		this.DateFin = DateFin;
	}   
	
}
