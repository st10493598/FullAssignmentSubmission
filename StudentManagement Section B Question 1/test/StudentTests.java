import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTests {

    // Test adding a student
    @Test
    public void testAddStudent() {
        ArrayList<Student> list = new ArrayList<>();
        int[] marks = {80, 70, 90};
        Student s = new Student("Alice", 18, "S001", marks);
        list.add(s);

        assertEquals(1, list.size());
    }

    // Test searching for a student by ID
    @Test
    public void testSearchStudent() {
        ArrayList<Student> list = new ArrayList<>();
        int[] marks = {60, 50, 70};
        Student s = new Student("Bob", 19, "S002", marks);
        list.add(s);

        boolean found = false;
        for (Student st : list) {
            if (st.getStudentId().equals("S002")) {
                found = true;
                break;
            }
        }

        assertTrue(found);
    }

    // Test average and grade calculation
    @Test
    public void testGrades() {
        int[] marks = {40, 50, 60};
        Student s = new Student("Charlie", 20, "S003", marks);

        double avg = s.getAverage();
        String grade = s.getGrade();

        assertEquals(50, (int) avg);
        assertEquals("Pass", grade);
    }

    // Test deleting a student
    @Test
    public void testDeleteStudent() {
        ArrayList<Student> list = new ArrayList<>();
        int[] marks = {80, 90, 85};
        Student s = new Student("David", 21, "S004", marks);
        list.add(s);

        list.remove(s);

        assertEquals(0, list.size());
    }
}
