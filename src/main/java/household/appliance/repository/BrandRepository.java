package household.appliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import household.appliance.entity.BrandEntity;

@Transactional
@Repository
public interface BrandRepository extends CrudRepository<BrandEntity, Long> {
	
	@Query("from BrandEntity b where b.status=:status")
	public List<BrandEntity> getBrandList(@Param("status") String status);
}
