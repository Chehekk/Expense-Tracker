package com.expense.expense_tracker;

import com.expense.expense_tracker.model.Expense;
import org.springframework.web.bind.annotation.PostMapping;
import com.expense.expense_tracker.ExpenseService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    
    @Autowired
    private ExpenseService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listExpenses", service.getExpenses());
        return "index";
    }

    @PostMapping("/save")
    public String saveExpense(@ModelAttribute("expense") Expense expense) {
        service.saveExpense(expense);
        return "redirect:/"; //tells browser to refresh the page
    }
}
