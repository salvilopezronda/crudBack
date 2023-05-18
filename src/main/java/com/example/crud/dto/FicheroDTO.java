package com.example.crud.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FicheroDTO {
    private String nombreArchivo;
    private byte[] archivo;
}
