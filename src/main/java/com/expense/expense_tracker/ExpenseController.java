package com.expense.expense_tracker;

import com.expense.expense_tracker.model.Expense;
import com.expense.expense_tracker.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    
    @Autowired
    private ExpenseService service;

    @GetMapping
    public List<Expense> getExpenses() {
        return service.getExpenses();
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return service.saveExpense(expense);
    }
}
