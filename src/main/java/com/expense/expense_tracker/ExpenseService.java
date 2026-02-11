package com.expense.expense_tracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.expense_tracker.model.Expense;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    // This is the method the Controller is looking for
    public List<Expense> getExpenses() {
        return repository.findAll();
    }

    public Expense saveExpense(Expense expense) {
        return repository.save(expense);
    }

    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }
}