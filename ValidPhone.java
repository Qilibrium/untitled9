import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ValidPhone {

    private static final String RELATIVE_PATH = "src/file.txt";


    public static void main(String[] args) throws FileNotFoundException {

        String phone = new String(RELATIVE_PATH);
        try {
            FileReader fr = new FileReader(phone);
            BufferedReader reader = new BufferedReader(fr);
            String str = reader.readLine();

            while (str != null) {
                boolean sr = str.matches("\\d{3}-\\d{3}-\\d{4}");
                boolean sn = str.matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
                if(sr==true || sn==true) {
                    System.out.println(str);
                }

                str = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
// этот метод запустить не смог
//        File file= new File("file.txt");
//
//        FileInputStream fileInputStream= new FileInputStream(file);
//
//        Scanner scanner = new Scanner(fileInputStream);
//
//        while (scanner.hasNext()){
//            System.out.println(scanner.hasNext());
//            scanner.close();
//        }




