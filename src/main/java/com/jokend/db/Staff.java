public class Staff {
    int INN;
    int place;
    String startTime;
    String endTime;

    public Staff(int INN, int place, String startTime, String endTime){
        this.INN = INN;
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void printStaff(){
        System.out.printf("INSERT INTO staff(INN, place_id, start_time, end_time) VALUES ('%s', '%s', '%s', '%s');", INN, place, startTime, endTime);
        System.out.println();
    }
}
