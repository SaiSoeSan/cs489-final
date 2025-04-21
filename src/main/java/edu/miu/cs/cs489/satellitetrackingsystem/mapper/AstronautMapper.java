package edu.miu.cs.cs489.satellitetrackingsystem.mapper;

import edu.miu.cs.cs489.satellitetrackingsystem.dto.request.AstronautRequestDto;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.response.AstronautResponseDto;
import edu.miu.cs.cs489.satellitetrackingsystem.model.Astronaut;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AstronautMapper {
    Astronaut astronautRequestDtoToAstronaut(AstronautRequestDto astronaut);
    AstronautResponseDto astronautToAstronautResponseDto(Astronaut astronaut);
}
