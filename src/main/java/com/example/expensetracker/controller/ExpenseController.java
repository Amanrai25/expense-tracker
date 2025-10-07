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

