
package Core;

import Tool.ConsoleInputter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class EmployeeList extends ArrayList<Employee> {
    
    static String emIdPat = "^E\\\\d{3}$";
    static String emRolePat = "^(Developer|Tester|Manager|HR)$";
    static String emStatusPat = "^(active|inactive)$";
    
    
    // 2. Add a new employee
    public void addEmployee() {
        
    }
    
    // 3. Update employee information
    public void updateEmployee() {
        
    }
    
    // 4. Remove an employee by ID
    public void removeEmployeeById() {
        String emId = ConsoleInputter.getStr("Enter employee ID: ", 
                                                emIdPat, 
                                                "Player ID must be in format Exxx");
        
        int pos = this.indexOf(new Employee(emId));
        
        if(pos < 0)
            System.out.println("This employee does not exist.");
        else {
            Employee e = this.get(pos);
            
            System.out.println("Employee Information");

            String msg = "-----------------------------------" + "\n"
                    + "ID           : " + e.getId() + "\n"
                    + "Name         : " + e.getName() + "\n"
                    + "Role         : " + e.getRole() + "\n"
                    + "Base Salary  : " + e.getBaseSalary() + "\n"
                    + "Working Days : " + e.getWorkingDays() + "\n"
                    + "Bonus        : " + e.getBonus() + "\n"
                    + "Status       : " + e.getStatus() + "\n"
                    + "-----------------------------------";

            System.out.println(msg);

            boolean response = ConsoleInputter.getBoolean("Do you really want to remove this employee");

            if (response == true) {
                this.remove(pos);
                System.out.println("The employee has been successfully deleted.");
            }
        }
        
        
        
    }
    
    // 5. Search employees by attribute
    public void searchEmployeesByAttribute() {
        
        EmployeeList resultList = new EmployeeList();
        
        System.out.println("\n ===== Search employee by ? ===== ");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Role");
        System.out.println("4. Status");
        int choice = ConsoleInputter.getInt("Enter an option: ", 1, 4);
        
        switch(choice) {
            case 1: // ID
                String id = ConsoleInputter.getStr("Enter ID: ", 
                                                emIdPat, 
                                                "ID must be in format Exxx");
        
                int pos = this.indexOf(new Employee(id));

                if(pos < 0)
                    System.out.println("This employee does not exist.");
                else {
                    resultList.add(this.get(pos));
                }
                resultList.display();
                break;
                
            case 2: // Name
                String name = ConsoleInputter.getStr("Enter name: ").trim().toLowerCase();
            
                for(Employee e : this) {
                    if(e.getName().toLowerCase().contains(name)) {
                        resultList.add(e);
                    }
                }

                resultList.display();
                break;
                
            case 3: // Role
                String role = ConsoleInputter.getStr("Enter role: ", 
                                                emRolePat, 
                                                "Role must be Developer, Tester, Manager or HR");
                
                for(Employee e : this) {
                    if(e.getRole().equalsIgnoreCase(role)) {
                        resultList.add(e);
                    }
                }
                
                resultList.display();
                
                break;
                
            case 4: // Status
                String status = ConsoleInputter.getStr("Enter status: ", 
                                                emStatusPat, 
                                                "Status must be active or inactive");
                
                for(Employee e : this) {
                    if(e.getStatus().equalsIgnoreCase(status)) {
                        resultList.add(e);
                    }
                }
                
                resultList.display();
                
                break;
        }
        
    }
    
    // 6. Calculate monthly payroll
    public void calculateMonthlyPayroll() {
        
    }
    
    // 7. Display employee list
    public void display() {

        if (this.isEmpty()) {
            System.out.println("No employee found.");
            return;
        }

        System.out.println("--------------------------------------------------------------------");
        System.out.println("ID   |       Name       |    Role    | Base Salary | Working Days |  Bonus  | Status");
        System.out.println("--------------------------------------------------------------------");

        for (Employee e : this) {
            System.out.format(
                    "%-4s | %-16s | %-10s | %-11.2f | %-12d | %-7.2f | %-10s\n",
                    e.getId(),
                    e.getName(),
                    e.getRole(),
                    e.getBaseSalary(),
                    e.getWorkingDays(),
                    e.getBonus(),
                    e.getStatus());
        }

        System.out.println("--------------------------------------------------------------------");
    }
    
    // 8. Save data to file
    public void saveToFile(String fName) {

        if (this.isEmpty())
            System.out.println("No player.");
        else {
            try {
                PrintWriter fw = new PrintWriter(fName);

                for (Employee e : this)
                    fw.println(e.toStringOnFile());

                fw.close();

            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
    
    // 1. Load employee data from file 
    public void readFile(String fName) {
        File f = new File(fName);
        if (!f.exists())
            System.out.println("The file doesn't exist!");
        else {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader bf = new BufferedReader(fr);

                String line;
                while ((line = bf.readLine()) != null) {
                    String[] parts = line.split(",");

                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String role = parts[2].trim();
                    double baseSalary = Double.parseDouble(parts[3].trim());
                    int workingDays = Integer.parseInt(parts[4].trim());
                    double bonus = Double.parseDouble(parts[5].trim());
                    String status = parts[6].trim();

                    Employee e = new Employee(id, name, role, baseSalary, workingDays, bonus, status);
                    this.add(e);
                }

                bf.close();
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
