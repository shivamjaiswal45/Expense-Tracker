package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public void saveExpense(Expense expense){
        expenseRepository.save(expense);
    }
    public Expense getExpenseById(Long id){
        return expenseRepository.findById(id).orElse(null);
    }
    public void deleteExpenseById(Long id){
        expenseRepository.deleteById(id);
    }
}
