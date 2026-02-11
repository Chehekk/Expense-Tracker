package com.expense.expense_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.expense.expense_tracker.model.Expense;


@Controller
public class WebController {
    
    @Autowired
    private ExpenseService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        double total = service.getTotalExpenses();
        double budget = 6000.0;
        double remaining = budget - total;

        model.addAttribute("listExpenses", service.getExpenses());
        model.addAttribute("totalExpenses", total);
        model.addAttribute("remainingBudget", remaining);
        model.addAttribute("categoryData", service.getCategoryTotals());

        if(remaining < 0) {
            model.addAttribute("Budget Warning", "You have spent more than your budget!");
        }

        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clearAll() {
        service.getExpenses().clear(); // Or better: repository.deleteAll(); if using a DB
        return "redirect:/";
    }
    

    @PostMapping("/save")
    public String saveExpense(@ModelAttribute("expense") Expense expense) {
        service.saveExpense(expense);
        return "redirect:/"; //tells browser to refresh the page
    }

    
}
