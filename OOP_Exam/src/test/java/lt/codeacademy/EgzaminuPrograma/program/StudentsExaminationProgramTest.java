package lt.codeacademy.EgzaminuPrograma.program;

import lt.coseacademy.EgzaminuPrograma.program.StudentsExaminationProgram;
import lt.coseacademy.EgzaminuPrograma.program.UniversityExamsProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class StudentsExaminationProgramTest {

    @Mock
    UniversityExamsProgram program = new StudentsExaminationProgram();

    Scanner scanner = new Scanner(System.in);

    @Test
    void chechIdWhenIdIsNotNull() {
        boolean a = program.getId() != null;
        Assertions.assertTrue(a);
    }

    @Test
    void chechIdWhenIdIsNullAntReturnNumberOne() {
        when(program.getId()).thenReturn(1);
        Integer id = program.getId();
        Assertions.assertEquals(id, 1);
    }

    @Test
    void chechIdWhenIdIsNullAntReturnNumber() {
        when(program.getId()).thenReturn(1);
        Integer id = program.getId();
        Assertions.assertNotEquals(id, 2);
    }

    @Test
    void checkIdWhenReturnIsFalse() {
        boolean a = program.isIdCorrect(scanner);
        Assertions.assertFalse(a);
    }

    @Test
    void checkIdWhenReturnIsTrue() {
        boolean a = !program.isIdCorrect(scanner);
        Assertions.assertTrue(a);
    }
}
