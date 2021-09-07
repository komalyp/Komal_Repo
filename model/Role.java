package librarymanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
    @Column(name = "roleid")
	private int roleid;
	
	@Column(name = "name")
	private String name;

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleId) {
		this.roleid = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role() {
		
	}
	public Role(int roleid, String name) {
		super();
		this.roleid = roleid;
		this.name = name;
	}
	
	
}
