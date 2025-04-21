package edu.miu.cs.cs489.satellitetrackingsystem.service;

import edu.miu.cs.cs489.satellitetrackingsystem.dto.request.SatelliteRequestDto;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.response.AstronautResponseDto;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.response.SatelliteResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SatelliteService {
    SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto s);

    SatelliteResponseDto createSatellite(SatelliteRequestDto s);
    List<SatelliteResponseDto> getAllSatellites();
}
