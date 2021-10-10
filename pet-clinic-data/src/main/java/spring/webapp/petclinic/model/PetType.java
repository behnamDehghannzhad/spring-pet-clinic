package spring.webapp.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "petTypes")
public class PetType extends BaseEntity{

    @Column(name = "name")
    private String name;
}
