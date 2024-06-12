import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Iterator<Fir> iterator = firs.iterator();
        while (iterator.hasNext()) {
            Fir fir = iterator.next();
            if (fir.getCaseno() == caseid) {
                iterator.remove();
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\t-----Case Removed Successfully----");
                return;
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\tCase Not Found! OR Invalid Entry");
    }

    public void addComplain(Complain complain){
        complains.add(complain);
    }

    public void updateComplain(String id) {
        boolean found = false;
        for (Complain complain : complains) {
            if (complain.getCnic().equals(id)) {
                complain.setSolved();
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\t----Status Updated-----");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t\tNo Complain Registered On " + id);
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

    private boolean validateCNIC(String cnic) {
        String regex = "^[0-9]{5}-[0-9]{7}-[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cnic);
        return matcher.find();
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

            try {
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        handleFir(input);
                        break;
                    case 2:
                        handleComplain(input);
                        break;
                    case 3:
                        handleStaff(input);
                        break;
                    case 4:
                        viewFir(input);
                        break;
                    case 5:
                        viewComplain(input);
                        break;
                    case 6:
                        viewStaff(input);
                        break;
                    case 7:
                        viewReport();
                        break;
                    case 8:
                        a = false;
                        break;
                    default:
                        System.out.println();
                        System.out.println("\t\t\t\t\t\t\t\t\t\tSelect a valid option");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\tInvalid input. Please enter a number.");
                input.nextLine(); // clear the invalid input from the scanner
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t-----HAVE A NICE DAY-----");
    }

    private void handleFir(Scanner input) {
        boolean b = true;
        while (b) {
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t1] Register FIR\t\t2] Delete FIR\t\t3] Go Back");
            System.out.println();
            System.out.print("\t\t\t\t\t\t\t\t\t\t\tSelect an option: ");
            try {
                int select = input.nextInt();
                input.nextLine();
                switch (select) {
                    case 1:
                        registerFir(input);
                        break;
                    case 2:
                        deleteFir(input);
                        break;
                    case 3:
                        b = false;
                        break;
                    default:
                        System.out.println();
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\tInvalid Entry!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\tInvalid input. Please enter a number.");
                input.nextLine();
            }
        }
    }

    private void registerFir(Scanner input) {
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t=============FIR=============");
        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter victim name: ");
        String name = input.nextLine();

        String cnic;
        while (true) {
            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter victim CNIC no (xxxxx-xxxxxxx-x): ");
            cnic = input.nextLine();
            if (validateCNIC(cnic)) {
                break;
            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\tInvalid CNIC format. Please try again.");
            }
        }

        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter incident date: ");
        String date = input.nextLine();
        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter time of incident: ");
        String time = input.nextLine();
        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter location of incident: ");
        String location = input.nextLine();
        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter incident description: ");
        String description = input.nextLine();

        Fir newfir = new Fir(name, cnic, date, time, location, description);
        addFir(newfir);
        newfir.displayInfo();
        System.out.println("\t\t\t\t\t\t\t\t---------FIR Registered Successfully---------");
    }

    private void deleteFir(Scanner input) {
        System.out.println();
        System.out.print("\t\t\t\t\t\t\t\t\t\t\tEnter case ID : ");
        try {
            int caseno = input.nextInt();
            delFir(caseno);
        } catch (InputMismatchException e) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\tInvalid input. Please enter a number.");
            input.nextLine();
        }
    }

    private void handleComplain(Scanner input) {
        boolean c = true;
        while (c) {
            System.out.println();
            System.out.println("\t\t\t\t\t1] Register Complain\t\t2] Update Complain Status\t\t3] Go Back");
            System.out.println();
            System.out.print("\t\t\t\t\t\t\t\t\t\tSelect an option: ");
            try {
                int select2 = input.nextInt();
                input.nextLine();
                switch (select2) {
                    case 1:
                        registerComplain(input);
                        break;
                    case 2:
                        updateComplainStatus(input);
                        break;
                    case 3:
                        c = false;
                        break;
                    default:
                        System.out.println();
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\tInvalid Entry!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\tInvalid input. Please enter a number.");
                input.nextLine();
            }
        }
    }

    private void registerComplain(Scanner input) {
        System.out.println("\t\t\t\t\t\t\t\t\t===========Complain==========");
        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter complainee name: ");
        String name2 = input.nextLine();

        String cnic2;
        while (true) {
            System.out.print("\t\t\t\t\t\t\t\t\t\tEnter complainee CNIC (xxxxx-xxxxxxx-x): ");
            cnic2 = input.nextLine();
            if (validateCNIC(cnic2)) {
                break;
            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\tInvalid CNIC format. Please try again.");
            }
        }

        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter your complain: ");
        String description2 = input.nextLine();

        Complain newcomplain = new Complain(name2, cnic2, description2);
        addComplain(newcomplain);
        newcomplain.displayInfo();
        System.out.println("\t\t\t\t\t\t\t-----Complain Registered Successfully-----");
    }

    private void updateComplainStatus(Scanner input) {
        System.out.println();
        System.out.print("\t\t\t\t\t\t\t\t\tEnter your CNIC number (xxxxx-xxxxxxx-x): ");
        String nic;
        while (true) {
            nic = input.nextLine();
            if (validateCNIC(nic)) {
                break;
            } else {
                System.out.println("\t\t\t\t\t\t\t\t\t\tInvalid CNIC format. Please try again.");
            }
        }
        updateComplain(nic);
    }

    private void handleStaff(Scanner input) {
        boolean d = true;
        while (d) {
            System.out.println();
            System.out.println("\t\t\t\t\t\t1] Add Staff\t\t2] Remove Staff\t\t\t3] Go Back");
            System.out.println();
            System.out.print("\t\t\t\t\t\t\t\t\t\tSelect an option: ");
            try {
                int select3 = input.nextInt();
                input.nextLine();
                switch (select3) {
                    case 1:
                        addStaffDetails(input);
                        break;
                    case 2:
                        removeStaff(input);
                        break;
                    case 3:
                        d = false;
                        break;
                    default:
                        System.out.println();
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\tInvalid Entry!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\tInvalid input. Please enter a number.");
                input.nextLine();
            }
        }
    }

    private void addStaffDetails(Scanner input) {
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t\t=======Staff Details=======");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\tName: ");
        String name3 = input.nextLine();
        System.out.print("\t\t\t\t\t\t\t\t\t\t\tGender: ");
        String gender = input.nextLine();
        System.out.print("\t\t\t\t\t\t\t\t\t\t\tRole: ");
        String role = input.nextLine();

        Staff newstaff = new Staff(name3, gender, role);
        addStaff(newstaff);
        newstaff.displayInfo();
        System.out.println("\t\t\t\t\t\t\t\t\t-----Staff Added Successfully-----");
    }

    private void removeStaff(Scanner input) {
        System.out.println();
        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter staff ID: ");
        try {
            int id = input.nextInt();
            input.nextLine();
            delStaff(id);
        } catch (InputMismatchException e) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\tInvalid input. Please enter a number.");
            input.nextLine();
        }
    }

    private void viewFir(Scanner input) {
        System.out.println();
        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter caseid: ");
        try {
            int caseid = input.nextInt();
            input.nextLine();
            boolean found = false;
            for (Fir fir : firs) {
                if (fir.getCaseno() == caseid) {
                    fir.displayInfo();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\tCase Not Found!");
            }
        } catch (InputMismatchException e) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\tInvalid input. Please enter a number.");
            input.nextLine();
        }
    }

    private void viewComplain(Scanner input) {
        System.out.println();
        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter your CNIC number: ");
        String nic = input.nextLine();

        boolean found = false;
        for (Complain complain : complains) {
            if (complain.getCnic().equals(nic)) {
                complain.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t\t\t\tNO Complain Found!!");
        }
    }

    private void viewStaff(Scanner input) {
        System.out.println();
        System.out.print("\t\t\t\t\t\t\t\t\t\tEnter Staff ID: ");
        try {
            int id = input.nextInt();
            input.nextLine();
            boolean found = false;
            for (Staff staff : staffList) {
                if (staff.getId() == id) {
                    staff.displayInfo();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\tNo Staff Regsitered With " + id);
            }
        } catch (InputMismatchException e) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\tInvalid input. Please enter a number.");
            input.nextLine();
        }
    }

    private void viewReport() {
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t=======Overall Report Of Station=======");
        System.out.println("\t\t\t\t\t\t\t\t\t\tNumber of FIR's filed: " + Fir.nofirs);
        System.out.println("\t\t\t\t\t\t\t\t\t\tNumber of complain's registered: " + Complain.noComplain);
        System.out.println("\t\t\t\t\t\t\t\t\t\tNumber of staff: " + Staff.noStaff);
    }
}
