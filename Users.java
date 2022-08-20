import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Users {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Json {

    private static final String RELATIVE_PATH = "src/file.txt";


    public static void main(String[] args) throws FileNotFoundException {

        String phone = new String(RELATIVE_PATH);
        List<User> users= new ArrayList<>();

        try {
            FileReader fr = new FileReader(phone);
            BufferedReader reader = new BufferedReader(fr);
            String str = reader.readLine();

            String userParameters;

            while ((userParameters = reader.readLine()) != null) {

                String[] parameters=userParameters.split(" ");

                User user=new User(parameters[0],Integer.valueOf(parameters[1]));

                users.add(user);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("src/users.json"));

            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(json);
    }

}
