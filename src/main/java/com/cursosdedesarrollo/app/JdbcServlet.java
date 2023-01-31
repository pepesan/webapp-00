package com.cursosdedesarrollo.app;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@WebServlet(
        name = "JdbcServlet",
        urlPatterns = {"/jdbc"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class JdbcServlet extends HttpServlet {
    Registration r;
    List<Registration> listado;

    Connection conn = null;
    Statement stmt = null;
    Registration registration = null;
    String sql = null;

    public JdbcServlet(){
        try {
            // STEP 1: Register JDBC driver
            Class.forName("org.h2.Driver");
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(
                    "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
                    "sa",
                    "");
            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            sql = "CREATE TABLE   REGISTRATION " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
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
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try{
            // STEP 4: Execute a query
            stmt = conn.createStatement();
            sql = "INSERT INTO Registration (first, last, age)"
                    + "VALUES ('Zara', 'Ali', 18)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration (first, last, age)"
                    + "VALUES ('Mahnaz', 'Fatma', 25)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration (first, last, age)"
                    + "VALUES ('Zaid', 'Khan', 30)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration  (first, last, age)"
                    + "VALUES('Sumit', 'Mittal', 28)";

            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
            // STEP 5: Execute a query
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            sql = "SELECT id, first, last, age FROM Registration";
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
            sql = "UPDATE Registration "
                    + "SET age = 30 WHERE id in (1, 300)";
            stmt.executeUpdate(sql);

            // Now you can extract all the records
            // to see the updated records
            sql = "SELECT id, first, last, age FROM Registration";
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
            sql = "DELETE FROM Registration "
                    + "WHERE id = 1";
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
                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            rs.close();
            // STEP 10: Clean-up environment
            stmt.close();
            // conn.close();
            request.setAttribute("data", r);
            request.setAttribute("listado", listado);
            request.getRequestDispatcher("/WEB-INF/jdbc.jsp")
                    .forward(request, response);
            response.setStatus(200);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
