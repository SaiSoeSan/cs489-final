package edu.miu.cs.cs489.satellitetrackingsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    private int experienceYears;

    @ManyToMany
    @JoinTable(
            name = "astronaut_satellites",
            joinColumns = @JoinColumn(name = "astronaut_id"),
            inverseJoinColumns = @JoinColumn(name = "satellite_id")
    )
    private List<Satellite> satellites = new ArrayList<>();

    // Custom setter for satellites
    public void setSatellites(List<Satellite> satellites) {
        this.satellites.clear();
        if (satellites != null) {
            this.satellites.addAll(satellites);
        }
    }
}
