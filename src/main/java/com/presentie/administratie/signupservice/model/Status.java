package com.presentie.administratie.signupservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
public class Status {
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private boolean present;
    @JsonProperty(required = false)
    private Calendar date;

    public Status(String name, boolean present) {
        this.name = name;
        this.present = present;
        this.date = Calendar.getInstance();
        this.date.add(Calendar.DATE, 1);
    }
}
