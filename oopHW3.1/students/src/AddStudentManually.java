import java.util.Scanner;

public class AddStudentManually {

    public static Student addStudentManually(){
        Scanner sc = new Scanner(System.in);
        Gender studentGender = null;

        System.out.println("Please enter the following details:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
    
        System.out.print("Group: ");
        String groupName = sc.nextLine();

        System.out.print("Specify student's gender, *M* or *F*): ");
        String gender = sc.nextLine().trim().toUpperCase();

        if(gender.equals("M")){
            studentGender = Gender.MALE;

        }else if(gender.equals("F")){
            studentGender = Gender.FEMALE;

        }else{
            System.out.println("Incorrect input");
            return null;
        }
        
        return new Student(name, lastName, studentGender, id, groupName);
    }
}