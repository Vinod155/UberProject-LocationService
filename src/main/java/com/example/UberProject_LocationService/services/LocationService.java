package com.example.UberProject_LocationService.services;

import com.example.UberProject_LocationService.dto.DriverLocationDto;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LocationService {

    boolean saveDriverLocation(String driverId,double latitude,double longitude);
    List<DriverLocationDto> getNearByDrivers(double latitude,double longitude);
}
