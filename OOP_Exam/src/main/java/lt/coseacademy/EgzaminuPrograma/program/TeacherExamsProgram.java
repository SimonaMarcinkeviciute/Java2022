package lt.coseacademy.EgzaminuPrograma.program;

import lt.coseacademy.EgzaminuPrograma.Exam;
import lt.coseacademy.EgzaminuPrograma.ExamTypes;
import lt.coseacademy.EgzaminuPrograma.Teacher;

import java.util.*;

public class TeacherExamsProgram extends UniversityExamsProgram {

    private final Teacher teacher = new Teacher("Destytojas", "Destytojas", "a", 1);

    private String[] answers;
    private final Map<String, String[]> questionsAndAnswers = new HashMap<>();
    private final Map<String, String> questionsAndCorrectAnswers = new HashMap<>();

    public void checkStudentsAverageOfGrades() {
        int vidurkis = 0;

        for (Integer i : students.keySet()) {
            if (students.get(i).getTheAverageOfGrade() == null) {
                System.out.printf("Studento vardas ir pavarde: %s %s, egzaminu nelaike.\n", students.get(i).getName()
                        , students.get(i).getSurname());
            } else {
                System.out.printf("Studento vardas ir pavarde: %s %s, pazimiu vidurkis: %s.\n", students.get(i).getName()
                        , students.get(i).getSurname(), students.get(i).getTheAverageOfGrade());
            }
        }
    }

    public void addMoreQuestionsToExam(Scanner scanner) {
        System.out.println("Pasirinkite, pagal id, kuri egzamina redaguosite");
        for (Integer k : exams.keySet()) {
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
            System.out.println("Naujo egzamino kurimas nutrauktas");
            return;
        }

        if (!exams.containsKey(key)) {
            System.out.println("Toks egzamino id neegzistuoja, klausimu pridejimas i egzamina nutraukiamas");
            return;
        }

        System.out.println("Iveskite kiek klausimu noresite papildyti egzamina");
        int questionQuantity = 0;
        try {
            questionQuantity = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Bloga ivestis, klausimu pridejimas i egzamina nutraukiamas");
        }
        scanner.nextLine();

        if (questionQuantity == 0) {
            System.out.println("Bloga ivestis, klausimu pridejimas i egzamina nutraukiamas");
            return;
        }

        String questionName;
        int answersQuantity;

        for (int i = 0; i < questionQuantity; i++) {
            System.out.println("Iveskite klausima");
            questionName = exams.get(key).getQuestionsAndAnswers().size() + 1 + ". " + scanner.nextLine();

            System.out.println("Kiek klausimas tures atsakymo variantu");
            try {
                answersQuantity = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Bloga ivestis!, klausimu pridejimas nutraukiamas");
                scanner.nextLine();
                return;
            }

            if (answersQuantity == 0) {
                System.out.println("Sugrizote i ankstesni menu, egzamino kurimas nutraukiamas");
                scanner.nextLine();
                return;
            }

            answers = new String[answersQuantity];
            scanner.nextLine();

            for (int j = 0; j < answersQuantity; j++) {
                System.out.println("Iveskite atsakyma");
                answers[j] = j + 1 + ". " + scanner.nextLine();
            }

            exams.get(key).getQuestionsAndAnswers().put(questionName, answers);

            System.out.println("Nustatykite teisinga atsakyma");
            for (String a : answers) {
                System.out.println(a);
            }

            String b = scanner.nextLine();
            for (String a : answers) {
                if (a.startsWith(b)) {
                    exams.get(key).getQuestionsAndCorrectAnswers().put(questionName, a);
                }
            }
        }

        System.out.println("");

        if (questionsAndAnswers.size() != questionsAndCorrectAnswers.size()) {
            System.out.println("Tokio atsakymo nera, egzamino kurimas nutraukiamas");
            return;
        }

        System.out.println("Egzaminas sukurtas");


    }

    @Override
    public Integer getId() {
        if (exams == null) {
            return 1;
        }

        return exams.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
    }

