class Date{
    int day, month, year;

    Date(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }

    public String toString(){
        return day + "/" + month + "/" + year;
    }
}

class DateTime extends Date{
    int hour, minute, second;

    DateTime(int d, int mo, int y, int h, int m, int s){
        super(d, mo, y);
        hour = h;
        minute = m;
        second = s;
    }

    public String toString(){

        return super.toString() + " " + hour +  ":" + minute + ":" + second;
    }
    public static void main(String[] args){
        DateTime dt = new DateTime(8, 4, 2022, 8, 31, 2);
        System.out.println(dt);
    }
}

class AccurateDate extends DateTime{
    int millisecond;

    AccurateDate(int d, int mo, int y, int h, int m, int s, int ms){
        super(d, mo, y, h, m, s);
        millisecond = ms;
    }

    public String toString(){
        return super.toString() + ":" + millisecond;
    }

    public static void main(String[] args){
        AccurateDate td = new AccurateDate(8, 4, 2022, 8, 31, 2, 14);
        System.out.println(td);
    }

}

class DateEvent extends Date{
    String eventName;
    
    DateEvent(int d, int mo, int y, String en){
        super(d, mo, y);
        eventName = en;
    }
    public String toString(){
        return super.toString() + " " + eventName;
    }

    public static void main(String[] args) {
        DateEvent e1 = new DateEvent(25, 3, 2022, "Επέτειος 1821");
        DateEvent e2 = new DateEvent(28, 10, 2022, "Επέτειος 1940");
        System.out.println(e1);
        System.out.println(e2);
    }
}

