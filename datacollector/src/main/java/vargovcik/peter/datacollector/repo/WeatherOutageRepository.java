package vargovcik.peter.datacollector.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vargovcik.peter.datacollector.model.OutageModel;
import vargovcik.peter.datacollector.model.WeatherRecordModel;

@Repository
public interface WeatherOutageRepository extends JpaRepository<OutageModel, Long> {
}