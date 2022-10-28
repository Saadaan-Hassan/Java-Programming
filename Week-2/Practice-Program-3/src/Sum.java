import java.util.Scanner;

public class Sum {
    Scanner inp = new Scanner(System.in);
    byte marks_1, marks_2, marks_3, marks_4, marks_5;
    float percentage;
    String name;

    public void percentageCalclator() {
        System.out.println("----Percentage Calculator----");
        System.out.println("Note: Marks must be entered out of 100.");

        System.out.print("Enter your name: ");
        name = inp.nextLine();
        System.out.print("Enter marks of subject-1: ");
        marks_1 = inp.nextByte();
        System.out.print("Enter marks of subject-2: ");
        marks_2 = inp.nextByte();
        System.out.print("Enter marks of subject-3: ");
        marks_3 = inp.nextByte();
        System.out.print("Enter marks of subject-4: ");
        marks_4 = inp.nextByte();
        System.out.print("Enter marks of subject-5: ");
        marks_5 = inp.nextByte();

        percentage = (float)((marks_1 + marks_2 + marks_3 + marks_4 + marks_5)*100)/500;
        System.out.printf("%s percentage is %f\n", name, percentage);
    }
}
