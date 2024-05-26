import java.util.*;



class GuessGame {

    int N;
    int number;
    int guess;

    public GuessGame(){
        
        Scanner scanN = new Scanner(System.in);

        System.out.println("What's the range of the numbers (1...N)?");
        
        String input = scanN.nextLine();

        if (input.equals("")){
            N = 10;
        } else {
            N = Integer.parseInt(input);
        }

            
        number = (int)Math.round(Math.random()*N);
        
        
        int count = 0;
        
        while (true) {
            System.out.println("Give a number to guess: ");
            
            guess = scanN.nextInt();
            ++count; 
            if ((checkNumber())==false) {
                break;
            }
            
        }
        System.out.println("You tried " + count + " times!");

        scanN.close();
        
}

    
    public boolean checkNumber(){

        if (guess>number) {
            System.out.println("The number you are looking for is smaller!");
            return true;
        }

        else if (guess<number) {
            System.out.println("The number you are looking for is larger!");
            return true;
        }

        else {
            System.out.println("You got it!");
            
            return false;  
        }
    }



    public static void main(String[] args) {
        
        
        GuessGame guessgame = new GuessGame();

    }
    
}
