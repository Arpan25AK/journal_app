package com.spring_boot_project.journalApp.api.response;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class whetherResponse {

    private Current current;

    public class Current {

        private int temperature;

        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;

    }
}
