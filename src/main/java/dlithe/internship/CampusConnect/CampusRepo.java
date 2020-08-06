package dlithe.internship.CampusConnect;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepo extends JpaRepository<Candidates, Long>
{

}
