package com.cursosdedesarrollo.app;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(
        name = "JdbcServlet",
        urlPatterns = {"/jdbc"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class JdbcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Connection conn = null;
        Statement stmt = null;
        Registration registration = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName ("org.h2.Driver");
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection (
                    "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
                    "sa",
                    "");
            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "CREATE TABLE   REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            // STEP 4: Execute a query
            stmt = conn.createStatement();
            sql = "INSERT INTO Registration " + "VALUES (100, 'Zara', 'Ali', 18)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration " + "VALUES (101, 'Mahnaz', 'Fatma', 25)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration " + "VALUES (102, 'Zaid', 'Khan', 30)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration " + "VALUES(103, 'Sumit', 'Mittal', 28)";

            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
            // STEP 5: Execute a query
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            sql = "SELECT id, first, last, age FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 6: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            // STEP 7: Clean-up environment
            rs.close();
            // STEP 8: Execute a query
            stmt = conn.createStatement();
            sql = "UPDATE Registration " + "SET age = 30 WHERE id in (100, 101)";
            stmt.executeUpdate(sql);

            // Now you can extract all the records
            // to see the updated records
            sql = "SELECT id, first, last, age FROM Registration";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                // Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            rs.close();
            // STEP 9: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            sql = "DELETE FROM Registration " + "WHERE id = 101";
            stmt.executeUpdate(sql);

            // Now you can extract all the records
            // to see the remaining records
            sql = "SELECT id, first, last, age FROM Registration";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                // Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");
                registration = new Registration(id,age,first,last);

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            rs.close();
            // STEP 10: Clean-up environment
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("data", registration);
        request.getRequestDispatcher("/WEB-INF/jdbc.jsp").forward(request, response);
    }
}
