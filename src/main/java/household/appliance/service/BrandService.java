package household.appliance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import household.appliance.entity.BrandEntity;
import household.appliance.repository.BrandRepository;

@Service
public class BrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	public List<String> getBrandList()
	{
		List<String> barndList=new ArrayList<String>();
		List<BrandEntity> brandEntity=brandRepository.getBrandList("Y");
		for(BrandEntity obj:brandEntity)
		{
			barndList.add(obj.getCode()+"-"+obj.getName());
		}
		return barndList;
		
	}

}
