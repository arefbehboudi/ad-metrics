package org.aref.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Impression {

    private String id;

    @JsonProperty("app_id")
    private int appId;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("advertiser_id")
    private int advertiserId;

}
