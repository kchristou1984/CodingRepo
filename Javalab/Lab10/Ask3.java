import java.util.*;

public class Ask3 {

    public static void sortList(ArrayList<String> stringList){
        stringList.sort(Comparator.naturalOrder());
    }

    public static String longestString(ArrayList<String> stringList){
         
        String longest = stringList.get(0);
        for (int i = 0; i<stringList.size(); i++){
            if (stringList.get(i).length()>longest.length()){
                longest = stringList.get(i);
            }
        }
        return longest;
    }

    public static boolean findString(ArrayList<String> stringList, String stringToFind){
        for (int i = 0; i<stringList.size(); i++){
            if (stringList.get(i).equals(stringToFind)){
                return true;
            }
                
            }return false;
        } 
    

    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<String>(10);

        stringList.add("Apple");
        stringList.add("Mountain");
        stringList.add("River");
        stringList.add("Sunset");
        stringList.add("Elephant");
        stringList.add("Galaxy");
        stringList.add("Whisper");
        stringList.add("Thunder");
        stringList.add("Meadow");
        stringList.add("Crystal");    
        
        System.out.println("Original List: " + "\n"+ stringList);
        sortList(stringList);
        System.out.println("Sorted List: " + "\n"+ stringList);
        System.out.println("Longest String is: " + longestString(stringList));
        System.out.println(findString(stringList, "Elephant"));
        System.out.println(findString(stringList, "Balloon"));

    }

}
