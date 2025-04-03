public class MyApp {
    public String validate(String role,String opp){
        if(role.equals("admin")){
            if(opp.equals("addStudent")){
                return "Admin can add student";
            }else{
                 return "Operation not possible";
            }
        }else{
             return "Not admin";
        }
    }
}
 
 