package com.example.demo.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.FinancialRecord;

import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord,Long>{

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByType(String type);

   @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE LOWER(f.type) = 'income'")
Double totalIncome();

@Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE LOWER(f.type) = 'expense'")
Double totalExpense();
}