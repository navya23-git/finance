package com.example.demo.dto;


import jakarta.validation.constraints.*;

public class FinancialRecordRequest {

    @NotNull
    @Positive
    private Double amount;

    @NotBlank
    private String type;

    @NotBlank
    private String category;

}