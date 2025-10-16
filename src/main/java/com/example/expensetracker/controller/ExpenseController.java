/*package com.example.expensetracker.controller;

import com.example.expensetracker.mapper.ExpenseMapper;
import com.example.expensetracker.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class ExpenseController {

    @Autowired
    private ExpenseMapper expenseMapper;

    @PostMapping("/expenses")
    public String addExpense(@RequestBody Expense expense) {
        expenseMapper.insertExpense(expense);
        return "Expense added successfully";
    }
}
*/ //1-19 is correct
/*@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseMapper expenseMapper;

    @PostMapping
    public void addExpense(@RequestBody Expense expense) {
        expenseMapper.insertExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseMapper.getAllExpenses();
    }
}
*/
/*package com.example.expensetracker.controller;

import com.example.expensetracker.mapper.ExpenseMapper;
import com.example.expensetracker.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseMapper expenseMapper;

    // ✅ POST: Add expense
    @PostMapping
    public void addExpense(@RequestBody Expense expense) {
        expenseMapper.insertExpense(expense);
    }

    // ✅ GET: Get all expenses (optional, for debugging in Postman)
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseMapper.getAllExpenses();
    }
}
*/
/*
 package com.example.expensetracker.controller;

import com.example.expensetracker.mapper.ExpenseMapper;
import com.example.expensetracker.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")  // <--- This must match the URL you call in Postman
public class ExpenseController {

    @Autowired
    private ExpenseMapper expenseMapper;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseMapper.getAllExpenses();
    }
    @GetMapping("/month")
    public List<Expense> filterByMonth(@RequestParam String month) {
        return expenseMapper.filterByMonth(month);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable int id) {
        expenseMapper.deleteExpenseById(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping
    public void addExpense(@RequestBody Expense expense) {
        expenseMapper.insertExpense(expense);
    }
}
*/

package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081") // allow frontend running on 8081
@RequestMapping("/api/expenses")  // clearer and more REST-friendly base URL
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // ✅ Get all expenses
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    // ✅ Filter expenses by month
    @GetMapping("/month")
    public ResponseEntity<List<Expense>> filterByMonth(@RequestParam String month) {
        List<Expense> filtered = expenseService.filterByMonth(month);
        return ResponseEntity.ok(filtered);
    }

    // ✅ Add a new expense
    @PostMapping
    public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.ok("Expense added successfully!");
    }

    // ✅ Delete an expense by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully!");
    }

    // ✅ Simple test endpoint to verify backend connection
    @GetMapping("/ping")
    public String ping() {
        return "✅ Expense Tracker Backend is running successfully!";
    }
}



