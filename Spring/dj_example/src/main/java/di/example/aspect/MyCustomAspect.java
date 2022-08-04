package di.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCustomAspect {
   // @Around() kai kvieciamas metodas ir grazinamas rezultatas, pries ir po
   // @After() kvieciamas po after mtodo iskvietimo
    //@Before() PRIES metodo kvietima
    //@AfterReturning triginamas tada kai kazkas grazinama

    //Kuriam aspect
    //turim pasakyti pagal ka turi trigrintids
    @Around("execution(* di.example.service.GradeService.averageGrade())")
    public double testAroundAspect(ProceedingJoinPoint point) throws Throwable {
        System.out.println("Issitrigerino pries metodo kvietima");
        Object rezult = point.proceed();
        System.out.println("Po metoro kvietimo " + rezult);

        if(rezult instanceof Double value) {
            return value + 10;
        }

        return 0.0;

    }

    @AfterReturning(pointcut = "execution(* di.example.service.GradeService.averageGrade())", returning = "result")
    public void testAfterReturning(Double result) {
        System.out.println("Jau kviestas po metodo resultato grazinimo " + result);
    }
}
