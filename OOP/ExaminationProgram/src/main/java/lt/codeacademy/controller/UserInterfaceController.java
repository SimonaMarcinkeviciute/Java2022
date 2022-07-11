package lt.codeacademy.controller;

import lt.codeacademy.data.UserStatus;
import lt.codeacademy.entity.*;
import lt.codeacademy.service.ExaminationService;
import lt.codeacademy.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;

public class UserInterfaceController {

    private final Scanner scanner;
    private final ExaminationService examinationService;
    private final UserService userService;

    public UserInterfaceController() {
        scanner = new Scanner(System.in);
        examinationService = new ExaminationService();
        userService = new UserService();
    }

    private void showStudentsExamsStatistic() {
        Long allCorrectAswers = examinationService.getCorrectStudentAnswersSum();
        Long allAnswers = examinationService.getAllAnswersSum();

        System.out.println("STATISTIKA");
        System.out.printf("Visi egzaminai buvo spresti kartu: %s.\n", examinationService.getExamSum());
        System.out.printf("Is viso teisingu atsakymu skaicius: %s teisingi atsakymai is %s.\n"
                , allCorrectAswers, allAnswers);
        System.out.printf("Teisingai atsakytu klausimu vidurkis visuose klausimynuose: %s\n"
                , Math.round(examinationService.getCorrectStudentAnswersAVG()));
        System.out.printf("A varianta visuose egzaminuose pasirinko kartu: %s\n", examinationService.getFirstAnswerSum());
        System.out.printf("B varianta visuose egzaminuose pasirinko kartu: %s\n", examinationService.getSecondAnswerSum());
        System.out.printf("C varianta visuose egzaminuose pasirinko kartu: %s\n", examinationService.getThirdAnswerSum());

        System.out.println("Ar noresite perziureti atskiru egzaminu statistika? TAIP/NE");

        if (isYes()) {
            showOneExamStatistic();
        }
    }

    private void showOneExamStatistic() {
        List<Exam> exams = examinationService.getExam();
        System.out.println("Pasirinkite egzamina, kurio statistika noresite apziureti:");

        for (Exam exam : exams) {
            System.out.printf("Id: %s pavadinimas: \"%s\".\n", exam.getExamId(), exam.getName());
        }

        Exam exam = getExam(exams);

        String correctAnswerSum = examinationService.getCorrectStudentAnswersSumByExam(exam);
        String allAnswer = examinationService.getAllAnswersByExamSum(exam);
        String a = examinationService.getFirstAnswerSumByExam(exam);
        String b = examinationService.getSecondAnswerSumByExam(exam);
        String c = examinationService.getThirdAnswerSumByExam(exam);

        System.out.printf("Egzamine \"%s\" teisingu atsakymu skaicius: %s teisingi atsakymai is %s.\n"
                , exam.getName(), correctAnswerSum, allAnswer);
        System.out.printf("Egzamine \"%s\" teisingu A atsakymu skaicius: %s.\n", exam.getName(), a);
        System.out.printf("Egzamine \"%s\" teisingu B atsakymu skaicius: %s.\n", exam.getName(), b);
        System.out.printf("Egzamine \"%s\" teisingu C atsakymu skaicius: %s.\n", exam.getName(), c);
    }

    private void showStudentExamsStatistic(User user) {
        List<ExamGrade> examGrades = userService.getAllUserGrade(user);
        System.out.println("Egzaminu pazymiai: ");

        for (ExamGrade examGrade : examGrades) {
            System.out.printf("Egzaminas: %s. %s. Ivertinimas - %s.\n", examGrade.getExam().getExamId()
                    , examGrade.getExam().getName(), examGrade.getStudenteExamGrade());
        }
    }

    private void reTakeExam(User user) {
        List<Exam> passedExams = userService.getPassedExamsByUser(user).stream().toList();
        System.out.println("Pagal ID, pasirinkite egzamina kuri laikysite:");

        for (Exam exam : passedExams) {
            System.out.printf("ID %s. \"%s\".\n", exam.getExamId(), exam.getName());
        }

        Exam exam = getExam(passedExams);
        getUserExamAnswers(user, exam);
    }

