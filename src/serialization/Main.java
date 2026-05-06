package serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("name1", 1);
        Student s2 = new Student("name2", 2);

        FileOutputStream fout = new FileOutputStream("src/serialization/a.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(s1);
        out.writeObject(s2);

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("src/serialization/a.txt"));

        Student s11 = (Student) oin.readObject();
        Student s22 = (Student) oin.readObject();

        System.out.println(s11.toString());
        System.out.println(s22.toString());
        oin.close();
        out.close();


    }

}
