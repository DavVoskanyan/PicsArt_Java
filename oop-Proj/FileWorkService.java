import mainCookClass.Cook;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringJoiner;

public class FileWorkService {
    public static void prepareForTest() throws IOException {
        File folder = new File("workers");
        if(!folder.exists()) {
            folder.mkdir();
        }
        File chefF = new File("workers//Chef.txt");
        File sousChefF = new File("workers//SousChef.txt");
        File cookF = new File("workers//Cook.txt");
        if(!chefF.exists()) {
            chefF.createNewFile();
        }
        if(!sousChefF.exists()) {
            sousChefF.createNewFile();
        }
        if(!cookF.exists()) {
            cookF.createNewFile();
        }
    }


    public static void write(Cook c) throws IOException {

        StringJoiner sj = new StringJoiner(" ");
        sj.add(c.getName())
        .add(Integer.toString(c.getAge()))
        .add(c.getPosition())
        .add(c.getWorkExperience())
        .add("\n");
        Files.write(Paths.get("workers\\" + c.getFileName() + ".txt"),
                sj.toString().getBytes(StandardCharsets.UTF_8));
    }


    public static void read(String fileName) throws IOException {
        ArrayList<String> workers =
                (ArrayList<String>) Files.readAllLines(
                        Paths.get("workers\\" + fileName + ".txt"));
        if(workers.size() == 0) {
            System.out.println("There are no workers of this position");
        }
        else {
            for (String str: workers) {
                System.out.println(str);
            }
        }

    }
}
