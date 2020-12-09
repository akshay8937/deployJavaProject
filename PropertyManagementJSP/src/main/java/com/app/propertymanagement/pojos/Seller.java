package com.app.propertymanagement.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Sellers")
public class Seller {
	
	private Long sid;
	@NotNull(message = "Name must be supplied")
	private String name;
	@NotNull(message="Password can not be empty")
	@Length(min = 4,max=10,message="Password is greater than 4 character and less than 10")
	private String password;
	@NotNull(message = "Address must be supplied")
	private String address;
	@NotNull(message = "phone no is required")
	@Length(min = 10,max=10,message = "Invalid phone no")
	private String mobNo;
	@NotNull(message = "Email must be supplied")
	@Email(message = "Invalid email format")
	private String email;
	private String role;
	private List<Property> properties = new ArrayList<>();
	
	
	public Seller()
	{
		System.out.println("in seller const");
	}
	
	
	public Seller(Long sid, String name, String password, String address, String mobNo, String email) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
		this.mobNo = mobNo;
		this.email = email;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(name="sequence",sequenceName = "hibseq",initialValue = 1,allocationSize = 1)
	@Column(name="s_id")
	public Long getSid() {
		return sid;
	}
	
	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", name=" + name + ", password=" + password + ", address=" + address + ", mobNo="
				+ mobNo + ", email=" + email + ",role=" + role + "]";
	}
	public void setSid(Long sid) {
		this.sid = sid;
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
	@OneToMany(mappedBy = "sellerId",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Property> getProperties() {
		return properties;
	}
	
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	// write a helper method to add student dtls to course & vice versa
		public void addProperty(Property p) {
			properties.add(p);// course ---> student
			p.setSellerId(this); // student ---> course
		}

		// write a helper method to remove student dtls from course & vice versa
		public void removeProperty(Property p) {
			properties.remove(p);// course -X-> student
			p.setSellerId(null);
		}

	
}
