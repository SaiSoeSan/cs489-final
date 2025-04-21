package edu.miu.cs.cs489.satellitetrackingsystem.dto.request;

import java.time.LocalDate;

public record SatelliteRequestDto(
        String name,
        LocalDate launchDate,
        String orbitType
) {
}
