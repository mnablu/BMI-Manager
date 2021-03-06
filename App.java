import java.util.Scanner;

/**
 * App - Main class for BMI manager
 * Created by Marc Nablu on 16/03/15.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("BMI Manager");

        Patients patients = new Patients();

        running:
        while (true) {
            System.out.println("Please select from the " + "following menu options:\n" +
                    "\t1. Add new patient\n" +
                    "\t2. View patients\n" +
                    "\t3. Update patient\n" +
                    "\t4. Remove patient\n" +
                    "\t5. Exit\n");

            System.out.print("Enter choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    patients.add(createPatient(scanner));
                    break;
                }
                case 2: {
                    if (patients.isEmpty())
                        System.out.println("Database is Empty, please add a patient");
                    viewPatients(patients);
                    break;

                }
                case 3: {
                    updatePatient(patients, scanner);
                    break;
                }
                case 4: {
                    removePatientsWithName(patients, scanner);

                }
                case 5: {
                        System.out.println("Good bye! ");
                        break running;
                }
            }
        }
    }

    private static void viewPatients(Patients patients) {
        for (int i = 0; i < patients.count(); ++i) {
            Patient patient = patients.get(i);
            String message = String.format("Name: %s Age: %d BMI: %.2f",
                    patient.getName(), patient.getAge(), patient.getBMI());
            System.out.println(message);
        }
    }
    private static Patient createPatient(Scanner scanner){

        System.out.print("Enter patient's name: "); String name = scanner.nextLine();

        System.out.print("Enter patient's age: "); int age = scanner.nextInt();

        System.out.print("Enter patients weight (kg): "); double weight = scanner.nextDouble();

        System.out.print("Enter height (m): "); double height = scanner.nextDouble();

        return new Patient(name, age, height, weight);

    }
    private static void updatePatient(Patients patients, Scanner scanner){
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        Patient patient = patients.getPatientsWithName(name);
        if (patient!= null){
                System.out.print("Enter new Age: ");
                int age = scanner.nextInt();
                System.out.print("Enter new height: ");
                double height = scanner.nextDouble();
                System.out.print("Enter new weight: ");
                double weight = scanner.nextDouble();

                patient.setAge(age);
                patient.setHeight(height);
                patient.setWeight(weight);
        }
        else {System.out.println("No patient exists with name \"" + name + "\"");
        }

    }
    private static void removePatientsWithName(Patients patients, Scanner scanner){
        System.out.println("Enter patients name: ");
        String name = scanner.nextLine();
        patients.removePatientsWithName(name);
    }
}
