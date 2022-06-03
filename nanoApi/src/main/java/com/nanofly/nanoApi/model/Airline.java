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

public class Airline {

    @Id
    private Long id;
    private String name;
    private String image;
}
