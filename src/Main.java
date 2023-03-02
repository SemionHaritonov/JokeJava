import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Path jokeJavaPath = Paths.get(".\\joke.java").toAbsolutePath();
        Path targetPath = Paths.get(".\\Test Folder").toAbsolutePath();

        JavaJoke javaJoke = new JavaJoke(jokeJavaPath, targetPath);

        JokeJavaFileVisitor jokeJavaFileVisitor = new JokeJavaFileVisitor(jokeJavaPath, targetPath);

        try {

            FirstJoke.initialJoke(jokeJavaPath);

            if (!Files.exists(targetPath)) Files.createDirectory(targetPath);
            PathsCreator.create(targetPath, 2, 3);

            //javaJoke.joke();

            jokeJavaFileVisitor.javaJoke();


            jokeJavaPath.toFile().delete();



            //Files.walkFileTree(targetPath, new SimpleFileVisitorDelete());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
