package edu.miu.cs.cs489.satellitetrackingsystem.controller;

import edu.miu.cs.cs489.satellitetrackingsystem.dto.request.AstronautRequestDto;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.response.AstronautResponseDto;
import edu.miu.cs.cs489.satellitetrackingsystem.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class Astronaut {
    private final AstronautService astronautService;

    @GetMapping
    public ResponseEntity<List<AstronautResponseDto>> getAstronauts(
            @RequestParam(defaultValue = "asc") String sort) {
        List<AstronautResponseDto> astronauts = astronautService.getAstronautsSortedByExperience(sort);
        return ResponseEntity.ok(astronauts);
    }

    @PostMapping
    ResponseEntity<AstronautResponseDto> createPatient(@RequestBody AstronautRequestDto a) {
        AstronautResponseDto created =  astronautService.createAstronaut(a);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }


}
