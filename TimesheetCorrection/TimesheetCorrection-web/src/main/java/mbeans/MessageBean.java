package mbeans;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Message;

import entities.User;
import implservices.MessageService;

import implservices.UserService;

@ManagedBean
public class MessageBean 
{
	private int id;
	private int userid ;
	private int userid1 ;

	
	private String Subject;
	private String Msg;



	public int getUserid1() {
		return userid1;
	}

	public void setUserid1(int userid1) {
		this.userid1 = userid1;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	public int getSelectedmessageid() {
		return selectedmessageid;
	}

	public void setSelectedmessageid(int selectedmessageid) {
		this.selectedmessageid = selectedmessageid;
	}

	public List<User> getAllUsers1() {
		return userservice.getAllUsers() ;
	}


	public MessageService getMessageservice() {
		return messageservice;
	}

	public void setMessageservice(MessageService messageservice) {
		this.messageservice = messageservice;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}


	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	private int selectedmessageid ;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSelectedtacheid() {
		return selectedmessageid;
	}

	public void setSelectedtacheid(int selectedtacheid) {
		this.selectedmessageid = selectedtacheid;
	}

	
	@EJB
	MessageService messageservice ;
	
	
	
	@EJB
	UserService userservice ;
	
	UserBean userBean ;
	
	public String ajoutmessage(int id1,int id2)
	{
		String navigateTo="null";
		User usr = new User();
		User usr1 = new User();
		
		userid =id1;
		userid1=id2;

		usr.setId(userid);
		usr1.setId(userservice.getId());
		System.out.println("id*****"+userservice.getId());
		Message msg = new Message(Subject,Msg,usr,usr1);
		messageservice.envoyerMessageAUser(msg);
		return navigateTo;
	}
	public List<Message> toutemessage() 
	{
		return messageservice.toutemessage();
	}
	
	
	
	

	
	
	
	
	
	
	

	
	public List<User> getAllUsers() 
	{
		List<User> users = userservice.getAllUsers();
		List<User> userd = new ArrayList() ;


		int x =userservice.getId();

		for(User p :users)
		{
		if(p.getId() !=x)
		{
		userd.add(p) ;

		}

		}

		return userd ;
		}
	


	

}
