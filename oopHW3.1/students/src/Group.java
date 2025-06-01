import java.util.Arrays;

public class Group {

    private String groupName;
    private Student[] students = new Student[10]; 
    
    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public Student[] getStudents() {
        return students;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public static int trueVal(Object [] obj){
        int c = 0;
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                c++;
            }
        }
        return c;
    }

    public void addStudent(Student student) throws GroupOverflowException{
        for(int i = 0; i < this.students.length; i++){
            if(students[i] == null){
                students[i] = student;
                return;
            }
        }
        throw new GroupOverflowException("Group has been filled to the maximum");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException{
        for(int i = 0; i < this.students.length; i++){
            if(students[i].getLastName().equals(lastName)){
                return students[i];
            }
        }
        throw new StudentNotFoundException("Student " + lastName + " has not been found in a " + this.groupName);
    }

    public boolean removeStudentByID(int id){
        for(int i = 0; i < this.students.length; i++){
            if((students[i] != null) && (students[i].getId() == id)){
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    public Student[] cleanStudentArr(Object [] obj){

        Student [] freshStudentArr = new Student[trueVal(obj)];
        int index = 0;
        for(int i = 0; i < obj.length; i++){
            if((obj[i] != null) && (obj[i] instanceof Student)){
                freshStudentArr[index] = (Student) obj[i];
                index++;
            }
        }
        return freshStudentArr;
    }    

        @Override
        public String toString() {
            return "Group [groupName=" + groupName + ", students=" + Arrays.toString(students) + "]";
        }
}
