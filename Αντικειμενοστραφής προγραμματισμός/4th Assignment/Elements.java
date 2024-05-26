// import java.util.ArrayList;
import java.util.*;

public class Elements {
    String elementName;
    String elementSymbol;
    int atomicNumber;
    int elementValence;
    String elementGroup;

    public Elements(String elementName, String elementSymbol, int atomicNumber, int elementValence, String elementGroup) {
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
        this.atomicNumber = atomicNumber;
        this.elementValence = elementValence;
        this.elementGroup = elementGroup;
    }

    public void setElementName(String elementName){
        this.elementName = elementName;
    }

    public String getElementName(){
        return elementName;
    }

    public void setElementSymbol(String elementSymbol){
        this.elementSymbol = elementSymbol;
    }

    public String getElementSymbol(){
        return elementSymbol;
    }

    public void setAtomicNumber(int atomicNumber){
        this.atomicNumber = atomicNumber;
    }

    public int getAtomicNumber(){
        return atomicNumber;
    }

    public void setElementValence (int elementValence){
        this.elementValence = elementValence;
    }

    public int getElementValence(){
        return elementValence;
    }

    public void setElementGroup(String elementGroup){
        this.elementGroup = elementGroup;
    }

    public String getElementGroup(){
        return elementGroup;
    }

    public String toString(){
        return "~~~~" + elementName + "~~~~" + "\n" + "Element Symbol: " + elementSymbol + "\n" + "Atomic Number: " + atomicNumber + "\n" +"Element Valence: " + elementValence + "\n" +"Element Group: " + elementGroup + "\n";
    }
    
    //Μέθοδος για εκτύπωση λίστας
    public static void printChemicalElements(ArrayList<Elements> list){
        for (Elements e: list){
            System.out.println(e);
        }
    }

    //Ταξινόμηση λίστας αλφαβητικά και εκτύπωση
    public static void sortAlphabetically(ArrayList<Elements> list){
    Collections.sort(list, Comparator.comparing(Elements::getElementName));
    printChemicalElements(list);
    }
    
    public static void sortByAtomicNumber(ArrayList<Elements> list){
        Collections.sort(list, Comparator.comparing(Elements::getAtomicNumber));
        printChemicalElements(list);
        Elements e1 = list.get(0);
        System.out.println("The lightest element is: " + e1.getElementName());
        Elements e2 = list.get(list.size()-1);
        System.out.println("The heaviest element is: " + e2.getElementName());
    }
    public static void sortByValence(ArrayList<Elements> list){
        Collections.sort(list, Comparator.comparing(Elements::getElementValence));
        printChemicalElements(list);
        ArrayList<Elements> halogenList = new ArrayList<Elements>();
        for (int i=0; i<list.size();i++){
            if (list.get(i).getElementGroup().equals("Halogens")) {
                halogenList.add(list.get(i));
            }
        }
        Elements h1 = halogenList.get(0);
        Elements h2 = halogenList.get(halogenList.size()-1);
        System.out.println("The halogen with the lowest valence is: " + h1.getElementName());
        System.out.println("The halogen with the highest valence is: " + h2.getElementName());
    }
        


public static void main(String[] args) {

    ArrayList<Elements> list = new ArrayList<Elements>();
    list.add(new Elements("Hydrogen", "H", 1, 1, "Non-metal"));
    list.add(new Elements("Carbon", "C", 6, 4, "Non-metal"));
    list.add(new Elements("Nitrogen", "N", 7, 3, "Non-metal"));
    list.add(new Elements("Phosphorus", "P", 15, 3, "Non-metal"));
    list.add(new Elements("Oxygen", "O", 8, -2, "Non-metal"));
    list.add(new Elements("Sulfur", "S", 16, -2, "Non-metal"));
    list.add(new Elements("Selenium", "Se", 34, 4, "Non-metal"));
    list.add(new Elements("Fluorine", "F", 9, -1, "Halogens"));
    list.add(new Elements("Chlorine", "Cl", 17, -1, "Halogens"));
    list.add(new Elements("Bromine", "Br", 35, -1, "Halogens"));
    list.add(new Elements("Iodine", "I", 53, -1, "Halogens"));
    list.add(new Elements("Astatine", "At", 85, 2, "Halogens"));
    list.add(new Elements("Tennessine", "Ts", 117, 2, "Halogens"));

   
    //Εκτύπωση λίστας
    printChemicalElements(list);

    //Εκτύπωση λίστας αλφαβητικά
    System.out.println("~~~~~~~~~~~~~~~~~~");
    sortAlphabetically(list);
    //Εκτύπωση λίστας ταξινομημένη με τον ατομικό αριθμό και εκτύπωση των στοιχείων με το μικρότερο και μεγαλύτερο ατομικό αριθμό
    System.out.println("~~~~~~~~~~~~~~~~~~");
    sortByAtomicNumber(list);
    //Εκτύπωση λίστας ταξινομημένη με το σθένος και εκτύπωση των αλογόνων με το μικρότερο και μεγαλύτερο σθένος
    System.out.println("~~~~~~~~~~~~~~~~~~");
    sortByValence(list);

}



}

