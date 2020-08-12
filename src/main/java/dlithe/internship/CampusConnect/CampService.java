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
	public List<Candidates> fetchViaDepartment(String dept)
	{
		return repo.getByDepartment(dept);
	}
	public List<Candidates> fetchViaCareer(String career)
	{
		return repo.getByCareer(career);
	}
	public List<Candidates> fetchViaStatus(String status)
	{
		return repo.getByStatus(status);
	}
}