    private void getUserExamAnswers(User user, Exam exam) {
        List<UserAnswer> userAnswers = userService.getUserAnswers(user, exam);
        List<ExamQuestion> examQuestions = examinationService.getExamQuestionByExam(exam);

        int counter = 1;
        System.out.println("EGZAMINAS PRASIDEJO!!");

        for (ExamQuestion examQuestion : examQuestions) {
            System.out.printf("%s. %s\n", counter++, examQuestion.getQuestion());
            System.out.printf("   %s\n", examQuestion.getFirstAnswer());
            System.out.printf("   %s\n", examQuestion.getSecondAnswer());
            System.out.printf("   %s\n", examQuestion.getThirdAnswer());

            String studentAnswer = getAnswer(examQuestion);

            for (UserAnswer userAnswer : userAnswers) {
                if (userAnswer.getExamQuestion().getQuestionId().equals(examQuestion.getQuestionId())) {
                    userAnswer.setStudentAnswer(studentAnswer);
                    userService.updateUserAnswers(userAnswer);
                }
            }
        }

        examResult(exam, user, examQuestions, "retake");
    }

    private void updateUserGrade(double grade, User user, Exam exam) {
        ExamGrade examGrade = userService.getUserGrade(user, exam);

        int number = (int) Math.round(grade);

        examGrade.setStudenteExamGrade(number);
        userService.updateUserGrade(examGrade);
    }

    private void selectTheExam(User user) {
        Set<Exam> passedExams = userService.getPassedExamsByUser(user);
        List<Exam> exams = examinationService.getExam();
        List<Exam> haveNotTakenExams = new ArrayList<>();

       if(passedExams.size() != exams.size()) {
           System.out.println("Pagal ID, pasirinkite egzamina kuri laikysite:");

           for (Exam exam : exams) {
               int counter = 0;
               for (Exam passedExam : passedExams) {
                   if (exam.getExamId().equals(passedExam.getExamId())) {
                       counter++;
                   }
               }
               if (counter == 0) {
                   System.out.printf("ID %s. %s\n", exam.getExamId(), exam.getName());
                   haveNotTakenExams.add(exam);
               }
           }
       }else {
           System.out.println("Nelaikytu egzaminu nera!");
           return;
       }

        Exam exam = getExam(haveNotTakenExams);
        List<ExamQuestion> examQuestions = examinationService.getExamQuestionByExam(exam);
        takeTheExam(examQuestions, exam, user, "take");
    }

    private void takeTheExam(List<ExamQuestion> examQuestions, Exam exam, User user, String status) {
        int counter = 1;
        System.out.println("EGZAMINAS PRASIDEJO!!");

        for (ExamQuestion examQuestion : examQuestions) {
            System.out.printf("%s. %s.\n", counter++, examQuestion.getQuestion());
            System.out.printf("   %s.\n", examQuestion.getFirstAnswer());
            System.out.printf("   %s.\n", examQuestion.getSecondAnswer());
            System.out.printf("   %s.\n", examQuestion.getThirdAnswer());

            String studentAnswer = getAnswer(examQuestion);
            UserAnswer userAnswer = new UserAnswer(studentAnswer);
            userAnswer.setUser(user);
            userAnswer.setExam(exam);
            userAnswer.setExamQuestion(examQuestion);

            userService.createUserAnswer(userAnswer);
        }

        examResult(exam, user, examQuestions, status);
    }

    private void examResult(Exam exam, User user, List<ExamQuestion> examQuestions, String status) {
        List<UserAnswer> answers = userService.getUserAnswers(user, exam);
        int counter = 0;

        for (ExamQuestion examQuestion : examQuestions) {
            for (UserAnswer answer : answers) {
                if (examQuestion.getQuestionId().equals(answer.getExamQuestion().getQuestionId())) {
                    if (examQuestion.getCorrectAnswer().equals(answer.getStudentAnswer())) {
                        counter++;
                    }
                }
            }
        }

        double grade = (10.0 / answers.size()) * counter;
        System.out.printf("Egzamino pabaiga. Tavo pazimys: %s.\n", Math.round(grade));

        if (status.equals("take")) {
            setGrade(grade, user, exam);
        }
        if (status.equals("retake")) {
            updateUserGrade(grade, user, exam);
        }
    }

    private void setGrade(double grade, User user, Exam exam) {
        ExamGrade examGrade = new ExamGrade((int) Math.round(grade));
        examGrade.setExam(exam);
        examGrade.setUser(user);

        userService.createUserGrate(examGrade);
    }

