import java.util.Random;

public class Staff {
    private String name;
    private int id;
    private String gender;
    private String role;
    static int noStaff;

    Random random = new Random();

    Staff(String name, String gender, String role){
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.id = random.nextInt(2000);
        setNoStaff();
    }

    public static void setNoStaff(){
        noStaff++;
    }

    public int getId(){
        return id;
    }

    public void displayInfo(){
        System.out.println();
        System.out.println("=\t\t\t\t\t\t\t\t\t\t=====Staff Details======");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tName:\t| " + name);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tID:\t\t| " + id);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tGender: | " + gender);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tRole:\t| " + role);
        System.out.println();
    }

}
