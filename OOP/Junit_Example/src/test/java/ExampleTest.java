import lt.codeacademy.Example;
import lt.codeacademy.User;
import lt.codeacademy.UserServise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
//visos klases kurios turws @mock, bus imituoti objektai
@ExtendWith({MockitoExtension.class})
public class ExampleTest {
    //visus objektus po example
    @InjectMocks
    private Example example;
    //nekuriu sito objekto, as tik imituoju
    @Mock
    private UserServise userServise;
    private UUID id;
//paruosiu duomenis testui
    @BeforeEach
    void setUp() {
        //uzsimokinti klase galima ir tokiu budu
       // UserServise userServise = Mockito.mock(UserServise.class);
        //example = new Example(userServise);

        id = UUID.randomUUID();
    }

    @Test
    void testGetUserByIdWhenIdISNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> example.getUserById(null));
        assertEquals("Missing user id",exception.getMessage() );

    }

    @Test
    void testGetUserById() {
        UUID id = UUID.randomUUID();
        when(userServise.getUserById(eq(id))).thenReturn(new User(50));

        User user = example.getUserById(id);

        assertNotNull(user);
        assertEquals(50, user.getAge());
    }

    @Test
    void testCreateNewUserWhenUserServiseThrowException() {
        //pasakyti, kad ismestu klaida IllegalArgument.
        doThrow(IllegalArgumentException.class).when(userServise).getUserName();
        //patikrinti klaida, tikimes klaidos, kai -> kviesim toki metoda su null
        assertThrows(IllegalArgumentException.class, () -> example.createNewNumber(null));
    }

    @Test
    void testCreateNewUser() {
        when(userServise.getUserName()).thenReturn("DummyName");
        boolean isUserCreated = example.createNewNumber(new User(12));
        assertTrue(isUserCreated);
    }

    @Test
    void testCreateNewUserWhenUserisNull() {
        when(userServise.getUserName()).thenReturn(null);
        boolean isUserCreated = example.createNewNumber(new User(11));
        assertFalse(isUserCreated);
    }

    @Test
    void testCreateNewUserWhenUserAgeisLess() {
        boolean isUserCreated = example.createNewNumber(new User(5));
        //parasom ko tikimes, kad tikimes false
       assertFalse(isUserCreated);
    }

    @Test
        //void test_method_result() {}\
    void testMethodNameWhenSomethingHappen() {
        double pow = Math.pow(2,2);

        //reiksme kurios tikiuosi
        assertEquals(4, pow);
        assertNotNull(id);
    }

}
