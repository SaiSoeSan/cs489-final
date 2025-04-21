package edu.miu.cs.cs489.satellitetrackingsystem.mapper;

import edu.miu.cs.cs489.satellitetrackingsystem.model.Satellite;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.request.SatelliteRequestDto;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.response.SatelliteResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SatelliteMapper {
    Satellite satelliteRequestDtoToSatellite(SatelliteRequestDto satellite);
    SatelliteResponseDto satelliteToSatelliteResponseDto(Satellite satellite);
}
