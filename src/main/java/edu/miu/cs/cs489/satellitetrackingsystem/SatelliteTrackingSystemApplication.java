package edu.miu.cs.cs489.satellitetrackingsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.request.AstronautRequestDto;
import edu.miu.cs.cs489.satellitetrackingsystem.dto.request.SatelliteRequestDto;
import edu.miu.cs.cs489.satellitetrackingsystem.service.AstronautService;
import edu.miu.cs.cs489.satellitetrackingsystem.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class SatelliteTrackingSystemApplication {

    private final SatelliteService satelliteService;
    private final AstronautService astronautService;

    public static void main(String[] args) {
        SpringApplication.run(SatelliteTrackingSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            // Create Satellite Dataset
            SatelliteRequestDto[] satellites = new SatelliteRequestDto[]{
                    new SatelliteRequestDto(
                            "Hubble",
                            LocalDate.of(1990, 4, 24),
                            "LEO"
                    ),
                    new SatelliteRequestDto(
                            "Starlink-17",
                            LocalDate.of(2023, 8, 14),
                            "MEO"
                    ),
                    new SatelliteRequestDto(
                            "Sentinel-6",
                            LocalDate.of(2020, 11, 21),
                            "LEO"
                    )
            };

            // Create Astronaut Dataset
            AstronautRequestDto[] astronauts = new AstronautRequestDto[]{
                    new AstronautRequestDto("Neil", "Armstrong", 12),
                    new AstronautRequestDto("Sally", "Ride", 8),
                    new AstronautRequestDto("Chris", "Hadfield", 15)
            };

            //save satellites
            Long[] satellitesIds = Arrays.stream(satellites)
                    .map(d -> satelliteService.createSatellite(d).id())
                    .toArray(Long[]::new);

            Long[] astronautIds = Arrays.stream(astronauts)
                    .map((p) -> astronautService.createAstronaut(p).id())
                    .toArray(Long[]::new);

            // Assign relationships (Astronaut owns the relationship)
//            astronautService.assignSatellitetrack(astronautIds.get(0), List.of(satelliteIds.get(0), satelliteIds.get(1))); // Neil
//            astronautService.assignSatellitetrack(astronautIds.get(1), List.of(satelliteIds.get(1))); // Sally
//            astronautService.assignSatellitetrack(astronautIds.get(2), List.of(satelliteIds.get(0), satelliteIds.get(2))); // Chris

            // Print seeded data
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            System.out.println("Astronauts:");
            System.out.println(objectMapper.writeValueAsString(astronautService.getAllAstronauts()));

            System.out.println("Satellites:");
            System.out.println(objectMapper.writeValueAsString(satelliteService.getAllSatellites()));
        };


    }
}
