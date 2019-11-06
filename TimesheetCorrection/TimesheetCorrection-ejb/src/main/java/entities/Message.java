package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	private String Subject;
	private String Msg;


	
	
	
	public User getReceiver() {
		return receiver;
	}
	public User getSender() {
		return sender;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}



	

	public Message(String subject, String msg, User receiver, User sender) {
		super();
		Subject = subject;
		Msg = msg;
		this.receiver = receiver;
		this.sender = sender;
	}





	public Message(String subject, String msg) {
		super();
		Subject = subject;
		Msg = msg;
	}





	@ManyToOne
    private User receiver ;
	
	@ManyToOne
    private User sender ;
	
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}

	private static final long serialVersionUID = 1L;

	public Message() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}
   
}
