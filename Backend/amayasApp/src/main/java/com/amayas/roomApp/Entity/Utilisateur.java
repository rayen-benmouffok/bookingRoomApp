package com.amayas.roomApp.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Utilisateur {
	
    
    private String userName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    
    
    public Utilisateur() {}
    
    public Utilisateur(String userName,String password) {
    	this.userName = userName;
    	this.password = password;
    }
   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    @PrePersist
    public void idInit() {
        if (id == null) {
            id = 0L; 
        }
        id++; 
    }
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return password;
	}
	public void setUserPassword(String password) {
		this.password = password;
	}

    
}