    private String getAnswer(ExamQuestion examQuestion) {
        System.out.println("Irasykite teisinga atsakyma: ");

        do {
            String letter = scanner.nextLine();

            if ("a".equals(letter)) {
                return examQuestion.getFirstAnswer();
            } else if ("b".equals(letter)) {
                return examQuestion.getSecondAnswer();
            } else if ("c".equals(letter)) {
                return examQuestion.getThirdAnswer();
            } else {
                System.out.println("Tokio pasirinkimo nera, bandykite dar karta!");
            }
        } while (true);
    }

    private void deleteQuestionFromExam(Exam exam) {
        List<ExamQuestion> examQuestions = examinationService.getExamQuestionByExam(exam);
        System.out.println("Pagal Id pasirinkite kuri egzamino klausima noreti istrinti: ");

        for (ExamQuestion question : examQuestions) {
            System.out.printf("Id: %s %s\n", question.getQuestionId(), question.getQuestion());
        }

        ExamQuestion examQuestion = selectExamQuestion(examQuestions);
        examinationService.deleteQuestion(examQuestion);
        System.out.println("Klausimas istrintas!");
    }

    private void addNewQuestionToExam(Exam exam) {
        createQuestions(exam);
        System.out.println("Egzaminas atnaujintas!");
    }

    private void modifyExamQuestion(Exam exam) {
        List<ExamQuestion> examQuestions = examinationService.getExamQuestionByExam(exam);

        if (examQuestions.size() == 0) {
            System.out.println("Egzaminas neturi klausimu, pasirinkite prideti klausima.\n");
            return;
        }

        System.out.println("Pagal ID pasirinkite kuri klausima noresite pakeisti:");

        for (ExamQuestion examQuestion : examQuestions) {
            System.out.printf("Id %s. \"%s\".\n", examQuestion.getQuestionId(), examQuestion.getQuestion());
        }

        ExamQuestion examQuestion = selectExamQuestion(examQuestions);
        printExamQuestionInfo(examQuestion);
        ExamQuestion updateExamQuestion = getModifyQuestion(examQuestion);
        updateExamQuestion.setExam(exam);
        examinationService.updateExamQuestion(updateExamQuestion);
        System.out.println("Egazamino klausimas modifikuotas!");
    }

    private void printExamQuestionInfo(ExamQuestion examQuestion) {
        System.out.printf("""
                        Jusu pasirinkto klausimo info:
                        Id: %s.
                        Pavadinimas: "%s".
                        Atsakymo variantai:
                        %s.
                        %s.
                        %s.
                        Teisingas atsakymo variantas: "%s".
                        \n""", examQuestion.getQuestionId(), examQuestion.getQuestion(), examQuestion.getFirstAnswer()
                , examQuestion.getSecondAnswer(), examQuestion.getThirdAnswer(), examQuestion.getCorrectAnswer());
    }

    private ExamQuestion getModifyQuestion(ExamQuestion examQuestion) {
        if (doYouWantModify(examQuestion.getFirstAnswer())) {
            examQuestion.setFirstAnswer("a. " + scanner.nextLine());
        }
        if (doYouWantModify(examQuestion.getSecondAnswer())) {
            examQuestion.setSecondAnswer("b. " + scanner.nextLine());
        }
        if (doYouWantModify(examQuestion.getThirdAnswer())) {
            examQuestion.setThirdAnswer("c. " + scanner.nextLine());
        }

        List<String> newAnswersAndQuestion = List.of(examQuestion.getFirstAnswer(), examQuestion.getSecondAnswer()
                , examQuestion.getThirdAnswer());
        String correctAnswer = getCorrectAnswer(newAnswersAndQuestion);
        examQuestion.setCorrectAnswer(correctAnswer);

        return examQuestion;
    }

    private boolean doYouWantModify(String answer) {
        System.out.printf("Ar noresite modifikuoti atsakymo varianta \"%s\"   TAIP/NE.\n", answer);

        if (isYes()) {
            System.out.println("Iveskite nauja atsakymo varianta:");
            return true;
        }

        return false;
    }

    private ExamQuestion selectExamQuestion(List<ExamQuestion> examQuestions) {
        ExamQuestion examQuestion;

        do {
            Long questionId = getCorrectNumber();
            examQuestion = examQuestions.stream().filter(e -> e.getQuestionId().equals(questionId)).findFirst().orElse(null);
            if (examQuestion == null) {
                System.out.println("Toks id neegzistuoja, pakartokite ivedima");
            }
        } while (examQuestion == null);

        return examQuestion;
    }

    public void startExamModification(Exam exam) {
        String action;
        do {
            showExamModificationMenu(exam);
            action = scanner.nextLine();
            selectExamModification(action, exam);
        } while (!action.equals("4"));
    }

