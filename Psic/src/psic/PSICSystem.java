
package psic;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Main Class which contains the main menu of ths System. 
public class PSICSystem {
public static int id=1;// Generate the ID for different Vistors or Patients
    public static int flagme = 0,flagme1=0;
    public static ArrayList<Patient> p = new ArrayList<>();//Store the patients
    public static    ArrayList<Visitors> v = new ArrayList<>();//Store the visitors
    public static String appointment = "";
    public static String consultant = "";
    private String rooms[] = {"A", "B", "C", "pool", "gym"};//All rooms where patients would be treated
    private static String appointmentStatus[] = {"Attended", "Booked", "Cancel"};//Sleect option
    private static String [] notes = {"Healthy","Need to be check","Need another visit","Make an appointment"};

    public PSICSystem() {
                p.add(new Patient("Patient: Jerry|Phusician Expert: Physiotherapy |Treatment: Neural mobilisation |Scheduled At: Thursday May 2021,10:00-12:00 |Suite: pool |Status: Booked"));
         p.add(new Patient("Patient: ali|Phusician Expert: Physiotherapy |Treatment: Neural mobilisation |Scheduled At: Thursday May 2021,10:00-12:00 |Suite: pool |Status: Booked"));
          p.add(new Patient("Patient: Jerry|Phusician Expert: Physiotherapy |Treatment: Neural mobilisation |Scheduled At: Thursday May 2021,10:00-12:00 |Suite: pool |Status: Booked"));
         p.add(new Patient("Patient: ali|Phusician Expert: Physiotherapy |Treatment: Neural mobilisation |Scheduled At: Thursday May 2021,10:00-12:00 |Suite: pool |Status: Booked"));
		id = p.size();
    }

