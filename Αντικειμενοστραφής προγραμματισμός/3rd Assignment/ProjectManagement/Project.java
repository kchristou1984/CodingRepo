package ProjectManagement;

public class Project {
    private String title;
    private String startDate;
    private String endDate;
    private Supervisor supervisor;


    public Project(){
        this.title = "";
        this.startDate = "";
        this.endDate = "";
        
    }

    public Project(String title, String startDate, String endDate, Supervisor supervisor){
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.supervisor = supervisor;
    }
    //Μέθοδος για τα στοιχεία του έργου

    public void showInfo(){
        System.out.println("Project Title: " + title);
        System.out.println("The project started on " + startDate);
        System.out.println("The project ended on " + endDate);
        System.out.println("The supervisor is " + supervisor.getName());
    }


}
