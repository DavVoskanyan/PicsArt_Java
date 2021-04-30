import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String f = "C:\\Users\\Hayk_Avdalyan\\Desktop\\students.txt";
        Scanner numOfFunc = new Scanner(System.in);
        int i;
        boolean work = true;
        FileService fs = new FileService();
        try {
            while (work) {
                i = numOfFunc.nextInt();
                switch (i) {
                    case 1:
                        fs.printFullNames(getLines(f));
                        break;
                    case 2:
                        fs.printMaleStudents(getLines(f));
                        break;
                    case 3:
                        fs.printFemaleGreatMark(getLines(f));
                        break;
                    case 4:
                        fs.minimalMark(getLines(f));
                        break;
                    case 5:
                        fs.OldestMaleStudent(getLines(f));
                        break;
                    case 6:
                        fs.SortAndPrintByMark(getLines(f));
                        break;
                    case 7:
                        fs.SortGirlsByBirthYear(getLines(f));
                        break;
                    case 8:
                        work = false;
                        break;
                }
            }
        }
        catch(Exception e) {
            System.out.println("Error");
        }
    }
    public static String[] getLines(String file) throws IOException {
        return Files.readAllLines(Paths.get(file)).toArray(new String[0]);
    }
}
