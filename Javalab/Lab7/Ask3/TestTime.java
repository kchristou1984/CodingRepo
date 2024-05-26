package Ask3;

public class TestTime {
    public static void main(String[] args) {
        TimeMutator x = new TimeMutator(8,34,12);
        System.out.println("The time is " + x.getHours() + ":" + x.getMinutes() + ":" + x.getSeconds());
        x.setHours(25);
        x.setMinutes(62);
        x.setSeconds(32);
        System.out.println("The time is " + x.getHours() + ":" + x.getMinutes() + ":" + x.getSeconds());

    }
}
