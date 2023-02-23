import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Path jokeJavaPath = Paths.get(".\\joke.java").toAbsolutePath();
        Path targetPath = Paths.get(".\\Test Folder").toAbsolutePath();

        try {

            FirstJoke.initialJoke(jokeJavaPath);

            if (!Files.exists(targetPath)) Files.createDirectory(targetPath);
            PathsCreator.create(targetPath, 2, 3);

            JavaJoke.joke(jokeJavaPath.toAbsolutePath(), targetPath.toAbsolutePath());

            jokeJavaPath.toFile().delete();

            //Files.walkFileTree(targetPath, new SimpleFileVisitorDelete());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
