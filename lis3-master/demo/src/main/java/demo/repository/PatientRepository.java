package demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.PatientBean;
@Repository
public interface PatientRepository extends JpaRepository<PatientBean,String>{


	Optional<PatientBean> findByuid(String uid);

}
