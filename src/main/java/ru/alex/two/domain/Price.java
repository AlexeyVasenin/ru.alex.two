package ru.alex.two.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "price")
@NoArgsConstructor
public class Price {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "isactual")
    private Boolean isActual;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "description")
    private String description;

}
