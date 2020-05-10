package household.appliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import household.appliance.entity.ModelEntity;

@Transactional
@Repository
public interface ModelRepository extends CrudRepository<ModelEntity, Long> {
	
	@Query("from ModelEntity m where m.status=:status and m.brand=:brand")
	public List<ModelEntity> getModelList(@Param("status") String status,@Param("brand") String brand);
}
