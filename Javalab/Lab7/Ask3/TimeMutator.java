// 3.	Να προφυλάξετε την Time από την εισαγωγή παράλογων τιμών στην ώρα, ασφαλίζοντας τις μεταβλητές και εισάγοντας μεθόδους μεταλλαγής και προσπέλασης.

package Ask3;
public class TimeMutator {
    private int hours = 00, minutes = 00, seconds = 00;
    public TimeMutator(int hours, int minutes, int seconds){
        setTime(hours, minutes, seconds);
    }

    public TimeMutator(int h){
        this(h,12,54);
    }

    public void setHours(int h){
        if ((h>00) && (h<24)){
            hours = h;
        }
    }

    public void setMinutes(int m){
        if ((m>00) && (m<60)){
            minutes = m;
        }
    }

    public void setSeconds(int s){
        if ((s>00) && (s<60)){
            seconds = s;
        }
    }

    public void setTime(int h, int m, int s){
        setHours(h);
        setMinutes(m);
        setSeconds(s);
    }

    public int getHours(){
        return hours;
    }

    public int getMinutes(){
        return minutes;
    }

    public int getSeconds(){
        return seconds;
    }

}

    



