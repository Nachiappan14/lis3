package demo.repository;
import java.util.Optional;
import java.util.Properties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import demo.model.SampleBean;
@Repository
public interface SampleRepository extends JpaRepository<SampleBean,String>{
	Optional<SampleBean> findByuid(String sample_id);
    
	@Query(value = "SELECT * FROM sample s WHERE s.station_id=:station_id",nativeQuery=true)
	List<SampleBean> getbystationid(@Param("station_id")String station_id);
	@Query(value = "SELECT * FROM sample s WHERE s.uid=:uid",nativeQuery=true)
	List<SampleBean> getbypatientid(@Param("uid")String station_id);
	@Query(value = "SELECT * FROM sample s WHERE s.sample_id=:sample_id",nativeQuery=true)
	List<SampleBean> getbysampleid(@Param("sample_id")String sample_id);
	@Query(value = "SELECT * FROM sample s WHERE s.rs_date=:rs_date",nativeQuery=true)
	List<SampleBean> getbydate(@Param("rs_date")LocalDate ld);
	@Query(value = "SELECT * FROM sample s",nativeQuery=true)
	List<SampleBean> getsamples();
	@Query(value = "SELECT * FROM sample s WHERE s.status=:station_id",nativeQuery=true)
	List<SampleBean> getsamplesbystationid(@Param("station_id")String station_id);
}

