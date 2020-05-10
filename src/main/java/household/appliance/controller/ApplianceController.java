package household.appliance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import household.appliance.entity.ApplianceEntity;
import household.appliance.entity.BrandEntity;
import household.appliance.entity.ModelEntity;
import household.appliance.service.ApplianceService;
import household.appliance.service.BrandService;
import household.appliance.service.ModelService;
import household.appliance.utils.MessageUtils;

@CrossOrigin
@RestController
@RequestMapping("/appliance")
public class ApplianceController {

	@Autowired
	ApplianceService applianceServ;
	
	@Autowired
	BrandService barndServ;
	
	@Autowired
	ModelService modelServ;
	
	@RequestMapping(value="/brandList",method=RequestMethod.GET)
	public List<String> brandList()
	{
		System.out.println("BrandEntity is calling");
		return barndServ.getBrandList();
	}
	
	@RequestMapping(value="/modelList",method=RequestMethod.GET)
	public List<String> modelList(@RequestParam("brand") String brand)
	{
		System.out.println("modelList is calling"+brand);
		return modelServ.getModelList(brand.split("-")[0]);
	}
	@RequestMapping(value="/applianceList",method=RequestMethod.GET)
	public List<ApplianceEntity> getApplianceActiveList()
	{
		System.out.println("applianceList is calling");
		return applianceServ.getApplianceActiveList();
	}
	
	@RequestMapping(value="/applianceInactiveList",method=RequestMethod.GET)
	public List<ApplianceEntity> getApplianceInActiveList()
	{
		System.out.println("applianceInactiveList is calling");
		return applianceServ.getApplianceInActiveList();
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public MessageUtils saveAppliance(@RequestBody ApplianceEntity appliance)
	{
		System.out.println("saveAppliance is calling");
		return applianceServ.saveAppliance(appliance);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public MessageUtils updateAppliance(@RequestBody ApplianceEntity appliance)
	{
		System.out.println("updateAppliance is calling"+appliance.getSerialno());
		return applianceServ.updateAppliance(appliance);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.PUT)
	public MessageUtils deleteAppliance(@RequestBody ApplianceEntity appliance)
	{
		System.out.println("deleteAppliance is calling"+appliance.getSerialno());
		return applianceServ.deleteAppliance(appliance);
	}
	
	@RequestMapping(value="/inactive",method=RequestMethod.POST)
	public MessageUtils inActiveAppliance(@RequestBody ApplianceEntity appliance)
	{
		System.out.println("inActiveAppliance is calling"+appliance.getSerialno());
		return applianceServ.inActiveAppliance(appliance);
	}
	
	@RequestMapping(value="/active",method=RequestMethod.POST)
	public MessageUtils activeAppliance(@RequestBody ApplianceEntity appliance)
	{
		System.out.println("activeAppliance is calling"+appliance.getSerialno());
		return applianceServ.activeAppliance(appliance);
	}
	
	@RequestMapping(value="/checkValue",method=RequestMethod.POST)
	public MessageUtils chekDuplicate(@RequestBody ApplianceEntity appliance)
	{
		System.out.println("saveAppliance is calling");
		return applianceServ.chekDuplicate(appliance);
	}
	
	
}
