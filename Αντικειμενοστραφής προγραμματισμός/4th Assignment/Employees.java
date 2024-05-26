public class Employees {
    String name;
    int age;
    int yearsWorked;
    String gender;
    String phoneNumber;
    boolean married;
    int children;
    int minimumWage;
    int salary;
    int childBonus;
    int yearsBonus;
    int totalYearBonus;

    public Employees(String name, int age, int yearsWorked, String gender, String phoneNumber, boolean married, int children, int minimumWage) {
        this.name = name;
        this.age = age;
        this.yearsWorked = yearsWorked;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.children = children;
        this.married = married;
        this.minimumWage = minimumWage;
        this.childBonus = 40*children;
           
    }

    class ProductionEmployees extends Employees{
        
        public ProductionEmployees(String name, int age, int yearsWorked, String gender, String phoneNumber, boolean married, int children, int minimumWage){
            super(name,age,yearsWorked,gender,phoneNumber,married,children,minimumWage);
            this.minimumWage = 1200;
            this.yearsBonus = 30;
            this.totalYearBonus = (yearsWorked/5)*yearsBonus;
            this.salary = minimumWage + totalYearBonus + childBonus;
        }
    }

    class Managers extends Employees{
        public Managers(String name, int age, int yearsWorked, String gender, String phoneNumber, boolean married, int children, int minimumWage){
            super(name,age,yearsWorked,gender,phoneNumber,married,children,minimumWage);
            this.yearsBonus = 50;
            this.totalYearBonus = (yearsWorked/5)*yearsBonus;
            this.salary = minimumWage + totalYearBonus + childBonus;
        }
    }
    public String toString(){
        return "Name: " + name + "\n"+ "Age: " + age + "\n" +  "Gender: " + gender + "\n" + "Phone Number: " +phoneNumber+"\n"+"Married: "+ married + "\n" + "Salary: "+ salary+ "\n";
        
    }
    public static void main(String[] args) {
        Employees[] employees = new Employees[5];
        employees[0] = new Employees("Kostas Christou", 39, 15, "male", "6979890483", true, 2, 1200).new ProductionEmployees("Kostas Christou", 39, 15, "male", "6979890483", true, 2, 1200);
        employees[1] = new Employees("Nikos Papadopoulos", 30, 22, "Male", "123451", false, 0, 0).new ProductionEmployees("Nikos Papadopoulos", 30, 22, "Male", "123451", false, 0, 0);
        employees[2] = new Employees("John Smith", 46,25,"Male", "2459015", true, 3, 1300).new Managers("John Smith", 46,25,"Male", "2459015", true, 3, 1300);
        employees[3] = new Employees("Jane Doe", 29,7,"Female", "24455125",false, 0, 1600).new Managers("Jane Doe", 29,7,"Female", "24455125",false, 0, 1600);
        employees[4] = new Employees("Μαρία Παπαδοπούλου", 52,30,"Female", "2125215", true, 3, 2000).new Managers("Μαρία Παπα", 52,30,"Female", "2125215", true, 3, 2000);
        for (int i=0; i<employees.length;i++){
            System.out.println(employees[i]);
        }

    }
}
