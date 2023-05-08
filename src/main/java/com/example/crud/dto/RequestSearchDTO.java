package com.example.crud.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestSearchDTO {
    private Integer page;
    private Integer size;
    private String sort;

}
