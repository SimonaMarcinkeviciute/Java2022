package di.example;

import di.example.config.ApplicationConfig;
import di.example.service.GradeService;
import di.example.repository.InternalMarksDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiMain {
    public static void main(String[] args) {
        DiMain diMain = new DiMain();
        diMain.plainJavaDI();

        diMain.springDi();

    }

    private void plainJavaDI() {
        GradeService gradeService = new GradeService(new InternalMarksDao());
        System.out.printf("plain java Average: %s\n", gradeService.averageGrade());
    }

    private void springDi() {
        //taip veikia spring dependency injection
        //kad veiktu turi buti unikali klase, negali to paties interfeiso implementuoti dvi klases
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        //kuriame objekta
        GradeService gradeService = context.getBean(GradeService.class);
        System.out.println("spring DI average " + gradeService.averageGrade());
    }
}

// spring configa reikia pasirasyti
//controller pirminiam vartotojo veiksmams
//service atliekama bizni logika, singletonas
//repository - lygis kuris dirba su duomenu bazemis
//jei nei vienas netinka, bet norim spring scope galima deti component