package com.LSB.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Person")
public class Persons {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column(name="name")
private String name;
@Column(name="email")
private String email;
@Column(name="address")
private String address;
@Column(name="checkin")
private String checkin;
@Column(name="checkout")
private String checkout;
@Column(name="payment")
private String payment;
@Column(name="phoneno")
private String phoneno;
@Column(name="status")
private String status;
@Column(name="shift")
private String shift;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCheckin() {
	return checkin;
}
public void setCheckin(String checkin) {
	this.checkin = checkin;
}
public String getCheckout() {
	return checkout;
}
public void setCheckout(String checkout) {
	this.checkout = checkout;
}
public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}
public String getPhoneno() {
	return phoneno;
}
public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

public String getShift() {
	return shift;
}
public void setShift(String shift) {
	this.shift = shift;
}
public Persons() {

}
}
