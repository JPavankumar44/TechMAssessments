import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class MyAppTest {
    Myapp app = new MyApp();
    @Test
    public void TestAdminRole(){
        //only admin had perssion
        assertEquals("Admin can add student",app.validate("admin", "addStudent") );
        assertEquals("Not admin",app.validate("student", "addStudent") );
        assertEquals("Operation not possible",app.validate("admin", "delete") );
        //test cases
 
    }


}
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class MyappTest {
    Myapp app = new Myapp();
    @Test
    public void TestAdminRole(){
        //only admin had perssion
        assertEquals("Admin can add student",app.validate("admin", "addStudent") );
        assertEquals("Not admin",app.validate("student", "addStudent") );
        assertEquals("Operation not possible",app.validate("admin", "delete") );
        //test cases
 
    }
}
 
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class MyappTest {
    Myapp app = new Myapp();
    @Test
    public void TestAdminRole(){
        //only admin had perssion
        assertEquals("Admin can add student",app.validate("admin", "addStudent") );
        assertEquals("Not admin",app.validate("student", "addStudent") );
        assertEquals("Operation not possible",app.validate("admin", "delete") );
        //test cases
    }
    @Test
    public void TestLogin(){
        assertEquals("Student Logged in",app.login("student", "raju","123") );
        assertEquals("Invalid Credentials",app.login("student", "raju","111") );
    }
}
 
 
 
 