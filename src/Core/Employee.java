
package Core;

import java.util.Objects;

/**
 *
 * @author acer
 */
public class Employee {
    
    private String id;
    private String name;
    private String role;
    private double baseSalary;
    private int workingDays;
    private double bonus;
    private String status;

    public Employee(String id, String name, String role, double baseSalary, int workingDays, double bonus, String status) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.workingDays = workingDays;
        this.bonus = bonus;
        this.status = status;
    }

    public Employee(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return id + ", "
                + name + ", "
                + role + ", "
                + baseSalary + ", "
                + workingDays + ", "
                + bonus + ", "
                + status;
    }
    
    public String toStringOnFile() {
        return id + ", "
                + name + ", "
                + role + ", "
                + baseSalary + ", "
                + workingDays + ", "
                + bonus + ", "
                + status;
    }
    
}
