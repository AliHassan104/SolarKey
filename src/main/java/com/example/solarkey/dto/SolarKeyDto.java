package com.example.solarkey.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class SolarKeyDto {

    private Long id;
    private  Double latitude;
    private  Double longitude;
    private  String location;

    private Double moduleDCNameplate;
    private Double moduleACNameplate;
    private Double loadRatio;
    private Double performanceRatio;

    private String projectDesigner;
    private Double totalAnnualSales;
    private Double tariff;
    private String projectName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date; //?
    private Double totalAnnualProduction;
    private Double averageDailyProduction;
    private String weatherDataset;

    private Double irridationVariance;
    private Double cellTemperatureSpread;
    private Double acSystemDerate;
    private String moduleCharacterisations;

    private Double kWhkWp;
    private String projectAddress;
    private Double averageDailySolarHours;
    private Integer numberOfTiles;
    private Double areaOfProject;

    private String moduleType;
    private Integer moduleCount;
    private String solarInverterType;
    private String cabling;
}
