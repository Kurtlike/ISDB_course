public class District {
    String name;
    int livStandart;

    public District(String name, int livStandart){
        this.name = name;
        this.livStandart = livStandart;
    }

    public String getName() {
        return name;
    }

    public void printDistrict(){
        System.out.printf("INSERT INTO district (name, living_standart) VALUES ('%s', '%s');" , name, livStandart);
        System.out.println();
    }
}
