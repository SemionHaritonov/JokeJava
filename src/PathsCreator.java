import java.io.IOException;
import java.nio.file.*;

public class PathsCreator {
    public static void create(Path path, int deep, int foldersInDir) throws IOException {
        initialFolder(path, foldersInDir);
        createFoldersThree(path, deep, foldersInDir);
    }

    private static void initialFolder(Path path, int foldersInDir) throws IOException {
        for (int folderCounter = 1; folderCounter <= foldersInDir; folderCounter++) {
            Path dir = Paths.get(path + "\\New folder " + folderCounter);
            if (!Files.exists(dir)) Files.createDirectory(dir);
        }
    }

    private static void createFoldersThree(Path path, int deep, int foldersInDir) throws IOException {
        for (int deepCounter = 1; deepCounter < deep; deepCounter++) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path child:
                        directoryStream) {
                    if(child.toFile().isDirectory()) {
                        for (int counter = 1; counter <= foldersInDir; counter++) {
                            Path dir = Paths.get(child + "\\New folder " + counter);
                            if (!Files.exists(dir)) Files.createDirectory(dir);
                        }
                    }
                }
            }
        }
    }
}
