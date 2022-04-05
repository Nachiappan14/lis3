package demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import demo.model.SampleBean;
@Repository
public interface SampleRepository extends JpaRepository<SampleBean,String>{
	Optional<SampleBean> findByuid(String sample_id);

	@Query(value = "SELECT * FROM sample s WHERE s.station_id=:station_id",nativeQuery=true)
	List<SampleBean> getbystationid(@Param("station_id")String station_id);
	}

