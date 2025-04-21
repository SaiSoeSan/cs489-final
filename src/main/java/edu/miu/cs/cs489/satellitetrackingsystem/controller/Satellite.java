package edu.miu.cs.cs489.satellitetrackingsystem.controller;


import edu.miu.cs.cs489.satellitetrackingsystem.dto.request.SatelliteRequestDto;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.response.SatelliteResponseDto;
import edu.miu.cs.cs489.satellitetrackingsystem.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class Satellite {

    private final SatelliteService satelliteService;

    @PutMapping("/{id}")
    SatelliteResponseDto updateSatellite(@PathVariable("id") Long id,
                                         @RequestBody SatelliteRequestDto s) {
        return satelliteService.updateSatellite(id,s);
    }


}
