package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {

    private String name;
    private Long value;

}
