package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.repo.FinancialRecordRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    private final FinancialRecordRepository repository;

    public DashboardService(FinancialRecordRepository repository){
        this.repository=repository;
    }

    public Map<String,Object> getSummary(){

        Double income=repository.totalIncome();
        Double expense=repository.totalExpense();

        if(income==null) income=0.0;
        if(expense==null) expense=0.0;

        Map<String,Object> map=new HashMap<>();

        map.put("totalIncome",income);
        map.put("totalExpense",expense);
        map.put("netBalance",income-expense);

        return map;
    }
}