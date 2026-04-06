package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class FinancialRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String type;

    private String category;

    private LocalDate date;

    private String notes;

    public FinancialRecord(){}

    public FinancialRecord(Double amount,String type,String category,LocalDate date,String notes){
        this.amount=amount;
        this.type=type;
        this.category=category;
        this.date=date;
        this.notes=notes;
    }

    public Long getId(){return id;}

    public Double getAmount(){return amount;}

    public void setAmount(Double amount){this.amount=amount;}

    public String getType(){return type;}

    public void setType(String type){this.type=type;}

    public String getCategory(){return category;}

    public void setCategory(String category){this.category=category;}

    public LocalDate getDate(){return date;}

    public void setDate(LocalDate date){this.date=date;}

    public String getNotes(){return notes;}

    public void setNotes(String notes){this.notes=notes;}
}
