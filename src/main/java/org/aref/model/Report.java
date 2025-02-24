package org.aref.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @JsonProperty("app_id")
    private int appId;

    @JsonProperty("country_code")
    private String countryCode;

    private int impressions;

    private int clicks;

    private double revenue;

    @JsonProperty("recommended_advertisers")
    private List<Integer> recommendedAdvertisers;
}
