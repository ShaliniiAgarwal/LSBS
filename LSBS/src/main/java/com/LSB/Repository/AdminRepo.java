package com.LSB.Repository;
import com.LSB.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
	Object findByNameAndPassword(String name, String password);

}
