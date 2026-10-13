package br.edu.utfpr.pb.pw44s.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "tb_address")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String street;

    @NotNull
    private String number;

    @NotNull
    private String neighborhood;

    private String complement;

    @NotNull
    private String cep;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
