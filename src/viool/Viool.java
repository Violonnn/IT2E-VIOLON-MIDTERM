
package viool;

import java.util.Scanner;



public class Viool {
    

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("1. Add\n2. View\n3. Delete\n4. Update  ");  
        System.out.println("Select an action: ");
        int act = in.nextInt();
        config c = new config();
       
        switch(act){
            case 1:             
                c.addDep();
                break;
         case 2: 
             viewDepa();      
             break;
                case 3:
             config dbconfig = new config();
      //  SQL Delete statement to delete a student by their ID
                    System.out.println("Enter Deparment ID to Delete:");
                    int delete = in.nextInt();
        String sqlDelete = "DELETE FROM tbl_deparment WHERE id = ?";
        dbconfig.deleteRecord(sqlDelete, delete);
                break;
                case 4: 
                    System.out.println("Enter Department ID to update:");
                   int update = in.nextInt();
                    System.out.println("Enter new name of department: ");
                    String Newname = in.next();
        String sqlUpdate = "UPDATE tbl_deparment SET d_name = ? WHERE id = ?";
        dbconfig db = new dbconfig ();
       db.updateRecord(sqlUpdate, Newname, update);
       break;
        }
     
        
        
        
    }
    
 
    
 private static void viewDepa() {
        String votersQuery = "SELECT * FROM tbl_department";
        String[] votersHeaders = {"ID", "Name", "Department Head", "Loaction", "Phone Number", "Email"};
        String[] votersColumns = {"d_id", "d_name", "d_head", "d_location", "d_contact", "d_email"};
         
        config c = new config();
        c.viewRecords(votersQuery, votersHeaders, votersColumns);
    }

}
