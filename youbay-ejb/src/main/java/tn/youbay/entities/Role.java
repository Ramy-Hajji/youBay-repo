package tn.youbay.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Role implements Serializable {

	
	@Id
	private int idRole ; 
	private String role ;
	@OneToMany(mappedBy="role",cascade=CascadeType.PERSIST)
	private List<Account> list;
	
	public Role(){
		
	}
	
	public List<Account> getList() {
		return list;
	}

	public void setList(List<Account> list) {
		this.list = list;
	}

	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
