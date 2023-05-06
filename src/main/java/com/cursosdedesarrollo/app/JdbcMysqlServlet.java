package com.cursosdedesarrollo.app;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@WebServlet(
        name = "JdbcMysqlServlet",
        urlPatterns = {"/mysql"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class JdbcMysqlServlet extends HttpServlet {
    private static final String DATABASE_NAME= "test";
    private static final String DATABASE_HOST= "localhost";
    private static final String DATABASE_PORT= "3306";
    private static final String DATABASE_USER= "root";
    private static final String DATABASE_PASS= "root";
    private static final String TABLE_NAME= "REGISTRATION";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Connection conn = null;
        Statement stmt = null;
        Registration registration = null;
        String sql = null;
        Registration r = null;
        List<Registration> listado;
        try {
            // STEP 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://"
                            +DATABASE_HOST
                            +":"
                            +DATABASE_PORT
                            +"/"
                            +DATABASE_NAME,
                    DATABASE_USER,
                    DATABASE_PASS);
            //STEP 3: Execute a query
            System.out.println("Deleting table in given database...");
            sql = "DROP TABLE IF EXISTS "+TABLE_NAME;
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            sql = "CREATE TABLE  "+ TABLE_NAME+ " " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        }catch (JdbcSQLSyntaxErrorException e){
            e.printStackTrace();
            System.out.println("Tabla creada previamente");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            // STEP 4: Execute a query
            stmt = conn.createStatement();
            sql = "INSERT INTO "+ TABLE_NAME+ " "
                    + "VALUES (100, 'Zara', 'Ali', 18)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO "+ TABLE_NAME+ " "
                    + "VALUES (101, 'Mahnaz', 'Fatma', 25)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO "+ TABLE_NAME+ " "
                    + "VALUES (102, 'Zaid', 'Khan', 30)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO "+ TABLE_NAME+ " "
                    + "VALUES(103, 'Sumit', 'Mittal', 28)";

            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
            // STEP 5: Execute a query
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            sql = "SELECT id, first, last, age FROM "+ TABLE_NAME+ " ";
            ResultSet rs = stmt.executeQuery(sql);
            listado = new LinkedList<>();
            // STEP 6: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");
                r = new Registration(id,age,first,last);
                listado.add(r);
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
            sql = "UPDATE "+ TABLE_NAME+ " "
                    + "SET age = 30 WHERE id in (100, 101)";
            stmt.executeUpdate(sql);

            // Now you can extract all the records
            // to see the updated records
            sql = "SELECT id, first, last, age FROM "+ TABLE_NAME+ " ";
            rs = stmt.executeQuery(sql);
            listado = new LinkedList<>();
            while(rs.next()){
                // Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");
                r = new Registration(id,age,first,last);
                listado.add(r);
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
            sql = "DELETE FROM "+ TABLE_NAME+ " "
                    + "WHERE id = 101";
            stmt.executeUpdate(sql);

            // Now you can extract all the records
            // to see the remaining records
            sql = "SELECT id, first, last, age FROM "+ TABLE_NAME+ " ";
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
            // STEP 10: Clean-up environment
            stmt.close();
            conn.close();
            request.setAttribute("data", r);
            request.setAttribute("listado", listado);
            request.getRequestDispatcher("/WEB-INF/jdbc.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // free resources
            try {
                if (stmt != null) stmt.close();
            }catch (SQLException se2){
                se2.printStackTrace();
            }
        }

    }
}
