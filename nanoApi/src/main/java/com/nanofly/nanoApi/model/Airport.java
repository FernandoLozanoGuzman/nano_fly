package com.nanofly.nanoApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Airport {

    @Id
    private Long id;
    private String nameAirport;
    private String city;
    private String codeIATA;
    private String location;
    private String image;
}
