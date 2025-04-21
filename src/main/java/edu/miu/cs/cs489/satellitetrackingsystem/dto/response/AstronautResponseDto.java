package edu.miu.cs.cs489.satellitetrackingsystem.dto.response;

import java.util.List;

public record AstronautResponseDto(
        Long id,
        String firstName,
        String lastName,
        List<Long> satelliteIds // List of Satellite IDs associated with the astronaut
) {}
