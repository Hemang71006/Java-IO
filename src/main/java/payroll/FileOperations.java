package payroll;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOperations {

    public boolean fileExists(Path path) {
        return Files.exists(path);
    }

    public boolean deleteFile(Path path) throws IOException {
        return Files.deleteIfExists(path);
    }

    public Path createDirectory(Path path) throws IOException {
        return Files.createDirectories(path);
    }

    public Path createEmptyFile(Path path) throws IOException {
        if (Files.notExists(path)) {
            return Files.createFile(path);
        }
        return path;
    }

    public List<Path> listEntries(Path directory) throws IOException {
        try (Stream<Path> paths = Files.list(directory)) {
            return paths.collect(Collectors.toList());
        }
    }

    public List<Path> listFilesWithExtension(
            Path directory, String extension) throws IOException {

        String suffix = extension.startsWith(".") ? extension : "." + extension;

        try (Stream<Path> paths = Files.list(directory)) {
            return paths.filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(suffix))
                    .collect(Collectors.toList());
        }
    }
}
