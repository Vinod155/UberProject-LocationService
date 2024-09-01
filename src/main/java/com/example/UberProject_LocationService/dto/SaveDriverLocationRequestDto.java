package com.example.UberProject_LocationService.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveDriverLocationRequestDto {
    String driverId;

    Double latitude;

    Double longitude;
}
