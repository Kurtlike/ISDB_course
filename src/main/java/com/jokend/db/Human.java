import java.sql.Timestamp;

public class Human {
    int INN;
    String status;
    int age;
    Timestamp birthday;
    String district;
    String remedy;

    public Human(int INN, String status, int age, String district){
        this.INN = INN;
        this.age = age;
        this.status = status;
        this.district = district;
        long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
        birthday = rand;
        birthday.setYear(rand.getYear() - age);
    }

    public void setRemedy(String remedy) {
        this.remedy = remedy;
    }

    public void printHuman(){
        System.out.printf("INSERT INTO humans (status, birthday, district) VALUES ('%s', '%s', '%s');", status, birthday, district);
        System.out.println();
    }
}
