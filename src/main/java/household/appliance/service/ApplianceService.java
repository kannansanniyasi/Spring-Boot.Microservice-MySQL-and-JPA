package household.appliance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import household.appliance.entity.ApplianceEntity;
import household.appliance.repository.ApplianceRepository;
import household.appliance.utils.MessageUtils;

@Service
public class ApplianceService {
	
	@Autowired
	private ApplianceRepository applianceRepository;
	
	public List<ApplianceEntity> getApplianceInActiveList()
	{
		return applianceRepository.getApplianceInActiveList("N");
		
	}
	
	public List<ApplianceEntity> getApplianceActiveList()
	{
		return applianceRepository.getApplianceActiveList("Y");
		
	}

	public MessageUtils saveAppliance(ApplianceEntity appliance) {
		// TODO Auto-generated method stub
		String message="";
		try
		{
			applianceRepository.save(appliance);
			message="success";
		}catch(Exception e)
		{
			message="Erro :"+e.getMessage();	
		}
		MessageUtils msg=new MessageUtils();
		msg.setMessage(message);
		return msg;
	}
	
	public MessageUtils deleteAppliance(ApplianceEntity appliance) {
		// TODO Auto-generated method stub
		MessageUtils msg=new MessageUtils();
		try
		{
			applianceRepository.delete(appliance);
			msg.setMessage("success");
		}catch(Exception e)
		{
			e.printStackTrace();
			msg.setMessage("Error"+e.getMessage());
		}
		return msg;
	}
	
	public MessageUtils updateAppliance(ApplianceEntity appliance) {
		// TODO Auto-generated method stub
		MessageUtils msg=new MessageUtils();
		try
		{
			applianceRepository.updateAppliance(appliance);
			msg.setMessage("success");
		}catch(Exception e)
		{
			e.printStackTrace();
			msg.setMessage("Error"+e.getMessage());
		}
		return msg;
	}

	public MessageUtils chekDuplicate(ApplianceEntity appliance) {
		// TODO Auto-generated method stub
		MessageUtils msg=new MessageUtils();
		try
		{
			List<String> count=applianceRepository.checkAppliance(appliance.getSerialno(),appliance.getBrand(),appliance.getModel(),"Y");
			System.out.println("count is "+count.size());
			if(count.size()==0)
			{

				msg.setMessage("success");
			}else
			{
				msg.setMessage("exit");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			msg.setMessage("Error"+e.getMessage());
		}
		return msg;
	}

	public MessageUtils inActiveAppliance(ApplianceEntity appliance) {
		// TODO Auto-generated method stub
		MessageUtils msg=new MessageUtils();
		try
		{
			System.out.println("id :"+appliance.getId());
			applianceRepository.inActiveAppliance(appliance);
			msg.setMessage("success");
		}catch(Exception e)
		{
			e.printStackTrace();
			msg.setMessage("Error"+e.getMessage());
		}
		return msg;
	}

	public MessageUtils activeAppliance(ApplianceEntity appliance) {
		// TODO Auto-generated method stub
		MessageUtils msg=new MessageUtils();
		try
		{
			System.out.println("id :"+appliance.getId());
			applianceRepository.activeAppliance(appliance);
			msg.setMessage("success");
		}catch(Exception e)
		{
			e.printStackTrace();
			msg.setMessage("Error"+e.getMessage());
		}
		return msg;
	}

}
