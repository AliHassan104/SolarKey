package com.example.solarkey.service;

import com.example.solarkey.dto.SolarKeyDto;
import com.example.solarkey.exception.ContentNotFoundException;
import com.example.solarkey.model.SolarKey;
import com.example.solarkey.repository.SolarKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolarKeyService {

    @Autowired
    SolarKeyRepository solarKeyRepository;

    public SolarKeyDto addSolarKey(SolarKeyDto solarKeyDto) {
        return toDto(solarKeyRepository.save(dto(solarKeyDto)));
    }

    public List<SolarKey> getAllSolarKey(){
        return solarKeyRepository.findAll();
    }

    public SolarKeyDto getSolarKeyById(Long id) throws Exception {
        Optional<SolarKey> solarKey =  solarKeyRepository.findById(id);
        if(solarKey.isPresent()){
            return toDto(solarKey.get());
        }
        throw new Exception("No Solar Key Exist having id "+id);
    }

    public String deleteSolarKeyById(Long id) throws Exception {
        try {
            solarKeyRepository.deleteById(id);
            return "Deleted Successfully";
        }catch (Exception e){
            return "No Solar Key Exist Having id "+id;
//            throw new ContentNotFoundException("Cannot Delete No Solar Key Exist Having id "+id);
        }
    }

    public SolarKeyDto updateSolarKeyById(Long id, SolarKeyDto solarKeyDto) {
        try {
            SolarKey updateSolarKey = getAllSolarKey().stream().filter(el -> el.getId().equals(id)).findAny().get();
            if (updateSolarKey != null) {
                updateSolarKey.setLongitude(solarKeyDto.getLongitude());
                updateSolarKey.setLatitude(solarKeyDto.getLatitude());
                updateSolarKey.setLocation(solarKeyDto.getLocation());

                updateSolarKey.setModuleACNameplate(solarKeyDto.getModuleACNameplate());
                updateSolarKey.setModuleDCNameplate(solarKeyDto.getModuleDCNameplate());
                updateSolarKey.setLoadRatio(solarKeyDto.getLoadRatio());
                updateSolarKey.setPerformanceRatio(solarKeyDto.getPerformanceRatio());

                updateSolarKey.setModuleACNameplate(solarKeyDto.getModuleACNameplate());
                updateSolarKey.setModuleACNameplate(solarKeyDto.getModuleACNameplate());
                updateSolarKey.setModuleACNameplate(solarKeyDto.getModuleACNameplate());
                updateSolarKey.setModuleACNameplate(solarKeyDto.getModuleACNameplate());

                updateSolarKey.setProjectDesigner(solarKeyDto.getProjectDesigner());
                updateSolarKey.setTotalAnnualProduction(solarKeyDto.getTotalAnnualProduction());
                updateSolarKey.setTariff(solarKeyDto.getTariff());
                updateSolarKey.setProjectName(solarKeyDto.getProjectName());

                updateSolarKey.setDate(solarKeyDto.getDate());
                updateSolarKey.setTotalAnnualProduction(solarKeyDto.getTotalAnnualProduction());
                updateSolarKey.setAverageDailySolarHours(solarKeyDto.getAverageDailySolarHours());
                updateSolarKey.setWeatherDataset(solarKeyDto.getWeatherDataset());

                updateSolarKey.setIrridationVariance(solarKeyDto.getIrridationVariance());
                updateSolarKey.setCellTemperatureSpread(solarKeyDto.getCellTemperatureSpread());
                updateSolarKey.setAcSystemDerate(solarKeyDto.getAcSystemDerate());
                updateSolarKey.setModuleCharacterisations(solarKeyDto.getModuleCharacterisations());

                updateSolarKey.setKWhkWp(solarKeyDto.getKWhkWp());
                updateSolarKey.setProjectAddress(solarKeyDto.getProjectAddress());
                updateSolarKey.setAverageDailySolarHours(solarKeyDto.getAverageDailySolarHours());
                updateSolarKey.setNumberOfTiles(solarKeyDto.getNumberOfTiles());
                updateSolarKey.setAreaOfProject(solarKeyDto.getAreaOfProject());

                updateSolarKey.setModuleType(solarKeyDto.getModuleType());
                updateSolarKey.setModuleCount(solarKeyDto.getModuleCount());
                updateSolarKey.setSolarInverterType(solarKeyDto.getSolarInverterType());
                updateSolarKey.setCabling(solarKeyDto.getCabling());
            }
            return toDto(solarKeyRepository.save(updateSolarKey));
        }catch (Exception e){
            throw new RuntimeException("Cannot Update Solar Key "+e);
        }
    }

    public SolarKey dto(SolarKeyDto solarKeyDto){
        return SolarKey.builder().id(solarKeyDto.getId())
                .longitude(solarKeyDto.getLongitude())
                .latitude(solarKeyDto.getLatitude())
                .location(solarKeyDto.getLocation())

                .moduleACNameplate(solarKeyDto.getModuleACNameplate())
                .moduleDCNameplate(solarKeyDto.getModuleDCNameplate())
                .loadRatio(solarKeyDto.getLoadRatio())
                .performanceRatio(solarKeyDto.getPerformanceRatio())

                .projectDesigner(solarKeyDto.getProjectDesigner())
                .totalAnnualSales(solarKeyDto.getTotalAnnualSales())
                .tariff(solarKeyDto.getTariff())
                .projectName(solarKeyDto.getProjectName())

                .date(solarKeyDto.getDate())
                .totalAnnualProduction(solarKeyDto.getTotalAnnualProduction())
                .averageDailyProduction(solarKeyDto.getAverageDailyProduction())
                .weatherDataset(solarKeyDto.getWeatherDataset())


                .irridationVariance(solarKeyDto.getIrridationVariance())
                .cellTemperatureSpread(solarKeyDto.getCellTemperatureSpread())
                .acSystemDerate(solarKeyDto.getAcSystemDerate())
                .moduleCharacterisations(solarKeyDto.getModuleCharacterisations())


                .kWhkWp(solarKeyDto.getKWhkWp())
                .projectAddress(solarKeyDto.getProjectAddress())
                .averageDailySolarHours(solarKeyDto.getAverageDailySolarHours())
                .numberOfTiles(solarKeyDto.getNumberOfTiles())
                .areaOfProject(solarKeyDto.getAreaOfProject())


                .moduleType(solarKeyDto.getModuleType())
                .moduleCount(solarKeyDto.getModuleCount())
                .solarInverterType(solarKeyDto.getSolarInverterType())
                .cabling(solarKeyDto.getCabling())

                .build();
    }

    public SolarKeyDto toDto(SolarKey solarKey){
        return  SolarKeyDto.builder().id(solarKey.getId())
                .longitude(solarKey.getLongitude())
                .latitude(solarKey.getLatitude())
                .location(solarKey.getLocation())

                .moduleACNameplate(solarKey.getModuleACNameplate())
                .moduleDCNameplate(solarKey.getModuleDCNameplate())
                .loadRatio(solarKey.getLoadRatio())
                .performanceRatio(solarKey.getPerformanceRatio())

                .projectDesigner(solarKey.getProjectDesigner())
                .totalAnnualSales(solarKey.getTotalAnnualSales())
                .tariff(solarKey.getTariff())
                .projectName(solarKey.getProjectName())

                .date(solarKey.getDate())
                .totalAnnualProduction(solarKey.getTotalAnnualProduction())
                .averageDailyProduction(solarKey.getAverageDailyProduction())
                .weatherDataset(solarKey.getWeatherDataset())


                .irridationVariance(solarKey.getIrridationVariance())
                .cellTemperatureSpread(solarKey.getCellTemperatureSpread())
                .acSystemDerate(solarKey.getAcSystemDerate())
                .moduleCharacterisations(solarKey.getModuleCharacterisations())


                .kWhkWp(solarKey.getKWhkWp())
                .projectAddress(solarKey.getProjectAddress())
                .averageDailySolarHours(solarKey.getAverageDailySolarHours())
                .numberOfTiles(solarKey.getNumberOfTiles())
                .areaOfProject(solarKey.getAreaOfProject())


                .moduleType(solarKey.getModuleType())
                .moduleCount(solarKey.getModuleCount())
                .solarInverterType(solarKey.getSolarInverterType())
                .cabling(solarKey.getCabling())
                .build();
    }


}
