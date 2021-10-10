package spring.webapp.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "petType")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
