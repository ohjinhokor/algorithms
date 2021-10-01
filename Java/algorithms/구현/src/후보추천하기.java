import java.util.*;
import java.util.Scanner;

public class 후보추천하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] allStudent = new int[101];
        List<Student> hStudents = new ArrayList<>();

        for(int i=0; i<M; i++){
            int studentNumber = sc.nextInt();

            if(allStudent[studentNumber]>0){
                allStudent[studentNumber] += 1;

                for(int j=0; j<hStudents.size(); j++){
                    if(hStudents.get(j).num == studentNumber){
                    hStudents.get(j).count += 1;
                    }
                }
            }
            else{
                if(hStudents.size() >= N){
                    Collections.sort(hStudents);
                    allStudent[hStudents.get(0).num] = 0;
                    hStudents.remove(0);

                    allStudent[studentNumber] = +1;
                    hStudents.add(new Student(studentNumber,1,i));
                }
                else{
                    allStudent[studentNumber] = +1;
                    hStudents.add(new Student(studentNumber,1,i));
                }
            }
        }
        for (int i =0; i<101; i++) {
                if(allStudent[i]>0){
                    System.out.println(i);
            }
        }
    }
}

class Student implements Comparable<Student>{

    int num;
    int count;
    int date;

    public Student(int num, int count, int date) {
        this.num = num;
        this.count = count;
        this.date = date;
    }

    @Override
        public int compareTo(Student o) {
            if(count>o.count){
                return 1;
            }
            else if(count==o.count){
                return date - o.date;
            }
            else{
                return -1;
            }
        }
    }


4
        9
        3 4 5 4 5 6 45 53 23