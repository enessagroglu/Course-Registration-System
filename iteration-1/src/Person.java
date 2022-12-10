import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public abstract class Person {
    private String fullName;
    private String email;
    private String password;

    protected Person() {
    }

    static String getFullName() {
        String path = new File("").getAbsolutePath() + "/src/names.json";
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Random random = new Random();
        String name = lines.get(random.nextInt(lines.size()));
        String mail;
        name=name.substring(5, name.length() - 2);
        return name;
    }

//public abstract String getFullName();

    //public abstract String getFullName(){};

    abstract String getEmail();

    abstract String getPassword();

    abstract Boolean login(String userId, String password);
}