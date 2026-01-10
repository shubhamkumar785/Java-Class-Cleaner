import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class deleteClass {

    public static void main(String[] args) {

        Path baseDir = Paths.get("").toAbsolutePath();

        System.out.println("Folder: " + baseDir);
        System.out.println("Searching for .class files...");

        try (Stream<Path> paths = Files.walk(baseDir)) {

            paths
                    .filter(path -> path.toString().endsWith(".class"))
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                            System.out.println("Deleted: " + path);
                        } catch (IOException e) {
                            System.out.println("Cannot delete: " + path);
                        }
                    });

            System.out.println("All .class files deleted.");

        } catch (IOException e) {
            System.out.println("Error while scanning files: " + e.getMessage());
        }
    }
}

