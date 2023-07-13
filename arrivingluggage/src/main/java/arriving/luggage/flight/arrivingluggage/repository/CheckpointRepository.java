package arriving.luggage.flight.arrivingluggage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import arriving.luggage.flight.arrivingluggage.model.Checkpoint;


@Repository
public interface CheckpointRepository extends JpaRepository<Checkpoint, Long> 
{
	@Query(value="SELECT checkpoint from Checkpoint "
			+ " where checkpointID = :checkpointID", nativeQuery=true)

	public Checkpoint findCheckpointById (@Param("checkpointID") 
		int checkpointID);
}
