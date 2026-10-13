package br.edu.utfpr.pb.pw44s.server.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {

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
}
