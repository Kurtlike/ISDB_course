public class PublicPlace {
    int id;
    String cl;
    String district;
    boolean isWporking;
    int capacity;
    int area;
    int time_visitor;
    int time_staff;
    int restrictions;

    public PublicPlace (int id, String cl, String district, boolean isWporking, int capacity, int area, int time_visitor, int time_staff, int restrictions){
        this.id = id;
        this.cl = cl;
        this.district = district;
        this.isWporking = isWporking;
        this.capacity = capacity;
        this.area = area;
        this.time_visitor = time_visitor;
        this.time_staff = time_staff;
        this.restrictions = restrictions;
    }

    public void setTime_staff(int time_staff) {
        this.time_staff = time_staff;
    }

    public void printPublicPlace(){
        System.out.printf("INSERT INTO public_places (class, district, is_working, capacity, area, avr_time_visitor, avr_time_staff, restrictions_level) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');", cl, district, isWporking, capacity, area, ""+time_visitor+" MINUTE", ""+time_staff+" MINUTE", restrictions);
        System.out.println();
    }
}
