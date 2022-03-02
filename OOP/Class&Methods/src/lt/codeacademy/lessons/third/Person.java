package lt.codeacademy.lessons.third;

public class Person {

    String name;
    int age;

    //galima is konstruktoriaus iskviesti kita onstuktoriu
    // geroji praktika, kad maziau parametru turintis konstruktorius kviestu daugiau turinti
    public Person(String name){
        this(name,0);
    }

    // konstruktorius, nustatyti reiksmes objektui is karto, tiems objektasms
    //kurie atsinesa su savimi ir saugo info.

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void printValues(){
        System.out.printf("name: %s, age: %s\n", name, age);
    }
}
