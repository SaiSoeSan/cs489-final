package edu.miu.cs.cs489.satellitetrackingsystem.repo;

import edu.miu.cs.cs489.satellitetrackingsystem.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepo extends JpaRepository<Satellite, Long> {
}
