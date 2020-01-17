package com.kristal.demo.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
public class Users {

    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private Long id; 
    
    @Column(name="USER_NAME")
    private String userName;


    @Column(name="PASSWORD")
    private String password;


    @Column(name="EMAIL")
    private String email;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;


    @Column(name="DATE_OF_BIRTH")
    @JsonFormat(pattern="dd-MM-yyyy")    
    private Date dateOfBirth;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId", referencedColumnName = "id")
    private Role role;
    
    
    public Users() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
    
    
}
