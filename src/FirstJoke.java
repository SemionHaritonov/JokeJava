import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FirstJoke {
    public static void initialJoke(Path path) {
        File outputFile = path.toFile();
        String helloWord =
                "public class Main {" +
                    "public static void main(String[] args) {" +
                        "System.out.println(\"Hello Word!\");" +
                    "}" +
                "}";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputFile);
            fileOutputStream.write(helloWord.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
