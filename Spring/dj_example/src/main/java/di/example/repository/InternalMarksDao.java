package di.example.repository;

import di.example.MarkDao;
import org.springframework.stereotype.Repository;

import java.util.List;
// nusakom kad sukurtu objekta, kai noresim panaudoti
//depensency injection su spring nusakom
@Repository
public class InternalMarksDao implements MarkDao {
    @Override
    public List<Double> getMarks() {
        return List.of(9.0, 8.0, 5.0, 8.5, 7.0 );
    }
}
