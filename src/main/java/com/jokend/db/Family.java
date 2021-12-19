import java.util.ArrayList;

public class Family {
    int id;
    ArrayList<Integer> INN = new ArrayList<>();
    ArrayList<String> role = new ArrayList<>();
    int persons = 0;

    public  Family (int id){
        this.id = id;
    }

    public void addHuman(int INN, String role){
        this.INN.add(INN);
        this.role.add(role);
        persons++;
    }

    public void printFamily(){
        for(int i = 0; i < INN.size(); i++) {
            System.out.printf("INSERT INTO families (id, INN , role) VALUES ('%s', '%s', '%s');", id, INN.get(i), role.get(i));
            System.out.println();
        }
    }
}
