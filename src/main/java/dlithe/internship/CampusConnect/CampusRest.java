package dlithe.internship.CampusConnect;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampusRest 
{
	@Autowired
	CampService service;
	@PostMapping("/addViaBody")
	public Candidates insViaBody(@RequestBody Candidates candidates)
	{
		return service.insert(candidates);
	}
	@GetMapping("/display")
	public List<Candidates> listing()
	{
		return service.showAll();
	}
	@GetMapping(value="/displayAsXml",produces="application/xml")
	public List<Candidates> listingAsXml()
	{
		return service.showAll();
	}
	@PutMapping("/modify")
	public Candidates modify(@RequestBody Candidates candidates)
	{
		return service.change(candidates);
	}
	@DeleteMapping("/del")
	public String clean(@RequestBody Candidates candidates)
	{
		return service.erase(candidates);
	}
	@GetMapping("/fetch/{constrain}/{data}")// /fetch/department/Computers
	public List<Candidates> find(@PathVariable("constrain") String constrain,@PathVariable("data") String data)
	{
		List<Candidates> temp=new Vector<Candidates>();
		if(constrain.equalsIgnoreCase("regno"))
		{
			temp.add(service.readOne(Long.parseLong(data)));
		}
		else if(constrain.equalsIgnoreCase("department"))
		{
			temp=service.fetchViaDepartment(data);
		}
		else if(constrain.equalsIgnoreCase("career"))
		{
			temp=service.fetchViaCareer(data);
		}
		else if(constrain.equalsIgnoreCase("status"))
		{
			temp=service.fetchViaStatus(data);
		}
		return temp;
	}
	@GetMapping("/fetch/{constrain}/{data}/report/{format}")// /fetch/department/Computers/report/pdf
	public String finding(@PathVariable("constrain") String constrain,@PathVariable("data") String data,@PathVariable("format") String format)
	{
		List<Candidates> temp=new Vector<Candidates>();
		if(constrain.equalsIgnoreCase("regno"))
		{
			temp.add(service.readOne(Long.parseLong(data)));
		}
		else if(constrain.equalsIgnoreCase("department"))
		{
			temp=service.fetchViaDepartment(data);
		}
		else if(constrain.equalsIgnoreCase("career"))
		{
			temp=service.fetchViaCareer(data);
		}
		else if(constrain.equalsIgnoreCase("status"))
		{
			temp=service.fetchViaStatus(data);
		}
		return service.generate(temp, format);
	}
}
