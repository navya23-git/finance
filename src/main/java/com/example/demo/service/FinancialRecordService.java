package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.FinancialRecord;
import com.example.demo.repo.FinancialRecordRepository;
import java.util.List;

@Service
public class FinancialRecordService {

    private final FinancialRecordRepository repository;

    public FinancialRecordService(FinancialRecordRepository repository){
        this.repository = repository;
    }

    public FinancialRecord createRecord(FinancialRecord record){
        if(record.getType() != null){
            record.setType(record.getType().trim().toLowerCase()); // lowercase for consistency
        }
        return repository.save(record);
    }

    public List<FinancialRecord> getAllRecords(){
        return repository.findAll();
    }

    public FinancialRecord updateRecord(Long id, FinancialRecord record){
        FinancialRecord existing = repository.findById(id).orElseThrow();

        existing.setAmount(record.getAmount());
        existing.setCategory(record.getCategory());
        if(record.getType() != null){
            existing.setType(record.getType().trim().toLowerCase());
        }
        existing.setDate(record.getDate());
        existing.setNotes(record.getNotes());

        return repository.save(existing);
    }

    public void deleteRecord(Long id){
        repository.deleteById(id);
    }
}