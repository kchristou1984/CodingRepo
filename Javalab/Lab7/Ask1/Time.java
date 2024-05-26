// 1.	Βάσει του παραδείγματος της κλάσης Date, να κατασκευάσετε μια νέα κλάση Time για 
// την αναπαράσταση της ώρας, θεωρώντας ότι η ώρα αποτελείται από ώρες, λεπτά και 
// δευτερόλεπτα. Η κλάση να περιέχει κατάλληλες μεθόδους δημιουργούς, και toString.

package Ask1;

class Time{
    int  hours, minutes, seconds;
    
    Time(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    //Overloaded constructor
    Time(int h){
        this(h, 23,45);
    }

    public String toString(){
        String s;
        s = hours + ":" + minutes + ":" + seconds;
        return s;
    }

    public boolean equals(Time other){
        boolean b = false;
        if((hours == other.hours) && (minutes == other.minutes) && (seconds == other.seconds)){
            b=true;
        }
        return b;
    }

    public static void main(){
        Time x = new Time(15,34,12);
        System.out.println(x);

        Time y = new Time(11);
        System.out.println(y);

        boolean b = x.equals(y);
        if (b == true){
            System.out.println("Equal");
        }else{
            System.out.println("Not equal");
        }

    }
}