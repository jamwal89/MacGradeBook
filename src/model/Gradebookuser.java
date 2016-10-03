package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRADEBOOKUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Gradebookuser.findAll", query="SELECT g FROM Gradebookuser g")
public class Gradebookuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userid;

	private String username;

	private String userpassword;

	private String userrole;

	public Gradebookuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUserrole() {
		return this.userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

}