package dlithe.internship.CampusConnect;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepo extends JpaRepository<Candidates, Long>
{
	@Query("from Candidates where department= :dep")
	public List<Candidates> getByDepartment(String dep);
	@Query("from Candidates where career= :car")
	public List<Candidates> getByCareer(String car);
	@Query("from Candidates where status= :state")
	public List<Candidates> getByStatus(String state);
}
