/*package com.example.expensetracker.mapper;

import com.example.expensetracker.model.Expense;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpenseMapper {
    void insertExpense(Expense expense);
}
1-9 is correct */

/*package com.example.expensetracker.mapper;

import com.example.expensetracker.model.Expense;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface ExpenseMapper {

    @Insert("INSERT INTO expenses (title, amount, category, date) VALUES (#{title}, #{amount}, #{category}, #{date})")
    void insertExpense(Expense expense);

    @Select("SELECT * FROM expenses")
    List<Expense> getAllExpenses();
} */
/*package com.example.expensetracker.mapper;

import com.example.expensetracker.model.Expense;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface ExpenseMapper {
    void insertExpense(Expense expense);
    List<Expense> getAllExpenses(); // ✅ Needed for GET
    //@Select("SELECT * FROM expenses WHERE TO_CHAR(date, 'YYYY-MM') = #{month}")
    List<Expense> filterByMonth(String month);
    
    void deleteExpenseById(int id);


}
*/
package com.example.expensetracker.mapper;

import com.example.expensetracker.model.Expense;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ExpenseMapper {

    // ✅ Insert a new expense
    void insertExpense(Expense expense);

    // ✅ Get all expenses
    List<Expense> getAllExpenses();

    // ✅ Filter expenses by month (uses SQL in XML)
    List<Expense> filterByMonth(@Param("month") String month);

    // ✅ Delete an expense by its ID
    void deleteExpenseById(@Param("id") int id);
}





