package org.sixtynine.stock.entity;

/**
 * @author Thilan
 * this class user self relation ship
 */


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "USER")
public class User extends BaseEntity{

	private int id;
	
	@Size(min=2, max=100) 
	private String userName;
	
	@Size(min=6, max=25) 
	private String password;
	private String comfromPassword;
	
	@NotEmpty @Email
	private String email;
	
	@Size(min=10) 
	private String telephone;
	private String address;
	private UserCategory userCategory;
	private User owner;
	private Set<User> clients ;
	private Set<Payment> payment ;
	
	public User() {
	}

	public User(String name) {
		this.userName = name;
	}
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "USER_NAME", nullable = false, length = 100)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD", nullable = false, length = 400)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "EMAIL", nullable = false, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "TELEPHONE", nullable = false, length = 100)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "ADDRESS", nullable = false, length = 400)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (id==((User)obj).getId());
	}

    /**
	 * this is one to many relationship many side. this mapped with UserCategory class and join with table column
	 */  
	@ManyToOne  
	@JoinColumn(name = "CATEGORY_ID")
	public UserCategory getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}

	/**
	 * this annotation user to self references.
	 * 
	 * */
	@ManyToOne(cascade={CascadeType.ALL}) 
	@JoinColumn(name = "OWER_ID")
	public User getOwner() {
		return owner;
	}

	public void setOwner(User user) {
		this.owner = user;
	}

	@OneToMany(mappedBy = "clients") 
	public Set<User> getClients() {
		return clients;
	}

	public void setClients(Set<User> users) {
		this.clients = users;
	}

	@OneToMany(mappedBy = "user")  
	public Set<Payment> getPayment() {
		return payment;
	}

	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}
	
	
	public String getComfromPassword() {
		return comfromPassword;
	}

	public void setComfromPassword(String comfromPassword) {
		this.comfromPassword = comfromPassword;
	}

}
