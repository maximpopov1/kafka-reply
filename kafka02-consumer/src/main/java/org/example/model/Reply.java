package org.example.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reply {

    private String name;
    private Long value;

}
