package dlithe.internship.CampusConnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
