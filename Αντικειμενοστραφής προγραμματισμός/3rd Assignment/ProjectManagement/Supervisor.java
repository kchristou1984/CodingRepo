package ProjectManagement;


public class Supervisor {
    private String name;
    private String surname;
    private String Id;

    public Supervisor(String name, String surname, String Id){
        this.name = name;
        this.surname = surname;
        this.Id = Id;
    }
    //Μέθοδος για τα στοιχεία του supervisor
    public String getName(){
        return name + " " + surname;
    }

    public String getId(){
        return Id;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSurname(String newSurname){
        this.surname = newSurname;
    }

    public void setId(String newId){
        this.Id = newId;
    }


    
}

