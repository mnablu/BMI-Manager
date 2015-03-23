import java.util.Scanner;

/**
 * App - Main class for BMI manager
 * Created by Marc Nablu on 16/03/15.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("BMI Manager");

        Patient patient = new Patient();

        running:
        while (true) {
            System.out.println("Please select from the " + "following menu options:\n" +
                    "\t1. Add new patient\n" +
                    "\t2. View patient\n" +
                    "\t3. Exit\n");

            System.out.println("Enter choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    addPatient(patient, scanner);
                    break;
                }
                case 2: {
                    viewPatient(patient);
                    break;

                }
                case 3: {
                    System.out.println("Good bye! ");
                    break running;
                }

            }
        }
    }private static void viewPatient(Patient patient) {
        String message = String.format("Name: %s Age: %d BMI: %.2f",
                patient.getName(), patient.getAge(), patient.getBMI());
        System.out.println(message);

    }
    private static void addPatient(Patient patient, Scanner scanner){

        System.out.println("Enter patient's name: ");
        String name = scanner.nextLine();
        patient.setName(name);

        System.out.println("Enter patient's age: ");
        int age = scanner.nextInt();
        patient.setAge(age);

        System.out.println("Enter patients weight (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height (m): ");
        double height = scanner.nextDouble();

        patient.setDetails(height, weight);

    }
}