package edu.miu.cs.cs489.satellitetrackingsystem.dto.response;

import java.time.LocalDate;

public record SatelliteResponseDto(
   Long id,
   String name,
   LocalDate launchDate,
   String orbitType
) {}
