package com.LSB.Repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.LSB.Entity.Persons;
public interface PersonsRepo extends JpaRepository<Persons,Integer> {
	 @Query(value="SELECT COUNT(*) FROM person WHERE status='active'",nativeQuery=true)
	int countper();
  
	 @Query(value="SELECT checkout FROM Person",nativeQuery=true)
	 List<Date> checkout();

}
