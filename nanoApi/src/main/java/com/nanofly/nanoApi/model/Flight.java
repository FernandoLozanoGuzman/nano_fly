package com.nanofly.nanoApi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Flight {

    @Id
    private Long id;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dayArrive;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dayExit;
    private LocalTime hourArrive;
    private LocalTime hourExit;
    private Airport airportOrigin;
    private Airport airportDestine;
    private Airplane airplane;
    private double price;
    private String seat;
    private Airline airline;
}
