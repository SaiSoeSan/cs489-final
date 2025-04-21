package edu.miu.cs.cs489.satellitetrackingsystem.service.impl;

import edu.miu.cs.cs489.satellitetrackingsystem.dto.response.AstronautResponseDto;
import edu.miu.cs.cs489.satellitetrackingsystem.model.Satellite;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.request.SatelliteRequestDto;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.response.SatelliteResponseDto;
import edu.miu.cs.cs489.satellitetrackingsystem.mapper.SatelliteMapper;
import edu.miu.cs.cs489.satellitetrackingsystem.repo.SatelliteRepo;
import edu.miu.cs.cs489.satellitetrackingsystem.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteRepo satelliteRepo;
    private final SatelliteMapper satelliteMapper;
    @Override
    public SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto s) {
        return null;
    }

    @Override
    public SatelliteResponseDto createSatellite(SatelliteRequestDto satellite) {
        Satellite s = satelliteMapper.satelliteRequestDtoToSatellite(satellite);
        return satelliteMapper.satelliteToSatelliteResponseDto(satelliteRepo.save(s));
    }

    @Override
    public List<SatelliteResponseDto> getAllSatellites() {
        return satelliteRepo.findAll(Sort.by(Sort.Direction.ASC, "name")).stream().map(satelliteMapper::satelliteToSatelliteResponseDto).collect(Collectors.toList());
    }
}
