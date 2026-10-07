package com.vansh.gatekeeper.management.dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class HealthResponseDto {

   private String serviceStatus;
   private String dbStatus;
   private LocalDateTime serviceTime;


}
