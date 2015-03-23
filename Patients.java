/**
 * Patients - records several patients
 * Created by Marc Nablu on 23/03/15.
 */
public class Patients {
    Patient[] records;
    int current;

    public Patients(int maxSize){
        records = new Patient[maxSize];
    }
    public int count(){
        return current;
    }
    public void add(Patient patient){
        records[current++]= patient;
    }

    public Patient get(int i) {
        return records[i];
    }

    public boolean isEmpty(){
        return(current ==0);
    }
    public boolean isFull(){
        return (current ==records.length);
    }
}
