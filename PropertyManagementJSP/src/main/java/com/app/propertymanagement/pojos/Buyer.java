package com.app.propertymanagement.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="buyers")
public class Buyer {
	
	private Long bid;
	@NotNull(message = "Name must be supplied")
	private String name;
	@NotNull(message="Password can not be empty")
	@Length(min = 4,max=10,message="Password is greater than 4 character and less than 4")
	private String password;
	@NotNull(message = "Address must be supplied")
	private String address;
	@NotNull(message = "phone no is required")
	@Length(min = 10,max=10,message = "Invalid phone no")
	private String mobNo;
	@NotNull(message="Email must be supplied")
	@Email(message = "Invalid email format")
	private String email;
	
	private String role;
	


	List <BookDetail> bookedproperties= new ArrayList<>();
	
	
	public Buyer()
	{
		System.out.println("in buyer const");
	}

	@OneToMany(mappedBy = "buyerId",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<BookDetail> getBookedproperties() {
		return bookedproperties;
	}


	public void setBookedproperties(List<BookDetail> bookedproperties) {
		this.bookedproperties = bookedproperties;
	}


	public Buyer(Long bid, String name, String password, String address, String mobNo, String email) {
		super();
		//this.bid = bid;
		this.name = name;
		this.password = password;
		this.address = address;
		this.mobNo = mobNo;
		this.email = email;
	}
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(name="sequence",sequenceName = "hibseq",initialValue = 1,allocationSize = 1)
	@Column(name="b_id")
	public Long getBid() {
		return bid;
	}


	public void setBid(Long bid) {
		this.bid = bid;
	}
	@Column(name="username",nullable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Transient
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Column(length = 6,unique = true,nullable = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(length=10)
	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Buyer [bid=" + bid + ", name=" + name + ", password=" + password + ", address=" + address + ", mobNo="
				+ mobNo + ", email=" + email + "role=" + role + "]";
	}
	

}
