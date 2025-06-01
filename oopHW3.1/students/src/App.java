import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        
        Group javaGroup = new Group("java");
        
        //Using chatGPT
        Student student1 = new Student("Alice", "Johnson", Gender.FEMALE, 1, "java");
        Student student2 = new Student("Bob", "Smith", Gender.MALE, 2, "java");
        Student student3 = new Student("Clara", "Williams", Gender.FEMALE, 3, "java");
        Student student4 = new Student("David", "Brown", Gender.MALE, 4, "java");
        Student student5 = new Student("Eva", "Jones", Gender.FEMALE, 5, "java");
        Student student6 = new Student("Frank", "Garcia", Gender.MALE, 6, "java");
        Student student7 = new Student("Grace", "Miller", Gender.FEMALE, 7, "java");
        Student student8 = new Student("Henry", "Davis", Gender.MALE, 8, "java");
        Student student9 = new Student("Isla", "Martinez", Gender.FEMALE, 9, "java");
        Student student10 = new Student("Jack", "Hernandez", Gender.MALE, 10, "java");
        //Student student11 = new Student("Kai", "Lopez", Gender.MALE, 11, "java");
        
        Student[] arrStudent = {student1, student2, student3, student4, student5, student6, student7, student8, student9, student10};

        for (Student student : arrStudent){
            try {
                javaGroup.addStudent(student);
                System.out.println(student.getLastName() + " has been added to " + javaGroup.getGroupName());
            } catch (GroupOverflowException e) {
                e.printStackTrace();
            }
        }

        System.out.println();

        try {
            Student student = javaGroup.searchStudentByLastName("Garcia");
            System.out.println(student.toString());
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

        javaGroup.removeStudentByID(6);
        
        try {
            Student student = javaGroup.searchStudentByLastName("Garcia");
            System.out.println(student.toString());
        } catch (StudentNotFoundException | NullPointerException e) {
            System.out.println("Given student has not been found");
        }

        Student[] freshStudentArr = javaGroup.cleanStudentArr(arrStudent);

        Arrays.sort(freshStudentArr, new StudentNameComparator());

        for(Student std : freshStudentArr){
            System.out.println(std.getLastName());
        }

        Student test = AddStudentManually.addStudentManually();

        System.out.println(test.toString());
    }
}