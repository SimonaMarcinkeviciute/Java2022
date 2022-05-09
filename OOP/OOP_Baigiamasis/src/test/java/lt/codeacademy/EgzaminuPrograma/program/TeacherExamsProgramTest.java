package lt.codeacademy.EgzaminuPrograma.program;

import lt.coseacademy.EgzaminuPrograma.program.TeacherExamsProgram;
import lt.coseacademy.EgzaminuPrograma.program.UniversityExamsProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Scanner;

import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
public class TeacherExamsProgramTest {

    @Mock
    UniversityExamsProgram universityExamsProgram = new TeacherExamsProgram();

    Scanner scanner = new Scanner(System.in);

    @Test
    void checkLoginWhenIdIsFalse() {
        boolean a = universityExamsProgram.isIdCorrect(scanner);
        Assertions.assertFalse(a);
    }

    @Test
    void checkLoginWhenIdIsTrue() {
        boolean a = !universityExamsProgram.isIdCorrect(scanner);
        Assertions.assertTrue(a);
    }

    @Test
    void chechIdWhenIdIsNull() {
        boolean a = universityExamsProgram.getId() == null;
        Assertions.assertFalse(a);
    }

    @Test
    void chechIdWhenIdIsNotNull() {
        boolean a = universityExamsProgram.getId() != null;
        Assertions.assertTrue(a);
    }

    @Test
    void chechIdWhenIdIsNullAntReturnNumberOne() {
        when(universityExamsProgram.getId()).thenReturn(1);
        Integer id = universityExamsProgram.getId();
        Assertions.assertEquals(id, 1);
    }

    @Test
    void chechIdWhenIdIsNullAntReturnNumber() {
        when(universityExamsProgram.getId()).thenReturn(1);
        Integer id = universityExamsProgram.getId();
        Assertions.assertNotEquals(id, 2);
    }




}
