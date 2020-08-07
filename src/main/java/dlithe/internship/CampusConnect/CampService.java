package dlithe.internship.CampusConnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampService 
{
	@Autowired
	CampusRepo repo;
	public Candidates insert(Candidates candidates)
	{
		return repo.save(candidates);
	}
}
