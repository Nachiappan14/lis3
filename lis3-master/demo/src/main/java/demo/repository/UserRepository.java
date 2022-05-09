package demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.model.SampleBean;
import demo.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,String>{


	Optional<User> findBytechnicianname(String name);

}
