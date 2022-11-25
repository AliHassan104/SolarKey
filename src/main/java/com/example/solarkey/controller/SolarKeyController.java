package com.example.solarkey.controller;

import com.example.solarkey.dto.SolarKeyDto;
import com.example.solarkey.model.SolarKey;
import com.example.solarkey.service.SolarKeyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/solars")
public class SolarKeyController {

    @Autowired
    private SolarKeyService solarKeyService;

    @PostMapping
    public ResponseEntity<SolarKeyDto> addSolarKey(@RequestBody SolarKeyDto solarKeyDto){
        try{
            return ResponseEntity.ok(solarKeyService.addSolarKey(solarKeyDto));
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<SolarKey>> getSolarKey(){
        List<SolarKey> solarKey= solarKeyService.getAllSolarKey();
        return ResponseEntity.ok(solarKey);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolarKeyDto> getSolarKeyById(@PathVariable Long id) throws Exception {
        SolarKeyDto solarKey = solarKeyService.getSolarKeyById(id);
        return  ResponseEntity.ok(solarKey);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSolarKeyById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(solarKeyService.deleteSolarKeyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolarKeyDto> updateSolarKeyById(@PathVariable Long id,@RequestBody SolarKeyDto solarKeyDto){
        try{
            return ResponseEntity.ok(solarKeyService.updateSolarKeyById(id,solarKeyDto));
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
