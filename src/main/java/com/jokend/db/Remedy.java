public class Remedy {

    String name;
    int efficiency;
    int comfortability;

    public Remedy(String name, int efficiency, int comfortability){
        this.name = name;
        this.efficiency = efficiency;
        this.comfortability = comfortability;
    }

    public void printRemedy(){
        System.out.printf("INSERT INTO remedies (name, efficiency, comfortability) VALUES ('%s', '%s', '%s');", name, efficiency, comfortability);
        System.out.println();
    }
}
