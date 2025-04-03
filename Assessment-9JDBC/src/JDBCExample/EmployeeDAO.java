package JDBCExample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class EmployeeDAO {
    
    public void insertEmployee(String name, String designation, Double salary) {
        try {
            String sql = "INSERT INTO employees(name, designation, salary) VALUES (?, ?, ?)";
            Connection conn = DBConnection.getConnection();
            
            if (conn != null) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, designation);
                stmt.setDouble(3, salary);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Employee added successfully!");
                }
                stmt.close();
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void getEmployee() {
            String sql = "SELECT * FROM employees";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet resultSet = stmt.executeQuery()) {

                System.out.println("ID | NAME | DESIGNATION | SALARY");
                System.out.println("------------------------------------");

                while (resultSet.next()) { // Fixed capitalization
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String designation = resultSet.getString("designation");
                    double salary = resultSet.getDouble("salary"); // Changed getInt() to getDouble()

                    System.out.println(id + " | " + name + " | " + designation + " | " + salary);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void updateSalary(int id,double newsalary)
        {
        	String sql="update employees set salary=? where ID=?";
        	try (Connection conn = DBConnection.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql)){
        		 stmt.setDouble(1,newsalary);
       		  stmt.setInt(2, id);
       		 int rowsUpdated=stmt.executeUpdate();
       		 if (rowsUpdated> 0) {
                    System.out.println("Employee Updated successfully!");
                }
       		 
       		 }catch (SQLException e) {
                    e.printStackTrace();
                }
        		
        	}
        	
    
            public void deleteEmployees(int id,double salary) {
            	String sql="delete from employees where ID=? and salary>=?";
            	 try (Connection conn = DBConnection.getConnection();
                         PreparedStatement stmt = conn.prepareStatement(sql)){
            		 stmt.setInt(1,id);
            		  stmt.setDouble(2, salary);
            		 int rowsDeleted=stmt.executeUpdate();
            		 if (rowsDeleted > 0) {
                         System.out.println("Employee deleted successfully!");
                     }
            		 
            		 }catch (SQLException e) {
                         e.printStackTrace();
                     }
            			 
            	
            
        }
    
}
