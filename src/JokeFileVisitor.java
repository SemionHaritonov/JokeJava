import java.io.IOException;
import java.nio.file.*;

public class JokeFileVisitor extends SimpleFileVisitor<Path> {

    private final Path pathSource;

    public JokeFileVisitor(Path pathSource) {
        this.pathSource = pathSource;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc)
            throws IOException {
        if (exc == null) {
            Path path = Paths.get(dir + "\\joke.java");
            Files.copy(pathSource, path, StandardCopyOption.REPLACE_EXISTING);
            return FileVisitResult.CONTINUE;
        } else {
            throw exc;
        }
    }
}
