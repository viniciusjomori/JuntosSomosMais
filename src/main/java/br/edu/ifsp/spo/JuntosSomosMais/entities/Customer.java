package br.edu.ifsp.spo.JuntosSomosMais.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

import java.time.LocalDate;
import java.util.Set;

import br.edu.ifsp.spo.JuntosSomosMais.enums.CustomerTypeEnum;
import br.edu.ifsp.spo.JuntosSomosMais.enums.GenderEnum;
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
public class Customer {

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

    @Column
    private CustomerTypeEnum type;

    @Column
    private GenderEnum gender;

    @Column
    private String email;

    @Column
    private LocalDate birthday;

    @Column
    private LocalDate registered;

    @Column(length = 2)
    private String nacionality;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id", unique = true)
    private Name name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", unique = true)
    private Location location;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<TelephoneNumber> telephoneNumbers;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<MobileNumber> mobileNumbers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "picture_id", unique = true)
    private Picture picture;

}
