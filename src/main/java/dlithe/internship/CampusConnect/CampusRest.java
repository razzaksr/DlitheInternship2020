package dlithe.internship.CampusConnect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
}
