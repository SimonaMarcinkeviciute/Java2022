package lt.codeacademy.lessons.thirthyFirst.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {
    public static void main(String[] args) {
        try(ObjectInputStream ob = new ObjectInputStream(new FileInputStream("objectOutput.txt"))) {
            Person person = (Person) ob.readObject();
            System.out.println(person);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
