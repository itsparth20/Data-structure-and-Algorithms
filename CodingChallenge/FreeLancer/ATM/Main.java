import java.io.*;
import java.util.*;

public class Main {
    private static List<String> users = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static String pathname = "./";
    private static String stockFile = "stocks.txt";
    private static String tryAgain = "Please try again.\n";
    private static String bye = "bye";

    public static void main(String[] args) throws IOException {
        //print welcome message
        welcome();
        Scanner sc = new Scanner(System.in);
        //get user id
        String user = getUserId();
        //print choice and get user choice
        int choice = getUserChoice();
        //perform action based on choice
        while (choice != 5) {
            if (choice == 4) {
                boolean result = wannaContinue();
                if (!result) {
                    System.out.println(bye);
                    return;
                }
            }
            performAction(choice, user);
            choice = getUserChoice();
        }

    }
    //if user will press 4 then this method will execute
    private static boolean wannaContinue() throws IOException {

        String fileName = pathname + stockFile;
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = file.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("Do they want to return to the main menu?");
        sc.nextLine();
        String input = sc.nextLine();
        return input.equalsIgnoreCase("N") ? false : true;

    }
    //to perform rest of the choice
    private static void performAction(int choice, String user) throws IOException {
        if (choice == 1) {
            checkCurrentAccountBalance(user);
        } else if (choice == 2) {
            withdrawMoneyFromTheirAccount(user);
        } else if (choice == 3) {
            changePassword(user);
        }
        else if(choice == 6){
            printBankDetails();
        }

    }
    //print bank details
    private static void printBankDetails() throws IOException {
        Map<String, Integer> map = new HashMap<>();
        double total = 0.0;
        for(int i = 0; i < users.size(); i++){
            String fileName = pathname + users.get(i);
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = file.readLine()) != null) {
                double bal = Double.valueOf(line);
                total += bal;
                map.putIfAbsent("small", 0);
                map.putIfAbsent("medium", 0);
                map.putIfAbsent("large", 0);
                map.putIfAbsent("extralarge", 0);
                if(bal <= 100) {
                    map.merge("small", 1, Integer::sum);
                }else if(bal <= 200) {
                    map.merge("medium", 1, Integer::sum);
                }
                else if(bal <= 300) {
                    map.merge("large", 1, Integer::sum);
                }else{
                    map.merge("extralarge", 1, Integer::sum);
                }
                break;
            }
        }
        System.out.println("Bank has total: " + total + " Euro");
        System.out.println("Small: " + map.get("small"));
        System.out.println("Medium: " + map.get("medium"));
        System.out.println("Large: " + map.get("large"));
        System.out.println("Extra Large: " + map.get("extralarge"));


    }
    //change password
    private static void changePassword(String user) throws IOException {
        String fileName = pathname + user;
        String line;
        while (true) {
            System.out.println("Enter new password: ");
            int password = sc.nextInt();
            System.out.println("Enter password again: ");
            int varify = sc.nextInt();
            if (password != varify) {
                System.out.println(tryAgain);
                continue;
            } else {
                BufferedReader file = new BufferedReader(new FileReader(fileName));
                StringBuffer sb = new StringBuffer();
                int x = 0;
                while ((line = file.readLine()) != null) {
                    if (x == 0) {
                        x++;
                        sb.append(line);
                        sb.append('\n');
                        continue;
                    }
                    sb.append(password);
                    sb.append('\n');
                    break;
                }
                String inputStr = sb.toString();
                file.close();
                FileOutputStream fileOut = new FileOutputStream(fileName);
                fileOut.write(inputStr.getBytes());
                fileOut.close();
                System.out.println("Done");
                return;
            }

        }
    }

    //withdraw Money method
    private static void withdrawMoneyFromTheirAccount(String user) throws IOException {
        String fileName = pathname + user;
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line;
        double bal = 0.00;
        while ((line = br.readLine()) != null) {
            bal = Double.valueOf(line);
            break;
        }
        while (true) {
            System.out.println("How much do you wanna withdraw?");
            double withdrawAmount = sc.nextDouble();
            if (withdrawAmount > bal) {
                System.out.println(tryAgain);
            } else {
                BufferedReader file = new BufferedReader(new FileReader(fileName));
                StringBuffer sb = new StringBuffer();
                int x = 0;
                while ((line = file.readLine()) != null) {
                    if (x == 0) {
                        x++;
                        sb.append(String.valueOf(bal - withdrawAmount));
                        sb.append('\n');
                        continue;
                    }
                    sb.append(line);
                    sb.append('\n');
                }
                String inputStr = sb.toString();
                file.close();
                FileOutputStream fileOut = new FileOutputStream(fileName);
                fileOut.write(inputStr.getBytes());
                fileOut.close();
                System.out.println("Done");
                return;
            }
        }
    }

    //check current balance
    private static void checkCurrentAccountBalance(String user) throws IOException {
        String fileName = pathname + user;
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String bal = "Your balance is: ";
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(bal + line);
            break;
        }
    }

    //getUser choice
    private static int getUserChoice() {
        printMenu();
        int choice;
        while (true) {
            choice = sc.nextInt();
            if (choice > 0 && choice <= 6) return choice;
            System.out.println(tryAgain);
            printMenu();
        }
    }

    //print menu
    private static void printMenu() {
        String choice1 = "\n1.\tCheck the current account balance";
        String choice2 = "2.\tWithdraw money from account";
        String choice3 = "3.\tChange current password";
        String choice4 = "4.\tCheck the latest stock prices for the bank";
        String choice5 = "5.\tLogout of the system";
        String choice6 = "6.\tBank Summary.\n";
        System.out.println(choice1);
        System.out.println(choice2);
        System.out.println(choice3);
        System.out.println(choice4);
        System.out.println(choice5);
        System.out.println(choice6);
    }

    private static void welcome() {
        String welcome = "Welcomed to the bank’s ATM machine.\n";
        System.out.println(welcome);
    }

    //get user id
    private static String getUserId() throws IOException {
        String Id = "";
        String acc = "Enter your account ID: ";
        String password = "Enter four-digit password: ";
        File folder = new File(pathname);
        File[] listOfFiles = folder.listFiles((dir, filename) -> filename.endsWith(".txt"));
        while (true) {
            System.out.println(acc);
            String accountNumber = sc.nextLine();
            System.out.println(password);
            String accountPassword = sc.nextLine();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    String file = listOfFiles[i].getName();
                    String[] fileName = file.split("\\.");
                    if(!file.equalsIgnoreCase("stocks.txt"))
                        users.add(file);
                }
            }
            accountNumber += ".txt";
            if (users.contains(accountNumber)) {
                String name = pathname + accountNumber;
                FileReader fr = new FileReader(name);
                BufferedReader br = new BufferedReader(fr);
                String line;
                boolean match = false;
                int x = 0;
                while ((line = br.readLine()) != null) {
                    if (x == 0) {
                        x++;
                        continue;
                    }
                    if (line.equalsIgnoreCase(accountPassword))
                        match = true;
                    break;
                }

                if (match) {
                    Id = accountNumber;
                    break;
                }
            } else {
                users.clear();

            }
            System.out.println(tryAgain);
        }

        return Id;
    }
}
