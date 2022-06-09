package lt.codeacademy.servise;

import lt.codeacademy.repository.PassportRepository;

public class PassportServise {
    private final PassportRepository repository;

    public PassportServise() {
        repository = new PassportRepository();
    }

    //atspausdinam visus passport
    public void showAllPassports() {
        repository.getPassports().forEach(System.out::println);
    }
}
