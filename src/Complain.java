
public class Complain {
    private String name;
    private String cnic;
    private String description;
    private boolean isSolved;
    static int noComplain;

    Complain(String name, String cnic, String description){
        this.cnic = cnic;
        this.name = name;
        this.description = description;
        this.isSolved = false;
        setNoComplain();
    }

    public static void setNoComplain(){
        noComplain++;
    }

    public String getCnic(){
        return cnic;
    }

    public void setSolved(){
        isSolved = true;
    }

    public void displayInfo(){
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t======Complain Details======");
        System.out.println("\t\t\t\t\t\t\t\t\t\tComplainee Name: | " + name);
        System.out.println("\t\t\t\t\t\t\t\t\t\tComplainee CNIC: | " + cnic);
        System.out.println("\t\t\t\t\t\t\t\t\t\tComplain:\t\t | " + description);
        System.out.println("\t\t\t\t\t\t\t\t\t\tComplain Status: | " + isSolved);
        System.out.println();
    }
}
