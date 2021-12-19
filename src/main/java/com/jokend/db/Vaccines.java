public class Vaccines {

    int vaccine_id;
    int virus_id;
    int max_age;
    int efficiency;

    public Vaccines (int vaccine_id, int virus_id, int max_age, int efficiency){
        this.vaccine_id = vaccine_id;
        this.virus_id = virus_id;
        this.max_age = max_age;
        this.efficiency = efficiency;
    }

    public void printVaccine(){
        System.out.printf("INSERT INTO vaccines (vaccine_id, virus_id, max_age, efficiency) VALUES ('%s', '%s', '%s', '%s');", vaccine_id, virus_id, max_age, efficiency);
        System.out.println();
    }

}
