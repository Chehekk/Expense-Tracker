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
        double budget = 50000.0;

        model.addAttribute("listExpenses", service.getExpenses());
        model.addAttribute("totalExpenses", total);
        model.addAttribute("remainingBudget", budget - total);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
        return "redirect:/";
    }
    

    @PostMapping("/save")
    public String saveExpense(@ModelAttribute("expense") Expense expense) {
        service.saveExpense(expense);
        return "redirect:/"; //tells browser to refresh the page
    }

    
}
