
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

class PoliceStation {
    private List<Fir> firs;
    private List<Complain> complains;
    private List<Staff> staffList;

    PoliceStation(){
        firs = new ArrayList<>();
        complains = new ArrayList<>();
        staffList = new ArrayList<>();
    }

    public void addFir(Fir fir){
        firs.add(fir);
    }

    public void delFir(int caseid){
        for (Fir fir : firs){
            if (fir.getCaseno() == caseid){
                firs.remove(fir);
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\t-----Case Removed Successfully----");
                break;
            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\tCase Not Found! OR Invalid Entry");
            }
        }
    }

    public void addComplain(Complain complain){
        complains.add(complain);
    }

    public void updateComplain(int id){
        for (Complain complain : complains){
            if (complain.getCnic() == id){
                complain.setSolved();
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\t----Status Updated-----");
                break;
            } else {
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\tNo Complain Registered On " + id);
            }
        }
    }

    public void addStaff(Staff staff){
        staffList.add(staff);
    }

    public void delStaff(int id) {
        Iterator<Staff> iterator = staffList.iterator();
        while (iterator.hasNext()) {
            Staff staff = iterator.next();
            if (staff.getId() == id) {
                iterator.remove();
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t-----Staff Removed Successfully-----");
                return;
            }
        }
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\tStaff with ID " + id + " not found.");
    }

