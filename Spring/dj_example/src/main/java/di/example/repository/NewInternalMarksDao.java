package di.example.repository;

import di.example.MarkDao;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NewInternalMarksDao implements MarkDao {
    @Override
    public List<Double> getMarks() {
        return List.of(7.0, 2.0, 5.0, 8.5, 5.0 );
    }
}
