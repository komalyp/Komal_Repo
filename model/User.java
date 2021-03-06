package librarymanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
    @Column(name = "emailid")
	private String emailid;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "userid")
	private String userid;
	
	 @ManyToOne
		@JoinColumn(name = "roleid")
	private Role roleid;
	

	 public User() {
			
		}
		
	 
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Role getRoleid() {
		return roleid;
	}

	public void setRoleid(Role roleid) {
		this.roleid = roleid;
	}

	public User(String emailid, String firstname, String lastname, String password, String userid, Role roleid) {
		super();
		this.emailid = emailid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.userid = userid;
		this.roleid = roleid;
	}

	

	

	
	 
	 
}
