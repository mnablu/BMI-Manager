/**
 * Patient = represents the details of a individual patient.
 * Created by Marc Nablu on 16/03/15.
 */
public class Patient {
    private String name;
    private int age;
    private double height, weight;

    public Patient(String name, int age, double height, double weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;

    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double getBMI (){
        return weight/Math.pow(height, 2);
    }

    public void add(Patient patient) {

    }
}



