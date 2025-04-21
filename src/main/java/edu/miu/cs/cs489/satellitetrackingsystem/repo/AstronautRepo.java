package edu.miu.cs.cs489.satellitetrackingsystem.repo;

import edu.miu.cs.cs489.satellitetrackingsystem.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronautRepo extends JpaRepository<Astronaut, Long> {
}
