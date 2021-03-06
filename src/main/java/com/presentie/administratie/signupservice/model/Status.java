package com.presentie.administratie.signupservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
public class Status {
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private boolean present;
    @JsonProperty(required = true)
    private LocalDate date;

    public Status(String name, boolean present) {
        this.name = name;
        this.present = present;
    }
}
