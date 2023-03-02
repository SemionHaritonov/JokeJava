import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

public class JokeJavaFileVisitor extends SimpleFileVisitor {

    private final Path pathSource;
    private final Path pathTarget;

    public JokeJavaFileVisitor(Path pathSource, Path pathTarget) {
        this.pathSource = pathSource;
        this.pathTarget = pathTarget;
    }

    public void javaJoke() throws IOException {
        Files.walkFileTree(pathTarget, new JokeFileVisitor(pathSource));
    }



}
