package edu.miu.cs.cs489.satellitetrackingsystem.service;

import edu.miu.cs.cs489.satellitetrackingsystem.dto.request.AstronautRequestDto;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.response.AstronautResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AstronautService {
    AstronautResponseDto createAstronaut(AstronautRequestDto a);
    List<AstronautResponseDto> getAllAstronauts();

    void assignSatellitetrack(Long astronautId, List<Long> satelliteIds);

    List<AstronautResponseDto> getAstronautsSortedByExperience(String sort);
}
