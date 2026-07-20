import java.util.ArrayList;
import java.util.Collections;

public class EmployeeSalarySystem {
    public static void main(String[] args){
        //Create the following ArrayLists

        //1. Employee name
        ArrayList<String> employeeNames = new ArrayList<>();

        //2. Employee ID
        ArrayList<Integer> employeeIds = new ArrayList<>();

        //3. Monthly salary
        ArrayList<Double> employeeSalaries = new ArrayList<>();

        //Store information for at least 10 employees
        employeeIds.add(1001);
        employeeNames.add("Ali");
        employeeSalaries.add(850.0);

        employeeIds.add(1002);
        employeeNames.add("Ahmed");
        employeeSalaries.add(1850.0);

        employeeIds.add(1003);
        employeeNames.add("Rashid");
        employeeSalaries.add(1500.3800);

        employeeIds.add(1004);
        employeeNames.add("Khalfan");
        employeeSalaries.add(885.500);

        employeeIds.add(1005);
        employeeNames.add("Jokha");
        employeeSalaries.add(350.0);

        employeeIds.add(1006);
        employeeNames.add("Hamida");
        employeeSalaries.add(170.0);

        employeeIds.add(1007);
        employeeNames.add("Nasser");
        employeeSalaries.add(90.0);

        employeeIds.add(1008);
        employeeNames.add("Sept");
        employeeSalaries.add(665.0);

        employeeIds.add(1009);
        employeeNames.add("Hamed");
        employeeSalaries.add(3350.0);

        employeeIds.add(1010);
        employeeNames.add("Nawras");
        employeeSalaries.add(1000.0);

        //Display Employee Information
        for(int i=0; i < employeeNames.size(); i++){
            //1. Employee index
            System.out.println("Employee "+i+": ");

            //2.  Employee ID
            System.out.println("ID: "+employeeIds.get(i));

            //3. Employee name
            System.out.println("Name: "+employeeNames.get(i));

            //4. Salary
            System.out.println("Salary: "+employeeSalaries.get(i));
        }

        //Calculate Salary Statistics
        //1. Total number of employees
        System.out.println("Total Employees:"+employeeIds.size());

        //2. Total salary paid
        double sum = 0.0;
        for(int i = 0; i<employeeSalaries.size(); i++){
            sum += employeeSalaries.get(i);
        }
        System.out.println("Total Salary: "+sum);

        //3. Average salary
        double average = (double) sum/ employeeIds.size();
        System.out.println("Average Salary: "+average);

        //4. Highest salary & Lowest salary
        double highest = employeeSalaries.get(0);
        double lowest = employeeSalaries.get(0);
        for(double salary: employeeSalaries){
            if(salary > highest){
                highest = salary;
            }
            if (salary<lowest){
                lowest = salary;
            }
        }
        System.out.println("Highest Salary:"+highest);
        System.out.println("Lowest Salary: "+lowest);

        //Salary Category Analysis
        int highSalaryCount = 0;
        int mediumSalaryCount = 0;
        int lowSalaryCount = 0;

        for(int i = 0; i < employeeSalaries.size(); i++){
            //1. Number of employees earning more than 1000
            if(employeeSalaries.get(i) > 1000){
                highSalaryCount++;
                //2. Number of employees earning between 500 and 1000
            } else if(employeeSalaries.get(i) >= 500){
                mediumSalaryCount++;
                //3. Number of employees earning less than 500
            } else {
                lowSalaryCount++;
            }
        }
        System.out.println("High Salary Employees: " + highSalaryCount);
        System.out.println("Medium Salary Employees: " + mediumSalaryCount);
        System.out.println("Low Salary Employees: " + lowSalaryCount);

        //Search Employee System
        //1. Ask the user to enter an employee ID
        IO.println("Please enter employee id you want to search for: ");
        int searchId = Integer.parseInt(IO.readln());

        //2. Check if the product exists
        int searchIndex = -1;
        for (int i = 0; i < employeeIds.size(); i++) {
            if (employeeIds.get(i).equals(searchId)){
                searchIndex = i;
                break;
            }
        }
        if (searchIndex != -1) {
            //Display Employee name, Employee salary & Employee position in the list
            System.out.println("Employee name: " + employeeNames.get(searchIndex));
            System.out.println("Employee salary " + employeeSalaries.get(searchIndex));
            System.out.println("Employee position in the list " + searchIndex);
        } else {
            System.out.println("Employee not found");
        }

        //Update Employee Salary

        //1. Ask the user for employee index
        IO.println("Please enter the index position: ");
        int index = Integer.parseInt(IO.readln());

        //2. Replace the old salary with a new salary
        if (index >= 0 && index < employeeSalaries.size()) {
           //A. Enter the new salary
            IO.println("Enter New Salary: ");
            double updatedSalary = Double.parseDouble(IO.readln());
            //B. Update the salary value using set()
            employeeSalaries.set(index, updatedSalary);
            System.out.println("Salary updated successfully");
        } else {
            System.out.println("Invalid index!");
        }

        //Remove Employee
        IO.println("Please enter employee you want to remove by index: ");
        int removeEmp= Integer.parseInt(IO.readln());
        if (removeEmp >= 0 && removeEmp < employeeNames.size()) {
            String removedName = employeeNames.remove(removeEmp);
            employeeIds.remove(removeEmp);
            employeeSalaries.remove(removeEmp);
            System.out.println("Employee " + removedName + " removed successfully");
        } else {
            System.out.println("Employee not found");
        }

        //Sorting Employees
        //1. Sort employees by salary from lowest to highest
        ArrayList<Double>sortedEmpSalary = new ArrayList<>(employeeSalaries);
        Collections.sort(sortedEmpSalary);
        System.out.println("Sorted Salaries from lowest to highest "+sortedEmpSalary);

        //2. Sort employees by salary from highest to lowest
        Collections.reverse(sortedEmpSalary);
        System.out.println("Sorted Salaries from highest to lowest  "+sortedEmpSalary);

        //Employee Salary Bonus Calculation
        for (int i = 0; i < employeeNames.size(); i++) {
            double currentSalary = employeeSalaries.get(i);
            double bonusPercent = (currentSalary >= 1000) ? 0.10 : (currentSalary >= 500) ? 0.05 : 0.02;
            double bonusAmount = currentSalary * bonusPercent;
            double finalSalary = currentSalary + bonusAmount;
            System.out.println("Name: " + employeeNames.get(i));
            System.out.println("Current Salary: " + currentSalary);
            System.out.println("Bonus Amount: " + bonusAmount);
            System.out.println("Final Salary after bonus: " + finalSalary);
        }

    }
}
