package vargovcik.peter.datacollector.dto.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vargovcik.peter.datacollector.model.WeatherRecordModel;

import java.util.List;

@Repository
public interface WeatherRecordRepo extends JpaRepository<WeatherRecordModel, Long> {
    List<WeatherRecordModel> findAll();
}
