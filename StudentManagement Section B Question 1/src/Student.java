public class Student extends Person {
    private final String studentId;
    private final int[] marks;

    public Student(String n, int a, String id, int[] m) {
        super(n, a);
        studentId = id;
        marks = m;
    }

    public String getStudentId() {
        return studentId;
    }

    public int[] getMarks() {
        return marks;
    }

    public double getAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 75) {
            return "Distinction";
        } else if (avg >= 50) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    @Override
    public String toString() {
        return "ID: " + studentId +
               "\nName: " + getName() +
               "\nAge: " + getAge() +
               "\nAverage: " + getAverage() +
               "\nGrade: " + getGrade();
    }
}

