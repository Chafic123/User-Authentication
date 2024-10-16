package com.Authent.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Authent.model.Userr;


@Repository
public interface UserRepo extends JpaRepository<Userr,Long> {
	
    Userr findByEmail(String email);
    boolean existsByEmail(String email);
    
}