    public void home(){
        Scanner input = new Scanner(System.in);
        boolean a = true;

        while (a){
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t===========Police Station Management System===========");
            System.out.println();
            System.out.println("\t\t\t1] Register/Update FIR\t\t2] Register/Update Civil Complain\t\t3] Add/Remove Staff");
            System.out.println("\t\t\t4] View FIR\t\t\t\t\t5] View Complain\t\t\t\t\t\t6] View Staff");
            System.out.println("\t\t\t\t\t\t\t\t7] View Report\t\t\t\t\t8] Exit");
            System.out.println();
            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1:
                    boolean b = true;
                    while (b){
                        System.out.println();
                        System.out.println("\t\t\t\t\t\t\t1] Register FIR\t\t2] Delete FIR\t\t3] Go Back");
                        System.out.println();
                        System.out.print("\t\t\t\t\t\t\t\t\t\t\tSelect an option: ");
                        int select = input.nextInt();
                        input.nextLine();
                        if (select == 1) {
                            System.out.println();
                            System.out.println("\t\t\t\t\t\t\t\t\t=============FIR=============");
                            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter victim name: ");
                            String name = input.nextLine();
                            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter victim CNIC no: ");
                            int cnic = input.nextInt();
                            input.nextLine();
                            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter incident date: ");
                            String date = input.nextLine();
                            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter time of incident: ");
                            String time = input.nextLine();
                            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter location of incident: ");
                            String location = input.nextLine();
                            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter incident description: ");
                            String description = input.nextLine();
                            Fir newfir = new Fir(name,cnic,date,time,location,description);
                            addFir(newfir);
                            newfir.displayInfo();
                            System.out.println("\t\t\t\t\t\t\t\t---------FIR Registered Successfully---------");

                        } else if (select == 2) {
                            System.out.println();
                            System.out.print("\t\t\t\t\t\t\t\t\t\t\tEnter case ID : ");
                            int caseno = input.nextInt();
                            delFir(caseno);

                        } else if (select == 3) {
                            b = false;
                            break;
                        } else {
                            System.out.println();
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\tInvalid Entry!");

                        }
                    }
                    break;

                case 2:
                    boolean c = true;
                    while (c){
                        System.out.println();
                        System.out.println("\t\t\t\t\t1] Register Complain\t\t2] Update Complain Status\t\t3] Go Back");
                        System.out.println();
                        System.out.print("\t\t\t\t\t\t\t\t\t\tSelect an option: ");
                        int select2 = input.nextInt();
                        input.nextLine();

                        if (select2 == 1) {
                            System.out.println("\t\t\t\t\t\t\t\t\t===========Complain==========");
                            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter complainee name: ");
                            String name2 = input.nextLine();
                            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter complainee CNIC: ");
                            int cnic2 = input.nextInt();
                            input.nextLine();
                            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter your complain: ");
                            String desciption2 = input.nextLine();

                            Complain newcomplain = new Complain(name2,cnic2,desciption2);
                            addComplain(newcomplain);
                            newcomplain.displayInfo();
                            System.out.println("\t\t\t\t\t\t\t-----Complain Registered Successfully-----");

                        } else if (select2 == 2) {
                            System.out.println();
                            System.out.print("\t\t\t\t\t\t\t\t\tEnter your cnic number: ");
                            int nic = input.nextInt();
                            input.nextLine();
                            updateComplain(nic);

                        } else if (select2 == 3) {
                            b = false;
                            break;

                        } else {
                            System.out.println();
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\tInvalid Entry!");
                        }
                    }
                    break;

                case 3:
                    boolean d = true;
                    while (d) {
                        System.out.println();
                        System.out.println("\t\t\t\t\t\t1] Add Staff\t\t2] Remove Staff\t\t\t3] Go Back");
                        System.out.println();
                        System.out.print("\t\t\t\t\t\t\t\t\t\tSelect an option: ");
                        int select3 = input.nextInt();
                        input.nextLine();

                        if (select3 == 1) {
                            System.out.println();
                            System.out.println("\t\t\t\t\t\t\t\t\t\t=======Staff Details=======");
                            System.out.print("\t\t\t\t\t\t\t\t\t\t\tName: " );
                            String name3 = input.nextLine();
                            System.out.print("\t\t\t\t\t\t\t\t\t\t\tGender: ");
                            String gender = input.nextLine();
                            System.out.print("\t\t\t\t\t\t\t\t\t\t\tRole: ");
                            String role = input.nextLine();

                            Staff newstaff = new Staff(name3,gender,role);
                            addStaff(newstaff);
                            newstaff.displayInfo();
                            System.out.println("\t\t\t\t\t\t\t\t\t-----Staff Added Successfully-----");

                        } else if (select3 == 2) {
                            System.out.println();
                            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter staff ID: ");
                            int id = input.nextInt();
                            input.nextLine();
                            delStaff(id);

                        } else if (select3 == 3) {
                            d = false;
                            break;
                        } else {
                            System.out.println();
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\tInvalid Entry!");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println();
                    System.out.print("\t\t\t\t\t\t\t\t\t\tEnter caseid: ");
                    int caseid = input.nextInt();
                    input.nextLine();

                    for (Fir fir : firs) {
                        if (fir.getCaseno() == caseid) {
                            fir.displayInfo();
                            break;
                        }
                    }
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t\t\t\t\tCase Not Found!");
                    break;

                case 5:
                    System.out.println();
                    System.out.print("\t\t\t\t\t\t\t\t\t\tEnter your cnic number: ");
                    int nic = input.nextInt();
                    input.nextLine();

                    for (Complain complain : complains) {
                        if (complain.getCnic() == nic) {
                            complain.displayInfo();
                            break;
                        } else {
                            System.out.println();
                            System.out.println("\t\t\t\t\t\t\t\t\t\tNO Complain Found!!");
                        }
                    }
                    break;

                case 6:
                    System.out.println();
                    System.out.print("\t\t\t\t\t\t\t\t\t\tEnter Staff ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    for (Staff staff : staffList) {
                        if (staff.getId() == id) {
                            staff.displayInfo();
                            break;
                        } else {
                            System.out.println();
                            System.out.println("\t\t\t\t\t\t\t\t\t\tNo Staff Regsitered With " + id);
                        }
                    }
                    break;

                case 7:
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t\t\t\t=======Overall Report Of Station=======");
                    System.out.println("\t\t\t\t\t\t\t\t\t\tNumber of FIR's filed: " + Fir.nofirs);
                    System.out.println("\t\t\t\t\t\t\t\t\t\tNumber of complain's registered: " + Complain.noComplain);
                    System.out.println("\t\t\t\t\t\t\t\t\t\tNumber of staff: " + Staff.noStaff);
                    break;

                case 8:
                    a = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t\t\t\t\tSelect a valid option");
                    break;
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t-----HAVE A NICE DAY-----");
    }
}