    public ExamTypes getExamType(Scanner scanner) {
        String examType;
        ExamTypes types = null;

        do {
            System.out.printf("Pasirinkite koks bus jusu egzamino tipas: [1] %s, [2] %s, [3] %s\n",
                    ExamTypes.TEST.getName(), ExamTypes.OPEN_QUESTIONS.getName(), ExamTypes.MIXED_TEST.getName());
            examType = scanner.nextLine();

            switch (examType) {
                case "1" -> types = ExamTypes.TEST;
                case "2" -> types = ExamTypes.OPEN_QUESTIONS;
                case "3" -> types = ExamTypes.MIXED_TEST;
                default -> System.out.println("Blogas ivedimas, tokio pasirinkimo nera, pakartokit");
            }
        } while (!examType.equals("3") && !examType.equals("2") && !examType.equals("1"));

        return types;
    }

    public void createNewExam(Scanner scanner) {
        System.out.println("Iveskite egzamino pavadinima:");
        String examName = scanner.nextLine();
        ExamTypes types = getExamType(scanner);
        int questionQuantity = 0;

        System.out.println("Iveskite kiek egzaminas tures klausimu:");
        try {
            questionQuantity = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Bloga ivestis");
        }
        scanner.nextLine();

        if (questionQuantity == 0) {
            System.out.println("Naujo egzamino kurimas nutrauktas");
            return;
        }

        String questionName;
        int answersQuantity;

        for (int i = 0; i < questionQuantity; i++) {
            System.out.println("Iveskite klausima");
            questionName = i + 1 + ". " + scanner.nextLine();

            System.out.println("Kiek klausimas tures atsakymo variantu");
            try {
                answersQuantity = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Bloga ivestis!, Egzamino kurimas nutraukimas");
                scanner.nextLine();
                return;
            }

            if (answersQuantity == 0) {
                System.out.println("Sugrizote i ankstesni menu, egzamino kurimas nutraukiamas");
                scanner.nextLine();
                return;
            }

            answers = new String[answersQuantity];
            scanner.nextLine();

            for (int j = 0; j < answersQuantity; j++) {
                System.out.println("Iveskite atsakyma");
                answers[j] = j + 1 + ". " + scanner.nextLine();
            }

            questionsAndAnswers.put(questionName, answers);
            System.out.println("Nustatykite teisinga atsakyma");
            for (String a : answers) {
                System.out.println(a);
            }

            String b = scanner.nextLine();
            for (String a : answers) {
                if (a.startsWith(b)) {
                    questionsAndCorrectAnswers.put(questionName, a);
                }
            }
        }

        System.out.println("");

        if (questionsAndAnswers.size() != questionsAndCorrectAnswers.size()) {
            System.out.println("Tokio atsakymo nera, egzamino kurimas nutraukiamas");
            return;
        }

        exams.put(getId(), new Exam(examName, types, questionsAndAnswers, questionsAndCorrectAnswers));
        System.out.println("Egzaminas sukurtas");

    }

    public boolean isPasswordCorrect(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Iveskite slaptazodi:");

        for (int i = 0; i < MAX_RETRY; i++) {
            if (!teacher.getAcountPassword().equals(scanner.nextLine())) {
                System.out.println("Neteisingas slaptazodis, bandykite dar karta:");
            } else {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isIdCorrect(Scanner scanner) {

        for (int i = 0; i < MAX_RETRY; i++) {
            try {
                System.out.println("Iveskite prisijungimo id:");
                if (!teacher.getId().equals(scanner.nextInt())) {
                    System.out.println("Toks vartotojas neegzistuoja!");
                    continue;
                }
                return true;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Bloga ivestis!");
            }
        }
        scanner.nextLine();

        return false;
    }

    public void teacherActions(Scanner scanner) {
        String action;

        do {
            main.teachersMenu();
            action = scanner.nextLine();

            switch (action) {
                case "1" -> createNewExam(scanner);
                case "2" -> addMoreQuestionsToExam(scanner);
                case "3" -> checkStudentsAverageOfGrades();
                case "4" -> System.out.println("Grizote i pradzios MENU");
                default -> System.out.println("Neteisingas ivedimas, bandykite dar karta:");
            }
        } while (!action.equals("4"));
    }

    @Override
    public void login(Scanner scanner) {

        if (!isIdCorrect(scanner)) {
            System.out.println("Prisijungimas nesekmingas, grizote i pradzios menu");
            return;
        }

        if (!isPasswordCorrect(scanner)) {
            System.out.println("Prisijungimas nesekmingas, grizote i pradzios menu");
            return;
        }

        System.out.printf("Sveikiname  prisijungus %s %s\n", teacher.getName(), teacher.getSurname());
        teacherActions(scanner);
    }
}
