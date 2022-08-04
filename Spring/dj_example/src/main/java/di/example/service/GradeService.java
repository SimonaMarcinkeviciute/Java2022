package di.example.service;

import di.example.MarkDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//spring scope
//singletonai, viena karta sukuriami servisai
public class GradeService {

    private final MarkDao markDao;
//nusakome kas spring is dvieju surastu repository ka autowirintu, naudojamas kai kelios klases implementina viena interfeisa
    public GradeService(@Qualifier("newInternalMarksDao") MarkDao markDao) {
        this.markDao = markDao;
    }

    public Double averageGrade() {
        /* vienas  budas
        Double sum = 0.0;
        for(Double d: markDao.getMarks()) {
            sum += d;
        }

        return sum /markDao.getMarks().size();*/

        /*double sum = markDao.getMarks().stream().mapToDouble(v -> v).sum();

        return sum /markDao.getMarks().size();*/

        return markDao.getMarks().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

}
