package edu.miu.cs.cs489.satellitetrackingsystem.dto.request;

public record AstronautRequestDto(
    String firstName,
    String lastName,
    Integer experienceYears
) {
}
