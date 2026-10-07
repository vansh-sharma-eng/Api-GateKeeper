package com.vansh.gatekeeper.management.service;

import com.vansh.gatekeeper.management.dto.responseDto.HealthResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HealthService {

    private JdbcTemplate jdbcTemplate;
    public String getHealth() {

        String databaseStatus = "DOWN";

        try {
          Integer result =  jdbcTemplate.queryForObject("SELECT 1", Integer.class);
          if (Integer.valueOf(result) == 1) {
              databaseStatus = "UP";
          }


        } catch (Exception e) {
            System.out.println("Mysql health check failed"+e.getMessage());
        }
        return databaseStatus;
    }

}
