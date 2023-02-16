package ru.alex.two.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import javax.persistence.*;


// @JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @JsonProperty("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "\\+7[0-9]{10}", message = "Телефонный номер должен начинаться с +7, затем " +
            "-" +
            " 10 цифр")
    @Column(name = "number")
    private String number;

    @Column(name = "idd")
    private Integer idd;
}
