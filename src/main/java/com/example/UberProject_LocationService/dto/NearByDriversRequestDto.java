package com.example.UberProject_LocationService.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NearByDriversRequestDto {
    Double Latitude;
    Double Longitude;
}