    public String[] getappointmentStatus() {
        return this.appointmentStatus;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
       
        int falgp = 0;
        while (true) {
            appointment = "";
            consultant="";
            //Main Menuu
            System.out.println("\nWelcome to the Physiotherapy & Sports Injury Centre !\nPlease select option: \n1) Booking\n2) Exit\n3) Show Appointment Report\n4) Show Visitor Report\n5) Change Appointment");

            Scanner sc = new Scanner(System.in);
            char c = sc.next().charAt(0);
            switch (c) {
                case '1':
                    System.out.println("\nWelcome in Appointment booking Manual!");
                    System.out.println("Are you ?\n1)Patient\n2)Visitor");
                    char cc = sc.next().charAt(0);
                    switch (cc) {
                        //Patient and Visitor details
                        case '1':
                            System.out.println("Please Enter your name: ");
                            String namepatient = sc.next();
                            appointment += "Patient: " + namepatient;
                            printTharapists();
                            if (flagme == 0) {
                                appointment += " |Status: Booked";
                            }
                            p.add(new Patient(appointment));
                            id+=1;
                            break;
                            //Patient and Visitor details
                        case '2':
                            System.out.println("Please Enter your name: ");
                            String namevisitor = sc.next();
                            consultant += "Visitor: " + namevisitor;
                            printVisitors();
                            if (flagme1 == 0) {
                                consultant += " |Note: " + PSICSystem.notes[rand.nextInt(4)];
                            }
                            v.add(new Visitors(consultant));
                            break;
                        default:
                            System.out.println("invalid selection: Thanks for Visiting by!");
                            break;
                    }
                    break;
//Appointment Case
                case '2':
                    System.out.println("Thanks for Visiting by!");
                    falgp = 1;
                    break;
                case '3':
                    System.out.println("Currently Schedule appointments Report!\n");
                    if (p.isEmpty()) {
                        System.out.println("There is not appointment Scehdule Now!");
                    } else {
                        int cunt = 1;
                        for (int i = 0; i < p.size(); i++) {
                            System.out.println(cunt + " --> " + p.get(i).toString());
                            cunt += 1;
                        }
                    }
                    break;
                 case '4':
                    System.out.println("Currently Visitor Report!\n");
                    if (v.isEmpty()) {
                        System.out.println("There is no Visitor Now!");
                    } else {
                        int cunt = 1;
                        for (int i = 0; i < v.size(); i++) {
                            System.out.println(cunt + " --> " + v.get(i).toString());
                            cunt += 1;
                        }
                    }
                    break;
                 case '5':
                    updateAppointment();
                    break;
                default:
                    System.out.println("Invalid Option selected! please try again!");
                    break;
            }
            if (falgp == 1) {
                break;
            }
        }
    }
    public static void updateAppointment(){
        if(!p.isEmpty()){
            Scanner sc = new Scanner(System.in);
        
        System.out.println("Select to update the Appointment!");
        int cunt=1;
            for (int i = 0; i < p.size(); i++) {
                System.out.println(cunt + ")  " + p.get(i).toString());
                            cunt+=1;           
            }
                char cc = sc.next().charAt(0);
                int opt = Character.getNumericValue(cc); 
                
                Patient pat = p.get(opt-1);
                if(opt<=p.size() && opt>0){
                    System.out.println("Select the Status for the Appointment\n\n1) Cancel\n2) Booked\n3) Attended");
                    cc = sc.next().charAt(0);
                    switch(cc){
                        case '1':Patient pat1 = pat.StatusChange(pat, "Cancel");
                                p.set(opt-1, pat1);System.out.println("Successfyllu Updated!");break; 
                            
                        case '2': pat1 = pat.StatusChange(pat, "Booked");
                                p.set(opt-1, pat1);System.out.println("Successfyllu Updated!");break;
                        case '3': pat1 = pat.StatusChange(pat, "Attended");
                                p.set(opt-1, pat1);System.out.println("Successfyllu Updated!");break;
                        default:System.out.println("Invalid option selected!"); break;
                    }
                }
                

        }else{
            System.out.println("Currentlt no appointments!");
        }
    }
    public static void printTharapists() {
        physician phy = new physician();
        Member mm = new Member();
        String[] exp = phy.getExperties();
        String[] names = mm.getName();
           System.out.println("Select the way to look Up!\n1) Expertise\n2) Name\n3) Cancel");
            Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        int flag = 0;
        switch (c) {
            case '1':
                System.out.println("Select Expert in:");
                for (int i = 0; i < 3; i++) {
                    System.out.println(i + 1 + " --> " + exp[i]);
                }
                System.out.println("4 --> Cancel");
                char cc = sc.next().charAt(0);
                switch (cc) {
                    case '1':
                        appointment+="|Phusician Expert: "+exp[0];printTreatmets1(0, 2);
                        break;
                    case '2':
                        appointment+="|Phusician Expert: "+exp[1];printTreatmets1(0, 3);
                        break;
                    case '3':
                        appointment+="|Phusician Expert: "+exp[2];printTreatmets1(2,4);
                        break;
                    case '4':
                        System.out.println("You Cancel the Visit!");flagme = 1;
                        flag = 1;
                        break;
                    default:
                        System.out.println("Invalid Option Selected!");
                        flagme = 1;
                        flag = 1;
                        break;
                }
                break;
            case '2':
                 System.out.println("Select physician name:");
                for (int i = 0; i < names.length; i++) {
                    System.out.println(i + 1 + " --> " + names[i]);
                }
                System.out.println("6 --> Cancel");
                
                char ccc = sc.next().charAt(0);
                switch (ccc) {
                    case '1':
                        appointment+="|physician: "+names[0];
                        printTreatmets1(0, 2);
                        break;
                    case '2':
                        appointment+="|physician: "+names[1];
                        printTreatmets2(0, 3);
                        break;
                    case '3':
                        appointment+="|physician: "+names[2];
                        printTreatmets2(2, 4);
                        break;
                    case '4':
                        appointment+="|physician: "+names[3];
                        printTreatmets2(0, 3);
                        break;
                    case '5':
                        appointment+="|physician: "+names[4];
                        printTreatmets2(0, 2);
                        break;
                    case '6':
                        System.out.println("You Cancel the Visit!");flagme = 1;
                        flag = 1;
                        break;
                    default:
                        System.out.println("Invalid Option Selected!");
                        flagme = 1;
                        flag = 1;
                        break;
                }
                break;
            case '3':
                System.out.println("You cancel the Appointment!");
                flagme = 1;
                flag = 1;
                break;
            default:
                System.out.println("Invalid option Selected!");
                flagme = 1;
                flag = 1;
                break;
        }
       /* if(flag!=1){
        System.out.println("Here is the available Physicians!\n\nPlease Select you Choice:\n");
        Member m = new Member();
        physician p = new physician();
        String[] type = p.getExperties();
        String[] idd = m.getId();
        String[] name = m.getName();

        for (int i = 0; i < idd.length; i++) {
            System.out.println(idd[i] + " --> " + name[i] + " Expert in " + type[i]);
        }
        System.out.println((idd.length + 1) + " Cancel");
        Scanner sc = new Scanner(System.in);
        char g = sc.next().charAt(0);
        switch (g) {
            case '1':
                appointment += "|ID: " + id + " |Physiotherapy: " + name[0] + " |Expert in: " + type[0];
                printTreatmets1(0, 2);
                break;
            case '2':
                appointment += "|ID: " + id + " |Physiotherapy: " + name[1] + " |Expert in: " + type[1];
                printTreatmets2(0, 3);
                break;
            case '3':
                appointment += "|ID: " + id + " |Physiotherapy: " + name[2] + " |Expert in: " + type[2];
                printTreatmets3(2, 4);
                break;
            case '4':
                appointment += "|ID: " + id + " |Physiotherapy: " + name[3] + " |Expert in: " + type[3];
                printTreatmets2(0, 3);
                break;
            case '5':
                appointment += "|ID: " + id + " |Physiotherapy: " + name[4] + " |Expert in: " + type[4];
                printTreatmets1(0, 2);
                break;
            case '6':
                System.out.println("You cancel the Appointment!");
                flagme = 1;
                break;
            default:
                System.out.println("Invalid Option Selected!");
                flagme = 1;
                break;
        }
        }*/
    }
//Shoow Treatment
    public static void printTreatmets1(int val1, int val2) {
        Random rand = new Random();
        System.out.println("Please Select Any Treatment Services:\n");
        physician p = new physician();
        String[] treat = p.getTreatment();

        for (int i = val1; i <= val2; i++) {
            System.out.println((i + 1) + " --> " + treat[i]);
        }
        System.out.println((val2 + 2) + " --> Cancel");
        Scanner sc = new Scanner(System.in);
        char g = sc.next().charAt(0);
        int flag = 0;
        switch (g) {
            case '1':
                appointment += " |Treatment: " + treat[0];
                break;
            case '2':
                appointment += " |Treatment: " + treat[1];
                ;
                break;
            case '3':
                appointment += " |Treatment: " + treat[2];
                ;
                break;
            case '4':
                System.out.println("You cancel the Appointment!");
                flagme = 1;
                flag = 1;
                break;

            default:
                System.out.println("Invalid Option Selected!");
                flag = 1;
                flagme = 1;
                break;
        }
        if (flag != 1) {
            Date_TIme dm = new Date_TIme();
            int countl = 1;
            int r1 = rand.nextInt(6);
            int r2 = rand.nextInt(6);
            String[] date_time = dm.getDateTime();
            System.out.println("\n Please select the Schedule:");

            System.out.println(countl + " " + date_time[r1]);
            countl += 1;
            System.out.println(countl + " " + date_time[r2]);
            countl += 1;

            System.out.println(countl + " Cancel");
            g = sc.next().charAt(0);
            switch (g) {
                case '1':
                    appointment += " |Scheduled At: " + date_time[r1];
                    break;
                case '2':
                    appointment += " |Scheduled At: " + date_time[r2];
                    ;
                    break;

                case '3':
                    System.out.println("You cancel the Appointment!");
                    flagme = 1;
                    flag = 2;
                    break;
                default:
                    System.out.println("Invalid Option Selected!");
                    flagme = 1;
                    flag = 2;
                    break;
            }
            if(flag!=1 && flag!=2){
            System.out.println("\nPlease select the Suite:\n");

            PSICSystem ps = new PSICSystem();
            for (int i = 0; i < ps.rooms.length; i++) {
                System.out.println((i + 1) + " Suite: " + ps.rooms[i]);
            }
            System.out.println(ps.rooms.length + 1 + " Cacel");

            g = sc.next().charAt(0);
            switch (g) {
                case '1':
                    appointment += " |Suite: " + ps.rooms[0];
                    break;
                case '2':
                    appointment += " |Suite: " + ps.rooms[1];
                    ;
                    break;
                case '3':
                    appointment += " |Suite: " + ps.rooms[2];
                    ;
                    break;
                case '4':
                    appointment += " |Suite: " + ps.rooms[3];
                    break;
                case '5':
                    appointment += " |Suite: " + ps.rooms[4];
                    ;
                    break;
                case '6':
                    System.out.println("You cancel the Appointment!");
                    flagme = 1;
                    flag = 3;
                    break;
                default:
                    System.out.println("Invalid Option Selected!");
                    flagme = 1;
                    flag = 3;
                    break;
            }

            if (flag != 3) {
                System.out.println("\nYour Appointment is Confirmed!\nYour details are:\n[ " + appointment + " ]");
            }
        }
        }
    }

