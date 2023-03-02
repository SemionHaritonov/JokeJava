import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class JavaJoke {

    private final Path pathSource;
    private final Path pathTarget;


    public JavaJoke(Path pathSource, Path pathTarget) {
        this.pathSource = pathSource;
        this.pathTarget = pathTarget;
    }
    public void joke() throws IOException {
        ArrayList<File> fileArrayList = new ArrayList<>();
        searchFolders(pathTarget, fileArrayList);
        for (File file:
             fileArrayList) {
            Path path = Paths.get(file.getPath() + "\\joke.java");
            Files.copy(pathSource, path, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private static void searchFolders(Path path, List<File> folderList) {
        if(path.toFile().isDirectory()) {
            folderList.add(path.toFile());
            File[] directoryFiles = path.toFile().listFiles();
            if (directoryFiles != null) {
                for (File file:
                     directoryFiles) {
                    if (file.isDirectory()) {
                        folderList.add(file);
                        searchFolders(file.toPath(), folderList);
                    }
                }
            }
        }
    }
}
