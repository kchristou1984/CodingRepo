//import java.util.Arrays;

class Contact {
    
    private String phoneNumber;
    private String name;
    private String email;
    private int calls;
    public static int contactIndex;


    public Contact(String phoneNumber,String name,String email){
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.calls = 0;
    }
    
    
    static Contact[] contactsArray = new Contact[100];
    

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    // public void setCalls(){
    //     //this.calls = calls;
    // }

    public int getCalls(){
        return calls;
    }


    public void addContact(Contact contact){  
        contactsArray[contactIndex] = contact;
        contactIndex++; 
    }

    public static void changeContact(String newName, String newEmail, String phoneNumber){
        for(int i = 0;i<contactsArray.length;i++){
            if (contactsArray[i]!=null && contactsArray[i].getPhoneNumber() == phoneNumber){
                contactsArray[i].setName(newName);
                contactsArray[i].setEmail(newEmail);
                System.out.println("Contact succesfully updated!");
            }
        }
    }

    public static void deleteContact(String phoneNumber) {
        for(int i = 0;i<contactsArray.length;i++){
            if (contactsArray[i]!=null && contactsArray[i].getPhoneNumber() == phoneNumber){
                contactsArray[i] = null;
                
          }
        }
    }

    public static void contactCall(String phoneNumber){
        for(int i = 0;i<contactsArray.length;i++){
            if (contactsArray[i]!=null && contactsArray[i].getPhoneNumber() == phoneNumber){
                contactsArray[i].calls++;
            }
        }
        
    }

    public static void searchContactByEmail(String email){
        for(int i=0;i<contactsArray.length;i++){
            if (contactsArray[i]!=null && contactsArray[i].getEmail()==email){
                System.out.println("Name: " + contactsArray[i].getName());
                System.out.println("Phone number: " + contactsArray[i].getPhoneNumber());
                System.out.println("Email: " + contactsArray[i].getEmail());
                System.out.println("Calls: " + contactsArray[i].getCalls());
                System.out.println("");    
            }
        }
    }

    public static void searchContactByPhone(String phoneNumber){
        for(int i=0;i<contactsArray.length;i++){
            if (contactsArray[i]!=null && contactsArray[i].getPhoneNumber()==phoneNumber){
                System.out.println("Name: " + contactsArray[i].getName());
                System.out.println("Phone number: " + contactsArray[i].getPhoneNumber());
                System.out.println("Email: " + contactsArray[i].getEmail());
                System.out.println("Calls: " + contactsArray[i].getCalls());
                System.out.println("\n");
            }         }
    }
    
    public static void callsCount(){
        for(int i = 0;i<contactsArray.length;i++){
            if (contactsArray[i]!=null ){
                System.out.println("Contact " + contactsArray[i].getName() + " has " +  contactsArray[i].getCalls() + " calls" + "\n");
            }
            }
        }
    

    public static void searchByCalls(int callsNumber){
        for(int i = 0;i<contactsArray.length;i++){
            if (contactsArray[i]!=null ){
                if (contactsArray[i].calls>callsNumber){
                    System.out.println("Contact " + contactsArray[i].getName() + " has more than " + callsNumber + " calls" + "\n");
                    
            }
            }
        }
    }
    

    public static void main(String[] args) {
        Contact contact1 = new Contact("697989048","Kostas","kchristo@hotmail.gr");
        Contact contact2 = new Contact("697357412", "Ioulia", "ioupap@yahoo.gr");
        Contact contact3 = new Contact("242110507", "Orestis", "christou_or@gmail.com");
        Contact contact4 = new Contact("210932791", "Aris","christou_ar@gmail.com");
        
        contact1.addContact(contact1);
        contact2.addContact(contact2);
        contact3.addContact(contact3);
        contact4.addContact(contact4);

        
        contactCall("697989048");
        System.out.println(contact1.getCalls());
        contactCall("697989048");
        System.out.println(contact1.getCalls());
        //deleteContact("697357412");
        searchByCalls(1);
        callsCount();
        searchContactByEmail("kchristo@hotmail.gr");
        searchContactByPhone("697357412");
        changeContact("Julia","nau@yahoo.gr", "697357412");
        searchContactByPhone("697357412");

        //System.out.println(Arrays.toString(contactsArray));

    }
}