    private void selectExamModification(String action, Exam exam) {
        switch (action) {
            case "1" -> modifyExamQuestion(exam);
            case "2" -> addNewQuestionToExam(exam);
            case "3" -> deleteQuestionFromExam(exam);
            case "4" -> System.out.println("Grizote i destotojo menu.");
            default -> System.out.println("Blogas ivedimas! Bandykite dar karta!\n");
        }
    }

    private void showExamModificationMenu(Exam exam) {
        System.out.printf("""
                Jusu pasirinktas egzaminas Id. %s "%s".
                PASIRINKITE!
                [1]. Pakeisti jau esama egzamino klausima.
                [2]. Prideti papildoma klausima egzaminui.
                [3]. Istrinti klausima is egzamino.
                [4]. Grizti i destytojo menu.
                """, exam.getExamId(), exam.getName());
    }

    private void modifyExam() {
        List<Exam> exams = examinationService.getExam();
        System.out.println("Pagal id pasirinkite kuri egzamina noresite modifikuoti: ");

        for (Exam exam : exams) {
            System.out.printf("Id: %s pavadinimas: \"%s\".\n", exam.getExamId(), exam.getName());
        }

        Exam exam = getExam(exams);
        startExamModification(exam);
    }

    private void createQuestions(Exam exam) {
        do {
            System.out.println("Ar norite prideti klausima? TAIP/NE");
            if (isYes()) {
                List<String> questionAndAnswers = createOneQuestion();
                ExamQuestion examQuestion = new ExamQuestion(questionAndAnswers.get(4), questionAndAnswers.get(0)
                        , questionAndAnswers.get(1), questionAndAnswers.get(2), questionAndAnswers.get(3));
                examQuestion.setExam(exam);
                examinationService.createExamQuestion(examQuestion);
            } else {
                return;
            }
        } while (true);
    }

    private List<String> createOneQuestion() {
        List<String> questionAndAnswers = new ArrayList<>();

        System.out.println("Iveskite klausima:");
        String question = scanner.nextLine();
        System.out.println("Iveskite pirma atsakymo varianta");
        String firstAnswer = "a. " + scanner.nextLine();
        System.out.println("Iveskite antra atsakymo varianta");
        String secondAnswer = "b. " + scanner.nextLine();
        System.out.println("Iveskite trecia atsakymo varianta");
        String thirdAnswer = "c. " + scanner.nextLine();

        questionAndAnswers.add(firstAnswer);
        questionAndAnswers.add(secondAnswer);
        questionAndAnswers.add(thirdAnswer);
        questionAndAnswers.add(getCorrectAnswer(questionAndAnswers));
        questionAndAnswers.add(question);

        return questionAndAnswers;
    }

    private String getCorrectAnswer(List<String> questionAndAnswers) {
        System.out.println("Pasirinkite teisinga atsakymo varianta:");
        for (String q : questionAndAnswers) {
            System.out.printf("%s\n", q);
        }

        do {
            String correctAnswer = scanner.nextLine();
            switch (correctAnswer.toLowerCase()) {
                case "a" -> {
                    return questionAndAnswers.get(0);
                }
                case "b" -> {
                    return questionAndAnswers.get(1);
                }
                case "c" -> {
                    return questionAndAnswers.get(2);
                }
                default -> System.out.println("Tokio pasirinkimo nera, bandykite dar karta!");
            }
        } while (true);
    }

    private boolean isYes() {
        String answer;

        do {
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("TAIP")) {
                return true;
            } else if (answer.equalsIgnoreCase("NE")) {
                return false;
            } else {
                System.out.println("Blogas ivedimas, pakartokite!");
            }
        } while (!answer.equalsIgnoreCase("TAIP") && !answer.equalsIgnoreCase("NE"));

