public class FileService {
    public void printFullNames(String[] s) {
        for(String t: s) {
            System.out.printf("%s %s \n", t.split(",")[0], t.split(",")[1]);
        }
    }



    public void printMaleStudents(String[] s) {
        String arr[];
        for(String t: s) {
            arr = t.split(",");
            if(arr[3].equals("m")) {
                System.out.printf("%s %s\n", arr);
            }
        }
    }



    public void printFemaleGreatMark(String[] s) {
        String arr[];
        for(String t: s) {
            arr = t.split(",");
            if(arr[3].equals("f") && Double.parseDouble(arr[4]) > 50.4) {
                System.out.printf("%s %s %s\n", arr[0], arr[1], arr[4]);
            }
        }
    }


    public void minimalMark(String[] s) {
        String[] arr;
        double minMark = Double.parseDouble(s[0].split(",")[4]);
        String minMarkStud = "";
        for(int i = 1; i < s.length; i++) {
            arr = s[i].split(",");
            if(Double.parseDouble(arr[4]) < minMark) {
                minMark = Double.parseDouble(arr[4]);
                minMarkStud = arr[0] + " " + arr[1] + " " + arr[4];
            }
        }
        System.out.println(minMarkStud);
    }



    public void OldestMaleStudent(String[] s) {
        String[] arr;
        int maxAge = Integer.parseInt(s[0].split(",")[2]);
        String maxAgeStud = "";
        for(int i = 0; i < s.length; i++) {
            arr = s[i].split(",");
            if(Integer.parseInt(arr[2]) < maxAge && arr[3].equals("m")) {
                maxAge = Integer.parseInt(arr[2]);
                maxAgeStud = arr[0] + " " + arr[1] + " " + arr[2];
            }
        }
        System.out.println(maxAgeStud);
    }



    public void SortAndPrintByMark(String[] s) {
        String[] arr1;
        String[] arr2;
        String temp = "";
        for(int i = 0; i < s.length - 1; i++) {
            for(int j = i + 1; j < s.length; j++) {
                arr1 = s[i].split(",");
                arr2 = s[j].split(",");
                if(Double.parseDouble(arr1[4]) < Double.parseDouble(arr2[4])) {
                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        for (String t: s) {
            System.out.println(t);
        }
    }




    public void SortGirlsByBirthYear(String[] s) {
        String[] arr1;
        String[] arr2;
        String temp = "";
        for(int i = 0; i < s.length - 1; i++) {
            for(int j = i + 1; j < s.length; j++) {
                arr1 = s[i].split(",");
                arr2 = s[j].split(",");
                if(arr1[3].equals("f") && arr2[3].equals("f") &&
                        Double.parseDouble(arr1[2]) < Double.parseDouble(arr2[2])) {
                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        for (String t: s) {
            if(t.split(",")[3].equals("f"))
                System.out.println(t);
        }
    }
}
