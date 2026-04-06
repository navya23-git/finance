package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.FinancialRecord;
import com.example.demo.service.FinancialRecordService;

import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    private final FinancialRecordService service;

    public FinancialRecordController(FinancialRecordService service){
        this.service=service;
    }

    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord record){
        return service.createRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getAll(){
        return service.getAllRecords();
    }

    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id,@RequestBody FinancialRecord record){
        return service.updateRecord(id,record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteRecord(id);
    }
}