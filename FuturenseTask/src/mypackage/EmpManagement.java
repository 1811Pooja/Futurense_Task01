package mypackage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmpManagement {
    public static void main(String[] args) {
        List<Emp> Emps = Arrays.asList(
                new Emp(101, "Alice", "HR", 60000),
                new Emp(102, "Bob", "IT", 70000),
                new Emp(103, "Charlie", "HR", 65000),
                new Emp(104, "Diana", "Sales", 55000),
                new Emp(105, "Ethan", "IT", 72000)
        );

        // Store Emps in a suitable collection
        Map<Integer, Emp> EmpMap = Emps.stream()
                .collect(Collectors.toMap(Emp::getId, e -> e));

        // Group Emps based on their department
        Map<String, List<Emp>> departmentWiseEmps = Emps.stream()
                .collect(Collectors.groupingBy(Emp::getDepartment));

        // Retrieve Emps whose salary falls within a given range
        double minSalary = 60000;
        double maxSalary = 70000;
        List<Emp> EmpsInSalaryRange = Emps.stream()
                .filter(e -> e.getSalary() >= minSalary && e.getSalary() <= maxSalary)
                .collect(Collectors.toList());

        // Emp de-duplication using Set to avoid duplicates
        Set<Emp> uniqueEmps = new HashSet<>(Emps);

        // Displaying results
        System.out.println("Employee details stored in a Map:");
        EmpMap.forEach((id, Emp) ->
                System.out.println(id + ": " + Emp.getName() + " - " + Emp.getDepartment()));

        System.out.println("\nEmployees grouped by department:");
        departmentWiseEmps.forEach((department, empList) -> {
            System.out.println("\n"+ department+":" );
            empList.forEach(emp -> System.out.println(emp.getName()));
        });

        System.out.println("\nEmployees within salary range " + minSalary + " - " + maxSalary + ":");
        EmpsInSalaryRange.forEach(Emp ->
                System.out.println(Emp.getName() + " - " + Emp.getSalary()));

        System.out.println("\nUnique Employees:");
        uniqueEmps.forEach(Emp ->
                System.out.println(Emp.getName() + " - " + Emp.getDepartment()));
    }
}
