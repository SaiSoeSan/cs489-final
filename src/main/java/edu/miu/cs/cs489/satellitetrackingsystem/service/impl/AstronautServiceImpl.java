package edu.miu.cs.cs489.satellitetrackingsystem.service.impl;

import edu.miu.cs.cs489.satellitetrackingsystem.dto.request.AstronautRequestDto;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.response.AstronautResponseDto;
import edu.miu.cs.cs489.satellitetrackingsystem.mapper.AstronautMapper;
import edu.miu.cs.cs489.satellitetrackingsystem.model.Astronaut;
import edu.miu.cs.cs489.satellitetrackingsystem.model.Satellite;
import edu.miu.cs.cs489.satellitetrackingsystem.repo.AstronautRepo;
import edu.miu.cs.cs489.satellitetrackingsystem.repo.SatelliteRepo;
import edu.miu.cs.cs489.satellitetrackingsystem.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {
    private final AstronautMapper astronautMapper;
    private final AstronautRepo astronautRepo;
    private final SatelliteRepo satelliteRepo;

    @Override
    public AstronautResponseDto createAstronaut(AstronautRequestDto astronaut) {
        Astronaut a = astronautMapper.astronautRequestDtoToAstronaut(astronaut);
        return astronautMapper.astronautToAstronautResponseDto(astronautRepo.save(a));
    }

    @Override
    public List<AstronautResponseDto> getAllAstronauts() {
        return astronautRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName")).stream().map(astronautMapper::astronautToAstronautResponseDto).collect(Collectors.toList());
    }

    @Override
    public void assignSatellitetrack(Long astronautId, List<Long> satelliteIds) {
        Astronaut astronaut = astronautRepo.findById(astronautId)
                .orElseThrow(() -> new RuntimeException("Astronaut not found"));
        List<Satellite> satellites = satelliteRepo.findAllById(satelliteIds);
        astronaut.setSatellites(satellites); // Use custom setter
        astronautRepo.save(astronaut);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AstronautResponseDto> getAstronautsSortedByExperience(String sort) {
        // Determine sort direction (default to ascending)
        // Determine sort direction (default to ascending)
        Sort.Direction sortDirection = sort.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

        // Fetch sorted astronauts from the repository
        List<Astronaut> astronauts = astronautRepo.findAll(Sort.by(sortDirection, "experienceYears"));

        // Map entities to response DTOs using the mapper
        return astronauts.stream()
                .map(astronautMapper::astronautToAstronautResponseDto)
                .toList();
    }
}
