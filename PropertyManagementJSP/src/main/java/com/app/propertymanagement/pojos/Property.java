package com.app.propertymanagement.pojos;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="property_details")
public class Property {
	
	


	private Long propertyId;
	private String city;
	private String status="available";
	private String propType;
	private String description;
	private byte[] images;
	private double price;
	private String address;
	private Seller sellerId;
	BookDetail bookedProperties;
	{
		System.out.println("in Property pojo const");
	}
	
	public Property(Long propertyId, String city, String status, String propType, String description, byte[] images,
			double price, String address) {
		super();
		this.propertyId = propertyId;
		this.city = city;
		this.status = status;
		this.propType = propType;
		this.description = description;
		this.images = images;
		this.price = price;
		this.address = address;
	}
	
	public Property()
	{
		System.out.println("in Property constructor");
	}
	
	
	@OneToOne(mappedBy = "bookedProperty",cascade = CascadeType.ALL,orphanRemoval = true)
	public BookDetail getBookedProperties() {
		return bookedProperties;
	}



	public void setBookedProperties(BookDetail bookedProperties) {
		this.bookedProperties = bookedProperties;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(name="sequence",sequenceName = "hibseq",initialValue = 1,allocationSize = 1)
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	@Column(nullable = true)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="property_type",nullable = true)
	public String getPropType() {
		return propType;
	}
	public void setPropType(String propType) {
		this.propType = propType;
	}
	@Column(length=500,nullable = true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Lob
	public byte[] getImages() {
		return images;
	}
	public void setImages(byte[] images) {
		this.images = images;
	}
	@Column(nullable = true)
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column(nullable = true)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@ManyToOne
	@JoinColumn(name = "seller_id")
	public Seller getSellerId() {
		return sellerId;
	}
	
	public void setSellerId(Seller sellerId) {
		this.sellerId = sellerId;
	}
	
	
	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", city=" + city + ", status=" + status + ", propType=" + propType
				+ ", description=" + description + ", images=" + images + ", price=" + price + ", address=" + address
				+ "]";
	}

}
