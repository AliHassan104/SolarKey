package com.example.solarkey.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class SolarKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @Column(name = "`date`")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date;

    private Double totalAnnualProduction;
    private Double averageDailyProduction;
    private String weatherDataset;

    private Double irridationVariance;
    private Double cellTemperatureSpread;
    private Double acSystemDerate;
    private String moduleCharacterisations;

    @Column(name = "kwh_kwp")
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
