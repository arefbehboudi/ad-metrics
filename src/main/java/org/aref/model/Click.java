package org.aref.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Click {

    @JsonProperty("impression_id")
    private String impressionId;

    private double revenue;

}
