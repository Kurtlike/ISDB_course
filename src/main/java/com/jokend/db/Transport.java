public class Transport {
    String district1;
    String district2;
    int id;
    String type;
    int capacity;
    int area;
    int avrTime;
    String start;
    String end;

    public Transport(String district1, String district2, int id, String type, int capacity, int area, int avrTime, String start, String end){
        this.district1 = district1;
        this.district2 = district2;
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.area = area;
        this.avrTime = avrTime;
        this.start = start;
        this.end = end;
    }

    public void printTransport(){
        System.out.printf("INSERT INTO public_transport (district_1 , district_2, type, capacity, area, period, start_time, end_time) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');" , district1, district2, type, capacity, area, ""+avrTime+" MINUTE", start, end);
        System.out.println();
    }
}
