package lt.coseacademy.EgzaminuPrograma;

public class Teacher {

    private String name;
    private String surname;
    private String acountPassword;
    private Integer id;

    public Teacher() {
    }

    public Teacher(String name, String surname, String acountPassword, Integer id) {
        this.name = name;
        this.surname = surname;
        this.acountPassword = acountPassword;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAcountPassword() {
        return acountPassword;
    }

    public Integer getId() {
        return id;
    }
}
