package com.partydetector.alert.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateAlertRequest {

    @NotBlank
    public String deviceId;

    @NotBlank
    public String location;

    @NotNull
    public Integer noiseLevel;

    public Integer duration;
}