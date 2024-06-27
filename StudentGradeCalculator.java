import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner se = new Scanner(System.in);
        System.out.print("Enter number of Subject : ");
        int total_sub = se.nextInt();
        int[] mark=new int[total_sub];
        int total_mark=0;
        System.out.println("Enter subject marks .");
        for(int i=0;i<total_sub;i++)
        {
            System.out.println("Enter the mark of subject number "+(i+1)+" .");
            mark[i]=se.nextInt();
            total_mark+=mark[i];
        }
        double averagePercentage = (double)total_mark/total_sub;


        char grade;
        int range = (int) (averagePercentage / 10);
        grade = switch (range) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };

        System.out.println("Grade: " + grade);
        System.out.println("Total mark "+total_mark);
        System.out.println("Average Percentage "+averagePercentage);
        System.out.println("Grade: "+grade);
    }
}
