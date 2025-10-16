package com.example.expensetracker.service;

import com.example.expensetracker.mapper.ExpenseMapper;
import com.example.expensetracker.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseMapper expenseMapper;

    // ✅ Get all expenses
    public List<Expense> getAllExpenses() {
        return expenseMapper.getAllExpenses();
    }

    // ✅ Add new expense
    public void addExpense(Expense expense) {
        expenseMapper.insertExpense(expense);
    }

    // ✅ Delete expense by ID
    public void deleteExpense(int id) {
        expenseMapper.deleteExpenseById(id);
    }

    // ✅ Filter expenses by month
    public List<Expense> filterByMonth(String month) {
        return expenseMapper.filterByMonth(month);
    }
}
