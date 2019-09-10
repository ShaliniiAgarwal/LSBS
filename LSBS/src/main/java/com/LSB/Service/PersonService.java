package com.LSB.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LSB.Entity.Persons;
import com.LSB.Entity.Seat;
import com.LSB.Repository.PersonsRepo;
import com.LSB.Repository.SeatRepo;
@Service
public class PersonService {
@Autowired
private PersonsRepo personRepo;
@Autowired
private SeatRepo seatRepo;
	public  void SavePerson(Persons person) {
		personRepo.save(person);
	}
	public Collection<Persons> findAll() {
		List<Persons> persons= new ArrayList<>();
		for(Persons person:personRepo.findAll()) {
			persons.add(person);
		}		
		return persons;
	}
	public Persons findId(int id) {
		return  personRepo.findById(id).orElse(null);
	}
	public Seat findById(int id) {
		return seatRepo.findById(id).orElse(null);
	}
	public void SaveSeat(Seat seat) {
		seatRepo.save(seat);
		
	}
	
}
