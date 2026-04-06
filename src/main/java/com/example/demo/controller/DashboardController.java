package com.example.demo.controller;



import org.springframework.web.bind.annotation.*;

import com.example.demo.service.DashboardService;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service){
        this.service=service;
    }

    @GetMapping("/summary")
    public Map<String,Object> summary(){
        return service.getSummary();
    }
}