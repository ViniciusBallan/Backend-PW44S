package br.edu.utfpr.pb.pw44s.server.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {

    @NotNull
    private Long addressId;

    @NotEmpty
    @Valid
    private List<OrderItemRequestDTO> items;
}
