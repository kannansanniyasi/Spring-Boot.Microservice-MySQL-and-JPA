package household.appliance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import household.appliance.entity.ModelEntity;
import household.appliance.repository.ModelRepository;

@Service
public class ModelService {
	
	@Autowired
	private ModelRepository modelRepository;
	
	public List<String> getModelList(String brand)
	{
		List<String> modelL=new ArrayList<>();
		List<ModelEntity> modelList=modelRepository.getModelList("Y",brand);
		for(ModelEntity model:modelList)
		{
			modelL.add(model.getCode()+"-"+model.getName());
		}
		return modelL;
		
	}

}
