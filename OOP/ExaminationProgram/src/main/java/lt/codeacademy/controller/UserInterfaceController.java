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
        List<ExamGrade> examGrades = examinationService.getExamGrade();
        List<User> students = examinationService.getStudents();

        System.out.printf("Visi egzaminai buvo spresti: %s.\n", examGrades.size());

        List<Long> examGrade = examinationService.getExamGradeSum();
       for (Long examGrade1 : examGrade) {
           System.out.println(examGrade1);
       }


    }

    private void showStudentExamsStatistic(User user) {
        List<ExamGrade> examGrades = userService.getAllUserGrade(user);

        System.out.println("Egzaminu pazymiai: ");

        for(ExamGrade examGrade : examGrades) {
            System.out.printf("Egzaminas: %s. %s. Ivertinimas - %s", examGrade.getExam().getExamId()
                    , examGrade.getExam().getName(), examGrade.getStudenteExamGrade());
        }

    }

    public void reTakeExam(User user) {
        List<Exam> passedExams = userService.getPassedExamsByUser(user).stream().toList();

        System.out.println("Pagal ID, pasirinkite egzamina kuri laikysite");

        for (Exam exam : passedExams) {
            System.out.printf("ID %s. %s\n", exam.getExamId(), exam.getName());
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
            System.out.printf("   1. %s\n", examQuestion.getFirstAnswer());
            System.out.printf("   2. %s\n", examQuestion.getSecondAnswer());
            System.out.printf("   3. %s\n", examQuestion.getThirdAnswer());

            String studentAnswer = getAnswer(examQuestion);
            System.out.println("gavau atsakyma");

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
        //sutvarkuti kad nebutu listas
        List<ExamGrade> examGrades = userService.getUserGrade(user, exam);

        int number = (int) Math.round(grade);

        for (ExamGrade examGrade : examGrades) {
            examGrade.setStudenteExamGrade(number);
            userService.updateUserGrade(examGrade);
        }

    }


    public void selectTheExam(User user) {
        Set<Exam> passedExams = userService.getPassedExamsByUser(user);
        List<Exam> exams = examinationService.getExam();
        List<Exam> haveNotTakenExams = new ArrayList<>();

        System.out.println("Pagal ID, pasirinkite egzamina kuri laikysite");

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

        Exam exam = getExam(haveNotTakenExams);
        List<ExamQuestion> examQuestions = examinationService.getExamQuestionByExam(exam);
        takeTheExam(examQuestions, exam, user, "take");
    }


    private void takeTheExam(List<ExamQuestion> examQuestions, Exam exam, User user, String status) {
        int counter = 1;
        System.out.println("EGZAMINAS PRASIDEJO!!");

        for (ExamQuestion examQuestion : examQuestions) {
            System.out.printf("%s. %s\n", counter++, examQuestion.getQuestion());
            System.out.printf("   1. %s\n", examQuestion.getFirstAnswer());
            System.out.printf("   2. %s\n", examQuestion.getSecondAnswer());
            System.out.printf("   3. %s\n", examQuestion.getThirdAnswer());

            String studentAnswer = getAnswer(examQuestion);
            System.out.println("gavau atsakyma");
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
        System.out.printf("Tavo pazimys %s\n", Math.round(grade));
        if(status.equals("take")) {
            setGrade(grade, user, exam);
        }
        if(status.equals("retake")) {
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
            String number = scanner.nextLine();

            if ("1".equals(number)) {
                return examQuestion.getFirstAnswer();
            } else if ("2".equals(number)) {
                return examQuestion.getSecondAnswer();
            } else if ("3".equals(number)) {
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
    }

    private void addNewQuestionToExam(Exam exam) {
        createQuestions(exam);
    }

    private void modifyExamQuestion(Exam exam) {

        List<ExamQuestion> examQuestions = examinationService.getExamQuestionByExam(exam);

        System.out.println("Pagal ID pasirinkite kuri klausima noresite pakeisti:");

        for (ExamQuestion examQuestion : examQuestions) {
            System.out.printf("%s.%s\n", examQuestion.getQuestionId(), examQuestion.getQuestion());
        }

        ExamQuestion examQuestion = selectExamQuestion(examQuestions);

        System.out.printf("""
                        Jusu pasirinkto klausimo Id: %s
                        Klausimas: "%s"
                        Pirmas atsakymo variantas: "%s"
                        Antras atsakymo variantas: "%s"
                        Trecias atsakymo variantas: "%s"
                        Teisingas atsakymo variantas: "%s"
                        """, examQuestion.getQuestionId(), examQuestion.getQuestion(), examQuestion.getFirstAnswer()
                , examQuestion.getSecondAnswer(), examQuestion.getThirdAnswer(), examQuestion.getCorrectAnswer());

        ExamQuestion updateExamQuestion = getModifyQuestion(examQuestion);
        updateExamQuestion.setExam(exam);

        examinationService.updateExamQuestion(updateExamQuestion);

    }

    private ExamQuestion getModifyQuestion(ExamQuestion examQuestion) {
        ExamQuestion updateExamQuestion = new ExamQuestion();

        List<String> answers = new ArrayList<>();
        answers.add(examQuestion.getFirstAnswer());
        answers.add(examQuestion.getSecondAnswer());
        answers.add(examQuestion.getThirdAnswer());

        List<String> newAnswersAndQuestion = new ArrayList<>();
        newAnswersAndQuestion.add(examQuestion.getQuestion());


        for (String answer : answers) {
            System.out.printf("Ar noresite modifikuoti atsakymo varianta \"%s\" TAIP/NE\n", answer);

            if (doYouWantCreateQuestion()) {
                System.out.println("Iveskite nauja atsakymo varianta");
                newAnswersAndQuestion.add(scanner.nextLine());
            } else {
                newAnswersAndQuestion.add(answer);
            }
        }

        System.out.println("Pasirinkite teisinga atsakymo varianta: ");
        String correctAnswer = getCorrectAnswer(newAnswersAndQuestion);

        updateExamQuestion.setQuestionId(examQuestion.getQuestionId());
        updateExamQuestion.setQuestion(examQuestion.getQuestion());
        updateExamQuestion.setFirstAnswer(newAnswersAndQuestion.get(1));
        updateExamQuestion.setSecondAnswer(newAnswersAndQuestion.get(2));
        updateExamQuestion.setThirdAnswer(newAnswersAndQuestion.get(3));
        updateExamQuestion.setCorrectAnswer(correctAnswer);

        return updateExamQuestion;

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
            showExamModificationMenu();
            action = scanner.nextLine();
            selectExamModification(action, exam);
        } while (!action.equals("4"));
    }

    private void selectExamModification(String action, Exam exam) {
        switch (action) {
            case "1" -> modifyExamQuestion(exam);
            case "2" -> addNewQuestionToExam(exam);
            case "3" -> deleteQuestionFromExam(exam);
            case "4" -> System.out.println("Programa uzdaryta");
            default -> System.out.println("Blogas ivedimas");
        }
    }

    private void showExamModificationMenu() {
        System.out.println("""
                [1]. Pakeisti jau esama egzamino klausima
                [2]. Prideti papildoma klausima egzaminui
                [3]. Istrinti klausima is egzamino
                [4]. Grizti i pradzios menu
                """);
    }

    private void modifyExam() {
        List<Exam> exams = getExams();
        System.out.println("Pagal id pasirinkite kuri egzamina noresite modifikuoti");

        for (Exam exam : exams) {
            System.out.printf("Id: %s pavadinimas: %s\n", exam.getExamId(), exam.getName());
        }

        Exam exam = getExam(exams);
        startExamModification(exam);
    }

    private void createQuestions(Exam exam) {

        do {
            System.out.println("Ar norite prideti klausima? TAIP/NE");
            boolean createQuestion = doYouWantCreateQuestion();
            if (createQuestion) {
                List<String> questionAndAnswers = createOneQuestion();
                System.out.println("Gavo lista su kl ir ats");
                ExamQuestion examQuestion = new ExamQuestion(questionAndAnswers.get(0), questionAndAnswers.get(1)
                        , questionAndAnswers.get(2), questionAndAnswers.get(3), questionAndAnswers.get(4));
                examQuestion.setExam(exam);
                System.out.println("Sukure klausi,a");
                System.out.println(examQuestion);
                //kazkas cia negerai
                examinationService.createExamQuestion(examQuestion);
            } else {
                return;
            }
        } while (true);

    }

    private List<String> createOneQuestion() {
        List<String> questionAntAnswers = new ArrayList<>();
        System.out.println("Iveskite klausima:");
        String question = scanner.nextLine();
        System.out.println("Iveskite pirma atsakymo varianta");
        String firstAnswer = scanner.nextLine();
        System.out.println("Iveskite antra atsakymo varianta");
        String secondAnswer = scanner.nextLine();
        System.out.println("Iveskite trecia atsakymo varianta");
        String thirdAnswer = scanner.nextLine();
        questionAntAnswers.add(question);
        questionAntAnswers.add(firstAnswer);
        questionAntAnswers.add(secondAnswer);
        questionAntAnswers.add(thirdAnswer);

        System.out.println("Pasirinkite teisinga atsakymo varianta");
        String correctAnswer = getCorrectAnswer(questionAntAnswers);
        questionAntAnswers.add(correctAnswer);

        for (String s : questionAntAnswers) {
            System.out.println(s);
        }

        return questionAntAnswers;
    }

    private String getCorrectAnswer(List<String> questionAndAnswers) {
        int counter = 1;
        for (String q : questionAndAnswers) {
            if (questionAndAnswers.indexOf(q) != 0) {
                System.out.printf("%s. %s\n", counter++, q);
            }
        }

        String correctAnswer = scanner.nextLine();

        do {
            switch (correctAnswer) {
                case "1" -> {
                    return questionAndAnswers.get(1);
                }
                case "2" -> {
                    return questionAndAnswers.get(2);
                }
                case "3" -> {
                    return questionAndAnswers.get(3);
                }
                default -> System.out.println("Tokio pasirinkimo nera, bandykite dar karta");
            }
        } while (true);

    }

    private boolean doYouWantCreateQuestion() {
        String answer;

        do {
            answer = scanner.nextLine();
            System.out.println("nusiskanavau");
            if (answer.equalsIgnoreCase("TAIP")) {
                return true;
            }
            if (answer.equalsIgnoreCase("NE")) {
                return false;
            }
            System.out.println("gavau boolean");
        } while (!answer.equalsIgnoreCase("TAIP") && !answer.equalsIgnoreCase("NE"));

        return false;
    }


    private void selectExam(List<Exam> exams) {
        for (Exam exam : exams) {
            System.out.printf("Id: %s pavadinimas: %s\n", exam.getExamId(), exam.getName());
        }

        // pataisyti kazkaip sita dali

        System.out.println("Pagal id, patvirtinkite kuriam egzaminui norite prideti klausimus");
        Exam exam = getExam(exams);
        createQuestions(exam);
    }

    private Exam getExam(List<Exam> exams) {
        Exam exam;
        do {
            Long examId = getCorrectNumber();
            exam = exams.stream().filter(e -> e.getExamId().equals(examId)).findFirst().orElse(null);
            if (exam == null) {
                System.out.println("Toks id neegzistuoja, pakartokite ivedima");
            }
        } while (exam == null);

        return exam;
    }

    private Long getCorrectNumber() {
        while (true) {
            try {
                return Long.valueOf(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Blogas ivedimas, bandykite dar karta");
            }
        }
    }

    private void showExams(String examName) {
        List<Exam> exams = getExams();
        List<Exam> examsWithTheSameName = new ArrayList<>();

        for (Exam exam : exams) {
            if (exam.getName().equals(examName)) {
                examsWithTheSameName.add(exam);
            }
        }

        if (examsWithTheSameName.size() == 1) {
            Exam exam = examsWithTheSameName.get(0);
            createQuestions(exam);
        } else {
            System.out.println("Egzaminai tokiu paciu pavadinimu: ");
            selectExam(examsWithTheSameName);
        }
    }

    private List<Exam> getExams() {
        return examinationService.getExam();
    }

    private void createExam() {
        System.out.println("Iveskite egzamino pavadinima");
        String examName = scanner.nextLine();
        Exam exam = new Exam(null, examName);
        examinationService.createExamName(exam);
        showExams(examName);
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
            case "4" -> System.out.println("Programa uzdaryta");
            default -> System.out.println("Blogas ivedimas");
        }
    }

    private void showTeacherMenu() {
        System.out.println("""
                [1]. Sukurti egzamina
                [2]. Redaguoti egzamina
                [3]. Perziureti egzaminu statistika
                [4]. Grizti i pradios menu
                """);
    }

    public void startStudentApplication(User user) {
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
            case "4" -> System.out.println("Programa uzdaryta");
            default -> System.out.println("Blogas ivedimas");
        }
    }

    private void showStudentMenu() {
        System.out.println("""
                [1]. Laikyti egzamina
                [2]. Perlaikyti egzamina
                [3]. Perziureti egzaminu statistika
                [4]. Grizti i pradios menu
                """);
    }

    private boolean isUserExist(List<User> users, String password, String surname) {
        boolean isUserExist = false;

        for (User user : users) {
            if (user.getUserSurname().equals(surname) && user.getPassword().equals(DigestUtils.sha512Hex(password))) {
                if (user.getUserStatus() == UserStatus.STUDENTAS) {
                    isUserExist = true;
                    startStudentApplication(user);
                }
                if (user.getUserStatus() == UserStatus.DESTYTOJAS) {
                    isUserExist = true;
                    startTeacherApplication();
                }
            }
        }

        return isUserExist;
    }

    private void logIn() {
        System.out.println("Iveskite pavarde prisijungimui");
        String surname = scanner.nextLine();
        System.out.println("Iveskite slaptazodi");
        String password = scanner.nextLine();

        List<User> users = userService.getUser();

        while (isUserExist(users, password, surname)) {
            System.out.println("Blogas prisijungimo vardas arba slaptazodis");
        }

        //nera jokio pranesimo jei nepavyksta prisijungti
    }

    private void registration() {

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

        UserStatus status = null;

        while (status == null) {
            status = getUserStatus();
        }

        User user = new User(null, name, surname, DigestUtils.sha512Hex(password), status);

        userService.createUser(user);

    }

    private UserStatus getUserStatus() {
        System.out.println("""
                Pasirinkite vartotojo statusa: 
                [1] Destytojas
                [2] Studentas 
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
                [1]. Registracija
                [2]. Prisijungimas
                [3]. Iseiti is programos
                """);
    }

    private void selectAction(String action) {
        switch (action) {
            case "1" -> registration();
            case "2" -> logIn();
            case "3" -> System.out.println("Programa uzdaryta");
            default -> System.out.println("Blogas ivedimas");
        }
    }
}
