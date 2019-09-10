package com.LSB.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.LSB.Entity.Seat;
@Repository
public interface SeatRepo extends JpaRepository<Seat,Integer> {

}
