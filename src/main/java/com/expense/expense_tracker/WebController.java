package com.expense.expense_tracker;

import com.expense.expense_tracker.ExpenseService;
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
}
