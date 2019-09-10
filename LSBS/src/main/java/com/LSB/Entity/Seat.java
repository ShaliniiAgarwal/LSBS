package com.LSB.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="seat")
public class Seat {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Column(name="seatno")
private int seatno;
public int getSeatno() {
	return seatno;
}
public void setSeatno(int seatno) {
	this.seatno = seatno;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
