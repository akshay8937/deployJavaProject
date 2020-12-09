package com.app.propertymanagement.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="book_details")
public class BookDetail {
	
	
	private Long bookId;
	private Property bookedProperty;
	private Buyer buyerId;
	private Seller seller_Id;
	
	
	public BookDetail()
	{
		System.out.println("in booking detail const");
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(name="sequence",sequenceName = "hibseq",initialValue = 1,allocationSize = 1)
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	@OneToOne
	@JoinColumn(name="prop_id")
	public Property getBookedProperty() {
		return bookedProperty;
	}
	public void setBookedProperty(Property bookedProperty) {
		this.bookedProperty = bookedProperty;
	}
	
	@ManyToOne
	@JoinColumn(name="buyer_id")
	public Buyer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Buyer buyerId) {
		this.buyerId = buyerId;
	}
	@ManyToOne
	@JoinColumn(name="seller_id")
	public Seller getSeller_Id() {
		return seller_Id;
	}
	public void setSeller_Id(Seller sellerId) {
		this.seller_Id = sellerId;
	}
	@Override
	public String toString() {
		return "BookDetail [bookId=" + bookId + "]";
	}
}
