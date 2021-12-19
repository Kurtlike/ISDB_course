import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Generator {

    public static ArrayList<Human> human = new ArrayList<>();

    public static void Generate(int podgon, int disCount, int avgFamilySize, int humans) {
        ArrayList<District> districts = generateDistricts(disCount);
        ArrayList<Transport> transports = generateTransports(disCount, districts);
        ArrayList<PublicPlace> places = generatePlaces(disCount, districts, humans, podgon);
        ArrayList<Family> families = generateFamilies(humans, avgFamilySize, disCount, districts);
        ArrayList<Staff> staff = generateStaff(places, humans);
        human.forEach((n) -> n.printHuman());
        districts.forEach((n) -> n.printDistrict());
        transports.forEach((n) -> n.printTransport());
        places.forEach((n) -> n.printPublicPlace());
        families.forEach((n) -> n.printFamily());
        staff.forEach((n) -> n.printStaff());
    }

    private static ArrayList<Staff> generateStaff(ArrayList<PublicPlace> places, int humans) {
        ArrayList<Staff> ans = new ArrayList<>();
        int p = 0;
        int placesize = 0;
        for(int i = 0; i < places.size(); i++){
            if(places.get(i).cl.equals("офис")){
                placesize = places.get(i).capacity;
            }else {
                placesize = places.get(i).capacity / 8 + 4;
            }
            for(int j = 0; j < placesize; j++){
                if((human.get(p).age > 20) && (human.get(p).age < 65)){
                    switch (places.get(i).cl){
                        case "офис": ans.add(new Staff(p, i+1, "9:00", "17:00"));
                            break;
                        case "магазин": {
                            int start = (int)Math.floor(Math.random() * 16);
                            int end = start + 8;
                            ans.add(new Staff(p, i+1, ""+start+":00", ""+end+":00"));
                            break;
                        }
                        case "парк": ans.add(new Staff(p, i+1, "10:00", "18:00"));
                            break;
                        case "аптека": {
                            int start = (int)Math.floor(Math.random() * 16);
                            int end = start + 8;
                            ans.add(new Staff(p, i+1, ""+start+":00", ""+end+":00"));
                            break;
                        }
                    }
                }
                if(p < humans){
                    p++;
                }else{
                    p -= humans;
                    p++;
                }
            }
        }
        return ans;
    }

    private static ArrayList<Family> generateFamilies(int humans, int avgFamilySize, int disCount, ArrayList<District> districts) {
        ArrayList<Family> ans = new ArrayList<>();
        int k = 1;
        int p = 1;
        while(p <= humans){
            int size = (int)Math.floor(Math.random() * (avgFamilySize*2 - 1) + 1);
            ans.add(new Family(k));
            String dis = districts.get((int)Math.floor(Math.random() * disCount)).getName();
            for(int j = 0; j < size; j++){
                int age = 0;
                if(j <= 1){
                    age = (int)Math.floor(Math.random() * 50 + 20);
                }else{
                    age = (int)Math.floor(Math.random() * 18 + 1);
                }
                String role = "parent";
                if(age < 20) role = "children";
                human.add(new Human(p, "ok", age, dis));
                ans.get(k-1).addHuman(p, role);
                p++;
            }
            k++;
        }
        return ans;
    }

    private static ArrayList<PublicPlace> generatePlaces(int disCount, ArrayList<District> districts, int humans, int podgon) {
        ArrayList<PublicPlace> ans = new ArrayList<>();
        int k = 1;
        for(int i = 0; i < humans/podgon; i++){
            String[] type = new String[]{"магазин", "офис", "парк", "аптека"};
            String t = type[(int)Math.floor(Math.random() * type.length)];
            switch (t){
                case "магазин" : ans.add(new PublicPlace(k, t, districts.get((int)Math.floor(Math.random() * disCount)).getName(), true, (int)Math.floor(Math.random() * 150 + 10), (int)Math.floor(Math.random() * 50 + 18), (int)Math.floor(Math.random() * 30 + 1), 480, 0));
                    break;
                case "офис" : ans.add(new PublicPlace(k, t, districts.get((int)Math.floor(Math.random() * disCount)).getName(), true, (int)Math.floor(Math.random() * 200 + 15), (int)Math.floor(Math.random() * 600 + 70), 0, 480, 0));
                    break;
                case "парк" : ans.add(new PublicPlace(k, t, districts.get((int)Math.floor(Math.random() * disCount)).getName(), true, (int)Math.floor(Math.random() * 700 + 50), (int)Math.floor(Math.random() * 10000 + 500), (int)Math.floor(Math.random() * 120 + 1), 480, 0));
                    break;
                case "аптека" : ans.add(new PublicPlace(k, t, districts.get((int)Math.floor(Math.random() * disCount)).getName(), true, (int)Math.floor(Math.random() * 25 + 5), (int)Math.floor(Math.random() * 30 + 15), (int)Math.floor(Math.random() * 30 + 1), 480, 0));
                    break;
            }
            k++;
        }
        return ans;
    }

    private static ArrayList<Transport> generateTransports(int disCount, ArrayList<District> districts) {
        ArrayList<Transport> ans = new ArrayList<>();
        int k = 1;
        for(int i = 0; i < disCount; i++){
            for(int j = i; j < disCount; j++){
                if(i != j) {
                    String[] type = new String[]{"маршрутка", "автобус", "трамвай"};
                    int cap = (int)Math.floor(Math.random() * 50 + 18);
                    int area = (int)Math.floor(Math.random() * 20 + cap/2.5);
                    int period = (int)Math.floor(Math.random() * 20 + 10);
                    String start = "7:00";
                    String end = "24:00";
                    ans.add(new Transport(districts.get(i).getName(), districts.get(j).getName(), k, type[(int)Math.floor(Math.random() * type.length)], cap, area, period, start, end));
                    k++;
                }
            }
        }
        return ans;
    }

    private static ArrayList<District> generateDistricts(int count) {
        ArrayList<District> ans = new ArrayList<>();
        for(int i = 0; i < count; i++){
            char letter = (char)(i%33 + 65);
            int level = (int)Math.floor(Math.random() * 100);
            ans.add(new District("" + letter + i/33, level));
        }
        return ans;
    }
}