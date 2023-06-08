import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int choice = 0;
        
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("3. Option 3");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Option 1 selected.");
                    break;
                case 2:
                    System.out.println("Option 2 selected.");
                    break;
                case 3:
                    System.out.println("Option 3 selected.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 4);
        
        scanner.close();
    }
}
