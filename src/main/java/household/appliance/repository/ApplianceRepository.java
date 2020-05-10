package household.appliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import household.appliance.entity.ApplianceEntity;

@Transactional
@Repository
public interface ApplianceRepository extends CrudRepository<ApplianceEntity, Long> {
	
	@Query("from ApplianceEntity a where a.status=:status")
	public List<ApplianceEntity> getApplianceActiveList(@Param("status") String status);
	
	@Query("from ApplianceEntity a where a.status=:status")
	public List<ApplianceEntity> getApplianceInActiveList(@Param("status") String status);

	@Modifying
	@Query("update ApplianceEntity a set a.serialno=:#{#appliance.getSerialno()},a.broughtdte=:#{#appliance.getBroughtdte()},"
			+ "  a.brand=:#{#appliance.getBrand()},a.model=:#{#appliance.getModel()},a.status=:#{#appliance.getStatus()} "
			+ " where a.id=:#{#appliance.getId()} ")
	public void updateAppliance(@Param("appliance") ApplianceEntity appliance);

	@Query("select distinct serialno from ApplianceEntity a where a.serialno=:serialno and a.brand=:brand"
			+ " and a.model=:model and a.status=:status")
	public List<String> checkAppliance(@Param("serialno") String serialno,
			@Param("brand") String brand,@Param("model") String model, @Param("status") String status);

	@Modifying
	@Query("update ApplianceEntity a set a.status='N' "
			+ " where a.id=:#{#appliance.getId()} ")
	public void inActiveAppliance(@Param("appliance") ApplianceEntity appliance);

	@Modifying
	@Query("update ApplianceEntity a set a.status='Y' "
			+ " where a.id=:#{#appliance.getId()} ")
	public void activeAppliance(@Param("appliance") ApplianceEntity appliance);
}
