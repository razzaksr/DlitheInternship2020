package dlithe.internship.CampusConnect;

import java.util.List;

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
	public List<Candidates> showAll()
	{
		return repo.findAll();
	}
	public Candidates readOne(Long regno)
	{
		return repo.getOne(regno);
	}
	public Candidates change(Candidates candidates)
	{
		return repo.save(candidates);
	}
	public String erase(Candidates candidates)
	{
		String get=candidates.getName();
		repo.delete(candidates);
		return get;
	}
}