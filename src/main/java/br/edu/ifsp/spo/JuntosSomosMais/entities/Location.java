package br.edu.ifsp.spo.JuntosSomosMais.entities;

import br.edu.ifsp.spo.JuntosSomosMais.enums.RegionEnum;
import br.edu.ifsp.spo.JuntosSomosMais.enums.StateEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    private RegionEnum region;

    @Column(length = 100)
    private String street;

    @Column(length = 100)
    private String city;

    @Column
    private StateEnum state;

    @Column
    private Integer postcode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timezone_id")
    private Timezone timezone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinate_id", unique = true)
    private Coordinate coordinate;

}
