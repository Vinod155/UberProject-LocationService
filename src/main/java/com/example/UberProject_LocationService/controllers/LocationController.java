package com.example.UberProject_LocationService.controllers;

import com.example.UberProject_LocationService.dto.DriverLocationDto;
import com.example.UberProject_LocationService.dto.NearByDriversRequestDto;
import com.example.UberProject_LocationService.dto.SaveDriverLocationRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.UberProject_LocationService.services.LocationService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/driver")
    public ResponseEntity<Boolean> saveDriverLocation(@RequestBody SaveDriverLocationRequestDto saveDriverLocationRequestDto) {
        try {

        boolean response=this.locationService.saveDriverLocation(saveDriverLocationRequestDto.getDriverId(),saveDriverLocationRequestDto.getLatitude(),saveDriverLocationRequestDto.getLongitude());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/nearby/drivers")
    public ResponseEntity<List<DriverLocationDto>> getNearByDrivers(@RequestBody NearByDriversRequestDto nearByDriversRequestDto)
    {
        try {
          List<DriverLocationDto> response=locationService.getNearByDrivers(nearByDriversRequestDto.getLatitude(),nearByDriversRequestDto.getLongitude());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
