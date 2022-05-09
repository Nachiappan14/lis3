package demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.Station;
import demo.model.StationBean;
@Repository
public interface StationRepository extends JpaRepository<StationBean,String>{


	Optional<StationBean> findBystationid(String stationid);

}
