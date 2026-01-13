import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    Student student;
    @BeforeEach
    void setUp() {
        student = new Student("Pepe", "pepe@msn.com", 50);
    }

    @Test
    @DisplayName("Testing getStudent()")
    void testGetStudent() {
        assertEquals("Pepe", student.getName());
        assertEquals("pepe@msn.com", student.getEmail());
        assertEquals(50, student.getAge());
    }

    @Test
    @DisplayName("Testing setStudent()")
    void testSetStudent() {
        student.setName("Manolo");
        student.setEmail("manolo@hotmail.com");
        student.setAge(43);
        assertEquals("Manolo", student.getName());
        assertEquals("manolo@hotmail.com", student.getEmail());
        assertEquals(43, student.getAge());
    }

    @Test
    @DisplayName("Empty name")
    public void testEmptyName() throws IllegalArgumentException{
        String name = "";
        assertThrows(
                IllegalArgumentException.class,
                () -> student.setName(name),
                "Name cannot be empty"
        );

    }

    @Test
    @DisplayName("Invalid email")
    public void invalidEmail() throws IllegalArgumentException{
        String email = "perico.gmail.com";
        assertThrows(
                IllegalArgumentException.class,
                () -> student.setEmail(email),
                "Email must have a valid format"
        );

    }

    @Test
    @DisplayName("Invalid age")
    public void InvalidAge() throws IllegalArgumentException{
        int age = 150;
        assertThrows(
                IllegalArgumentException.class,
                () -> student.setAge(age),
                "Age must be between 0 and 120 years"
        );
    }

    @Test
    @DisplayName("Add grade")
    public void addGrade() throws IllegalArgumentException {
        double grade = 11;
        assertThrows(
                IllegalArgumentException.class,
                () -> student.addGrade(grade),
                "Grade must be between 0.0 and 10.0"
        );
        double grade2 = 9.5;
        student.addGrade(grade2);
    }

    @Test
    @DisplayName("Calculate average")
    public void calculateAverage() {
        List<Double> grades = new ArrayList<>();
        double grade2 = 9.5;
        double grade3 = 4;
        student.addGrade(grade2);
        student.addGrade(grade3);
        grades.add(grade2);
        grades.add(grade3);
        assertEquals(student.calculateAverage(),6.75 );
    }

    @Test
    @DisplayName("Get academic satus")
    public void getAcademicStatus() {

        List<Double> grades = new ArrayList<>();
        double grade2 = 9.5;
        double grade3 = 4;
        student.addGrade(grade2);
        student.addGrade(grade3);
        grades.add(grade2);
        grades.add(grade3);
        assertEquals(student.calculateAverage(),6.75 );
        assertEquals(student.getAcademicStatus(),"Regular");
    }

}
