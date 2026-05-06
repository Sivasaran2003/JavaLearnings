package serialization;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString(){
        return name + " " + rollNo;
    }
}
