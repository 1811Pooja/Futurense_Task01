package mypackage;

import java.util.*;
import java.util.stream.Collectors;

class Emp {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Emp(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Emp Emp = (Emp) obj;
        return id == Emp.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}



