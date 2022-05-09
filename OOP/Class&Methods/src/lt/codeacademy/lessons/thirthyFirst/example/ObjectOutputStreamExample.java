package lt.codeacademy.lessons.thirthyFirst.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
    public static void main(String[] args) {

        Person person = new Person("Andrius", 55);


        try(ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("objectOutput.txt"))) {
            ob.writeObject(person);
            ob.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// niuansai irasys hash'uota kalba, objektas turi implementuoti sereliazible
