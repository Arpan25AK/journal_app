package com.spring_boot_project.journalApp.api.response;

import java.util.List;

public class whetherResponse {
    public class Root{
        public Current current;
    }
    public class Current{

        public String observation_time;
        public int temperature;

    }






}