    public static void printTreatmets2(int val1, int val2) {
        System.out.println("Please Select Any Treatment Services:\n");
        physician p = new physician();
        int count = 1;
        String[] treat = p.getTreatment();
        for (int i = val1; i <= val2; i++) {
            System.out.println(count + " --> " + treat[i]);
            count += 1;
        }

        System.out.println(count + " --> Cancel");
        Scanner sc = new Scanner(System.in);
        char g = sc.next().charAt(0);
        int flag = 0;
        switch (g) {
            case '1':
                appointment += " |Treatment: " + treat[0];
                break;
            case '2':
                appointment += " |Treatment: " + treat[1];
                break;
            case '3':
                appointment += " |Treatment: " + treat[2];
                break;
            case '4':
                appointment += " |Treatment: " + treat[3];
                break;
            case '5':
                System.out.println("You cancel the Appointment!");
                flagme = 1;
                flag = 1;
                break;

            default:
                System.out.println("Invalid Option Selected!");
                flag = 1;
                flagme = 1;
                break;
        }
        if (flag != 1) {
            Date_TIme dm = new Date_TIme();
            Random rand = new Random();
            int countl = 1;
            int r1 = rand.nextInt(6);
            int r2 = rand.nextInt(6);
            String[] date_time = dm.getDateTime();
            System.out.println("\n Please select the Schedule:");

            System.out.println(countl + " " + date_time[r1]);
            countl += 1;
            System.out.println(countl + " " + date_time[r2]);
            countl += 1;

            System.out.println(countl + " Cancel");
            g = sc.next().charAt(0);
            switch (g) {
                case '1':
                    appointment += " |Scheduled: " + date_time[r1];
                    break;
                case '2':
                    appointment += " |Scheduled: " + date_time[r2];
                    ;
                    break;

                case '3':
                    System.out.println("You cancel the Appointment!");
                    flagme = 1;
                    flag = 2;
                    break;
                default:
                    System.out.println("Invalid Option Selected!");
                    flagme = 1;
                    flag = 2;
                    break;
            }
            System.out.println("\nPlease select the Suite:\n");
            PSICSystem ps = new PSICSystem();
            for (int i = 0; i < ps.rooms.length; i++) {
                System.out.println((i + 1) + " Suite: " + ps.rooms[i]);
            }
            System.out.println(ps.rooms.length + 1 + " Cacel");

            g = sc.next().charAt(0);
            switch (g) {
                case '1':
                    appointment += " |Suite: " + ps.rooms[0];
                    break;
                case '2':
                    appointment += " |Suite: " + ps.rooms[1];
                    ;
                    break;
                case '3':
                    appointment += " |Suite: " + ps.rooms[2];
                    ;
                    break;
                case '4':
                    appointment += " |Suite: " + ps.rooms[3];
                    break;
                case '5':
                    appointment += " |Suite: " + ps.rooms[4];
                    ;
                    break;
                case '6':
                    System.out.println("You cancel the Appointment!");
                    flagme = 1;
                    flag = 2;
                    break;
                default:
                    System.out.println("Invalid Option Selected!");
                    flagme = 1;
                    flag = 2;
                    break;
            }

            if (flag != 2) {
                System.out.println("\nYour Appointment is Confirmed!\nYour details are:\n[ " + appointment + " ]");
            }
        }
    }
//Third Treatment
    public static void printTreatmets3(int val1, int val2) {
        System.out.println("Please Select Any Treatment Services:\n");
        physician p = new physician();
        int count = 1;
        String[] treat = p.getTreatment();
        for (int i = val1; i <= val2; i++) {

            System.out.println(count + " --> " + treat[i]);
            count += 1;
        }

        System.out.println(count + " --> Cancel");
        Scanner sc = new Scanner(System.in);
        char g = sc.next().charAt(0);
        int flag = 0;
        switch (g) {
            case '1':
                appointment += " |Treatment: " + treat[2];
                break;
            case '2':
                appointment += " |Treatment: " + treat[3];
                break;
            case '3':
                appointment += " |Treatment: " + treat[4];
                break;
            case '4':
                System.out.println("You cancel the Appointment!");
                flagme = 1;
                flag = 1;
                break;

            default:
                System.out.println("Invalid Option Selected!");
                flag = 1;
                flagme = 1;
                break;
        }
        if (flag != 1) {
            Date_TIme dm = new Date_TIme();
            Random rand = new Random();
            int countl = 1;
            int r1 = rand.nextInt(6);
            int r2 = rand.nextInt(6);
            String[] date_time = dm.getDateTime();
            System.out.println("\n Please select the Schedule:");

            System.out.println(countl + " " + date_time[r1]);
            countl += 1;
            System.out.println(countl + " " + date_time[r2]);
            countl += 1;

            System.out.println(countl + " Cancel");
            g = sc.next().charAt(0);
            switch (g) {
                case '1':
                    appointment += " |Scheduled At: " + date_time[r1];
                    break;
                case '2':
                    appointment += " |Scheduled At: " + date_time[r2];
                    ;
                    break;

                case '3':
                    System.out.println("You cancel the Appointment!");
                    flagme = 1;
                    flag = 2;
                    break;
                default:
                    System.out.println("Invalid Option Selected!");
                    flagme = 1;
                    flag = 2;
                    break;
            }

            System.out.println("\nPlease select the Suite:\n");
            PSICSystem ps = new PSICSystem();
            for (int i = 0; i < ps.rooms.length; i++) {
                System.out.println((i + 1) + " Suite: " + ps.rooms[i]);
            }
            System.out.println(ps.rooms.length + 1 + " Cacel");

            g = sc.next().charAt(0);
            switch (g) {
                case '1':
                    appointment += " |Suite: " + ps.rooms[0];
                    break;
                case '2':
                    appointment += " |Suite: " + ps.rooms[1];
                    ;
                    break;
                case '3':
                    appointment += " |Suite: " + ps.rooms[2];
                    ;
                    break;
                case '4':
                    appointment += " |Suite: " + ps.rooms[3];
                    break;
                case '5':
                    appointment += " |Suite: " + ps.rooms[4];
                    ;
                    break;
                case '6':
                    System.out.println("You cancel the Appointment!");
                    flagme = 1;
                    flag = 2;
                    break;
                default:
                    System.out.println("Invalid Option Selected!");
                    flagme = 1;
                    flag = 2;
                    break;
            }

            if (flag != 2) {
                System.out.println("\nYour Appointment is Confirmed!\nYour details are:\n[ " + appointment + " ]");
            }
        }
    }
//Print Visitors for all visitor
    public static void printVisitors() {
        Random rand = new Random();
        Date_TIme dt = new Date_TIme();
        String [] visthour =dt.getVisitHours();
        String [] slot = dt.getSlots();
        physician phy = new physician();
        Member mm = new Member();
        String[] exp = phy.getExperties();
        String[] names = mm.getName();

        System.out.println("Select To look up by:\n1) Expertise\n2) Name\n3) Cancel");
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        int flag = 0;
        switch (c) {
            case '1':
                System.out.println("Select Expert in:");
                for (int i = 0; i < 3; i++) {
                    System.out.println(i + 1 + " --> " + exp[i]);
                }
                System.out.println("4 --> Cancel");
                char cc = sc.next().charAt(0);
                switch (cc) {
                    case '1':
                        consultant+="|Expert in: "+exp[0];
                        break;
                    case '2':
                        consultant+="|Expert in: "+exp[1];
                        break;
                    case '3':
                        consultant+="|Expert in: "+exp[2];
                        break;
                    case '4':
                        System.out.println("You Cancel the Visit!");flagme = 1;
                        flag = 1;
                        break;
                    default:
                        System.out.println("Invalid Option Selected!");
                        flagme = 1;
                        flag = 1;
                        break;
                }
                break;
            case '2':
                 System.out.println("Select physician name:");
                for (int i = 0; i < names.length; i++) {
                    System.out.println(i + 1 + " --> " + names[i]);
                }
                System.out.println("6 --> Cancel");
                
                char ccc = sc.next().charAt(0);
                switch (ccc) {
                    case '1':
                        consultant+="|physician: "+names[0];
                        break;
                    case '2':
                        consultant+="|physician: "+names[1];
                        break;
                    case '3':
                        consultant+="|physician: "+names[2];
                        break;
                    case '4':
                        consultant+="|physician: "+names[3];
                        break;
                    case '5':
                        consultant+="|physician: "+names[4];
                        break;
                    case '6':
                        System.out.println("You Cancel the Visit!");flagme = 1;
                        flag = 1;
                        break;
                    default:
                        System.out.println("Invalid Option Selected!");
                        flagme = 1;
                        flag = 1;
                        break;
                }
                break;
            case '3':
                System.out.println("You cancel the Appointment!");
                flagme = 1;
                flag = 1;
                break;
            default:
                System.out.println("Invalid option Selected!");
                flagme = 1;
                flag = 1;
                break;
        }
        if (flag != 1) {
            System.out.println("Select A Schedule:");
            for (int i = 0; i < visthour.length; i++) {
                System.out.println((i+1)+" --> "+visthour[i]);
                
            }
            System.out.println("5 --> Cancel");
            char cc = sc.next().charAt(0);
                switch (cc) {
                    case '1':
                        consultant+="|Schedule At: "+visthour[0];
                        break;
                    case '2':
                        consultant+="|Schedule At: "+visthour[1];
                        break;
                    case '3':
                        consultant+="|Schedule At: "+visthour[2];
                        break;
                    case '4':
                        consultant+="|Schedule At: "+visthour[3];
                        break;
                    case '5':
                        System.out.println("You Cancel the Visit!");flagme = 1;
                        flag = 2;
                        break;
                    default:
                        System.out.println("Invalid Option Selected!");
                        flagme = 1;
                        flag = 2;
                        break;
                }
                if(flag!=1 && flag!=2){
                    System.out.println("Select A Slot:");
            for (int i = 0; i < slot.length; i++) {
                System.out.println((i+1)+" --> "+slot[i]);
                
            }
            System.out.println("5 --> Cancel");
            char ccc = sc.next().charAt(0);
                switch (ccc) {
                    case '1':
                        consultant+="|Slot: "+slot[0];
                        break;
                    case '2':
                        consultant+="|Slot: "+slot[1];
                        break;
                    case '3':
                        consultant+="|Slot: "+slot[2];
                        break;
                    case '4':
                        consultant+="|Slot: "+slot[3];
                        break;
                    case '5':
                        System.out.println("You Cancel the Visit!");flagme = 1;
                        flag = 3;
                        break;
                    default:
                        System.out.println("Invalid Option Selected!");
                        flagme = 1;
                        flag = 3;
                        break;
                }
                }
        }
        if(flag!=2 && flag!=1 && flag!=3){
            System.out.println("\nYour Visit is Confirmed!\nYour details are:\n[ " + consultant + " ]");
        }
    }
}
