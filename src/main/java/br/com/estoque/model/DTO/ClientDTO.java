package br.com.estoque.model.DTO;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {

    private String nameClient;

    private String address;

    private String cpf;
}
