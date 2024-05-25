import java.util.Random;

public class Fir {
    private String name;
    private int cnic;
    private String date;
    private String time;
    private String location;
    private String description;
    private int caseno;
    static int nofirs;

    Random random = new Random();

    Fir(String name, int cnic ,String date, String time, String location, String description){
        this.name = name;
        this.cnic = cnic;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.caseno = random.nextInt(100000);
        setNofirs();
    }

    public static void setNofirs(){
        nofirs++;
    }
    public String getName(){
        return name;
    }

    public int getCaseno(){
        return caseno;
    }

    public int getNofirs(){
        return nofirs;
    }

    public void displayInfo(){
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t=======FIR(First Information Report)=======");
        System.out.println("\t\t\t\t\t\t\t\t\t\tVictim Name:\t\t\t| " + name);
        System.out.println("\t\t\t\t\t\t\t\t\t\tVictim NIC:\t\t\t\t| " + cnic);
        System.out.println("\t\t\t\t\t\t\t\t\t\tDate:\t\t\t\t\t| " + date);
        System.out.println("\t\t\t\t\t\t\t\t\t\tCase number:\t\t\t| " + caseno);
        System.out.println("\t\t\t\t\t\t\t\t\t\tTime of Incident:\t\t| " + time);
        System.out.println("\t\t\t\t\t\t\t\t\t\tIncident Location:\t\t| " + location);
        System.out.println("\t\t\t\t\t\t\t\t\t\tIncident Description:\t| " + description);
        System.out.println();
    }
}
