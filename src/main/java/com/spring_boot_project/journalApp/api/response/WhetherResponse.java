package com.spring_boot_project.journalApp.api.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WhetherResponse {

    private Current current;

    @Getter
    @Setter
    public static class Current {

        private int temperature;

        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;

    }
}
//learnt about get and post call to a external api using the rest template or code through spring boot rather then the post man method and understood the diff bw component and service annotation