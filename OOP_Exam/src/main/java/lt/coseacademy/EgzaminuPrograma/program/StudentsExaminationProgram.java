package lt.coseacademy.EgzaminuPrograma.program;

import lt.coseacademy.EgzaminuPrograma.Exam;
import lt.coseacademy.EgzaminuPrograma.ExamStatus;
import lt.coseacademy.EgzaminuPrograma.Student;
import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StudentsExaminationProgram extends UniversityExamsProgram {

    public void setAverageOfGrade(Student student) {
        int vidurkis = 0;
        for (Integer a : student.getPassedExams().keySet()) {
            vidurkis += Integer.parseInt(student.getPassedExams().get(a).getGrade());
        }

        vidurkis = vidurkis / student.getPassedExams().size();
        student.setTheAverageOfGrade(vidurkis + "");
    }

    public void averageOfGrades(Student student) {
        for (Integer a : student.getPassedExams().keySet()) {
            System.out.printf("Egzamino pavadinimas: %s. %s pazimys: %s.\n", a, student.getPassedExams().get(a).getExamName()
                    , student.getPassedExams().get(a).getGrade());
        }

        System.out.println("Bendras pazymiu vidurkis " + student.getTheAverageOfGrade());
    }

    public boolean checkRetakeExamTime(Student student, Integer id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(student.getPassedExams().get(id).getDateOfTheExamination(), formatter);
        LocalDateTime kadaGales = date.plusHours(48);

        if (LocalDateTime.now().isBefore(kadaGales)) {
            System.out.println("Ezamina galesite perlaikyti:" + kadaGales.format(formatter));
            return false;

        }
        return true;

    }

    public void retakeExam(Student student, Scanner scanner) {
        System.out.println("Jusu neislaikyti egzaminai");
        Map<Integer, Exam> failedExams = new HashMap<>();

        for (Integer id : student.getPassedExams().keySet()) {
            if (student.getPassedExams().get(id).getExamStatus().equals(ExamStatus.FALED)) {
                System.out.println(id + ". " + student.getPassedExams().get(id).getExamName());
                failedExams.put(id, student.getPassedExams().get(id));
            }
        }

        System.out.println("Pagal id pasirinkite egzamina kuri noresite perlaikyti");
        Integer id = null;
        try{
            id = scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("Bloga ivestis!");
        }
        scanner.nextLine();

        if (id == null) {
            System.out.println("Pasirinkti perlaikyti egzamino nepavyko!");
            return;
        }

        if(!failedExams.containsKey(id)) {
            System.out.println("Tokiu id egzamino nera.");
            return;
        }

        if (checkRetakeExamTime(student, id)) {
            takeAnExam(student, id, scanner);
        }

        setAverageOfGrade(student);
    }

    public Integer getExamGrade(Integer key, Student student) {
        int counter = 0;

        for (String[] a : student.getPassedExams().get(key).getStudentAnswers()) {
            String klausimas = a[0];
            String atsakymas = a[1];
            if (exams.get(key).getQuestionsAndCorrectAnswers().get(klausimas).equals(atsakymas)) {
                counter++;
            }
        }

        double kazkas = 10 / (double) exams.get(key).getQuestionsAndCorrectAnswers().size();
        double grade = kazkas * counter;

        return (int) Math.round(grade);
    }


    public void studentsActions(Scanner scanner, Student student) {
        String action;

        do {
            main.studentsMenu();
            action = scanner.nextLine();

            switch (action) {
                case "1" -> chooseAnExam(scanner, student);
                case "2" -> retakeExam(student, scanner);
                case "3" -> averageOfGrades(student);
                case "4" -> System.out.println("Grizote i pradzios MENU");
                default -> System.out.println("Neteisingas ivedimas, bandykite dar karta:");
            }
        } while (!action.equals("4"));
    }

    public void takeAnExam(Student student, Integer key, Scanner scanner) {
        System.out.println("Egzaminam prasidejo. SEKMES!");
        List<String[]> studentAnswers = new ArrayList<>();

        for (String q : exams.get(key).getQuestionsAndAnswers().keySet()) {
            System.out.println("--------------------");
            System.out.println(q);
            System.out.println("Pasirinkite atsakyma");
            for (int i = 0; i < exams.get(key).getQuestionsAndAnswers().get(q).length; i++) {
                System.out.println("   " + exams.get(key).getQuestionsAndAnswers().get(q)[i]);
            }
            int numb = 0;
            try {
                numb = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Neteisinga ivestis");
            }
            scanner.nextLine();

            if (numb == 0) {
                System.out.println("Tokio atsakymo varianto nera, isejote is egzamino");
                return;
            }

            System.out.println(exams.get(key).getQuestionsAndAnswers().get(q).length);

            if (numb > exams.get(key).getQuestionsAndAnswers().get(q).length) {
                System.out.println("Tokio atsakymo varianto nera, isejote is egzamino numb");
                return;
            }

            studentAnswers.add(new String[]{q, exams.get(key).getQuestionsAndAnswers().get(q)[numb - 1]});
        }

        System.out.println("Egzamino pabaiga");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
        String data = LocalDateTime.now().format(formatter);
        System.out.println(data);

        Map<Integer, Exam> studentPassedExams = new HashMap<>();
        Integer grade = null;
        studentPassedExams.put(key, new Exam(exams.get(key).getExamName(), exams.get(key).getType(), new ArrayList<>(studentAnswers), ExamStatus.WAITING, grade + "", data));
        student.setPassedExams(studentPassedExams);

        grade = getExamGrade(key, student);

        if (grade < 5) {
            student.getPassedExams().get(key).setGrade(grade + "");
            student.getPassedExams().get(key).setExamStatus(ExamStatus.FALED);
        } else {
            student.getPassedExams().get(key).setGrade(grade + "");
            student.getPassedExams().get(key).setExamStatus(ExamStatus.PASSED);
        }

        student.setPassedExams(studentPassedExams);
        System.out.println("Egzamino atsakymai irasyti");
        setAverageOfGrade(student);
    }

    public void chooseAnExam(Scanner scanner, Student student) {
        System.out.println("Pagal id pasirinkite kuri egzamina noresite laikyti");
        Map<Integer, Exam> a = new HashMap<>();

        for (Integer k : exams.keySet()) {
            if (student.getPassedExams() != null) {
                if (student.getPassedExams().containsKey(k)) {
                    continue;
                }
            }
            a.put(k, exams.get(k));
            System.out.println(k + ". " + exams.get(k).getExamName());
        }
        Integer key = null;

        try {
            key = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Bloga ivestis");
        }
        scanner.nextLine();

        if (key == null) {
            System.out.println("Grizome i menu");
            return;
        }

        if (!a.containsKey(key)) {
            System.out.println("Egzamino su tokiu id nera, gryzome i menu!");
            return;
        }

        takeAnExam(student, key, scanner);
    }

    private Integer getCorrectId(Scanner scanner, Map<Integer, Student> students) {
        Integer id = null;

        for (int i = 0; i < MAX_RETRY; i++) {
            try {
                System.out.println("Iveskite prisijungimo id:");
                id = scanner.nextInt();
                if (!students.containsKey(id)) {
                    System.out.println("Toks vartotojas neegzistuoja");
                    continue;
                }
                return id;
            } catch (InputMismatchException e) {
                System.out.println("Bloga ivestis");
            }
            scanner.nextLine();
        }
        return id;
    }

    @Override
    public void login(Scanner scanner) {
        Integer id = getCorrectId(scanner, students);
        Student student = students.get(id);

        if (id == null) {
            System.out.println("Prisijungimas nesekmingas");
            return;
        }
        scanner.nextLine();

        System.out.println("Iveskite slaptazodi:");
        String password = scanner.nextLine();

        if (!student.getAccountPassword().equals(DigestUtils.sha512Hex(password))) {
            System.out.println("Neteisingas slaptazodis");
            return;
        }

        System.out.printf("Sveikiname  prisijungus %s %s\n", student.getName(), student.getSurname());
        studentsActions(scanner, student);
    }

    @Override
    public void Registration(Scanner scanner) {

        System.out.println("Iveskite savo varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite savo pavarde");
        String surname = scanner.nextLine();
        System.out.println("Iveskite slaptazodi");
        String password = scanner.nextLine();

        if (!isRepeatPasswordCorrect(scanner, password)) {
            System.out.println("Userio sukurti nepavyko");
            return;
        }

        Integer id = getId();
        students.put(id, new Student(name, surname, DigestUtils.sha512Hex(password)));
        System.out.printf("Registracija sekminga. Jusu prisijungimo id-%s\n", id);
    }

    private boolean isRepeatPasswordCorrect(Scanner scanner, String password) {
        for (int i = 0; i < UniversityExamsProgram.MAX_RETRY; i++) {
            System.out.println("Pakartokite slaptazodzio ivedima:");
            String repeatPassword = scanner.nextLine();

            if (!repeatPassword.equals(password)) {
                System.out.println("Slaptazodziai nesutampa");
                continue;
            }

            return true;
        }

        return false;
    }

    @Override
    public Integer getId() {
        if (students == null) {
            return 1;
        }

        return students.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
    }
}
