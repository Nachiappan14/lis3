package demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.model.Report;
@Repository
public interface ReportRepository extends JpaRepository<Report,String>{

	@Query(value = "SELECT * FROM reports s WHERE s.sample_id=:sample_id",nativeQuery=true)

	Optional<Report> findBySampleid(String sample_id);

}
