public class Date {
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