        return false;
    }

    private Exam getExam(List<Exam> exams) {
        Exam exam;
        do {
            Long examId = getCorrectNumber();
            exam = exams.stream().filter(e -> e.getExamId().equals(examId)).findFirst().orElse(null);
            if (exam == null) {
                System.out.println("Toks id neegzistuoja, pakartokite ivedima!");
            }
        } while (exam == null);

        return exam;
    }

    private Long getCorrectNumber() {
        while (true) {
            try {
                return Long.valueOf(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Blogas ivedimas, bandykite dar karta!");
            }
        }
    }

    private void createExam() {
        System.out.println("Iveskite egzamino pavadinima: ");
        String examName = scanner.nextLine();
        Exam exam = new Exam(null, examName);
        exam = examinationService.createExamName(exam);
        createQuestions(exam);
        System.out.println("Egzaminas sukurtas! Grizote i destytojo meniu!\n");
    }

    public void startTeacherApplication() {
        String action;
        do {
            showTeacherMenu();
            action = scanner.nextLine();
            selectTeacherAction(action);
        } while (!action.equals("4"));
    }

    private void selectTeacherAction(String action) {
        switch (action) {
            case "1" -> createExam();
            case "2" -> modifyExam();
            case "3" -> showStudentsExamsStatistic();
            case "4" -> System.out.println("Grizote i pradziot menu.");
            default -> System.out.println("Blogas ivedimas! Pakartokite!");
        }
    }

    private void showTeacherMenu() {
        System.out.println("""
                PASIRINKITE:
                [1]. Sukurti egzamina.
                [2]. Redaguoti egzamina.
                [3]. Perziureti egzaminu statistika.
                [4]. Grizti i pradzios menu.
                """);
    }

    private void startStudentApplication(User user) {
        String action;
        do {
            showStudentMenu();
            action = scanner.nextLine();
            selectStudentAction(action, user);
        } while (!action.equals("4"));
    }

    private void selectStudentAction(String action, User user) {
        switch (action) {
            case "1" -> selectTheExam(user);
            case "2" -> reTakeExam(user);
            case "3" -> showStudentExamsStatistic(user);
            case "4" -> System.out.println("Grizote i pradzios menu.");
            default -> System.out.println("Blogas ivedimas!");
        }
    }

    private void showStudentMenu() {
        System.out.println("""
                PASIRINKITE:
                [1]. Laikyti egzamina.
                [2]. Perlaikyti egzamina.
                [3]. Perziureti egzaminu statistika.
                [4]. Grizti i pradios menu.
                """);
    }

    private boolean isUserExist(User user) {
        boolean isUserExist = false;

        if (user != null) {
            if (user.getUserStatus() == UserStatus.STUDENTAS) {
                isUserExist = true;
                System.out.println("Sveikinu prisijungus!\n");
                startStudentApplication(user);
            }
            if (user.getUserStatus() == UserStatus.DESTYTOJAS) {
                isUserExist = true;
                System.out.println("Sveikinu prisijungus!\n");
                startTeacherApplication();
            }
        }

        return isUserExist;
    }

    private void logIn() {
        System.out.println("Iveskite pavarde prisijungimui:");
        String surname = scanner.nextLine();
        System.out.println("Iveskite slaptazodi:");
        String password = scanner.nextLine();
        String sifruotas = DigestUtils.sha512Hex(password);
        User user = userService.getUserBySurnamePassword(surname, sifruotas);

        if (!isUserExist(user)) {
            System.out.println("Blogas prisijungimo vardas arba slaptazodis! Bandykite dar karta!");
            logIn();
        }
    }

    private void registration() {
        UserStatus status = null;

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

        while (status == null) {
            status = getUserStatus();
        }

        User user = new User(null, name, surname, DigestUtils.sha512Hex(password), status);
        userService.createUser(user);
        System.out.println("Registracija baigta");
    }

    private UserStatus getUserStatus() {
        System.out.println("""
                Pasirinkite vartotojo statusa: 
                [1] Destytojas.
                [2] Studentas.
                """);

        String status = scanner.nextLine();

        if (status.equals("1")) {
            return UserStatus.DESTYTOJAS;
        } else if (status.equals("2")) {
            return UserStatus.STUDENTAS;
        } else {
            System.out.println("Neteisinga ivestis, bandykite dar karta");
        }

        return null;
    }

    private boolean isRepeatPasswordCorrect(Scanner scanner, String password) {
        for (int i = 0; i < 5; i++) {
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

    public void startApplication() {
        String action;
        do {
            showMenu();
            action = scanner.nextLine();
            selectAction(action);
        } while (!action.equals("3"));
    }

    private void showMenu() {
        System.out.println("""
                PASIRINKITE!
                [1]. Registracija.
                [2]. Prisijungimas.
                [3]. Iseiti is programos.
                """);
    }

    private void selectAction(String action) {
        switch (action) {
            case "1" -> registration();
            case "2" -> logIn();
            case "3" -> System.out.println("Programa uzdaryta");
            default -> System.out.println("Blogas ivedimas!");
        }
    }
}
