package demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.SampleBean;
@Repository
public interface SampleRepository extends JpaRepository<SampleBean,String>{
	Optional<SampleBean> findByuid(String sample_id);
}

