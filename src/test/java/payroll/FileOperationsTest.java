package payroll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationsTest {

    @TempDir
    Path tempDir;

    private final FileOperations operations = new FileOperations();

    @Test
    void shouldCheckFileExistsAndDeleteIt() throws IOException {
        Path file = Files.createFile(tempDir.resolve("sample.txt"));

        assertTrue(operations.fileExists(file));
        assertTrue(operations.deleteFile(file));
        assertFalse(operations.fileExists(file));
    }

    @Test
    void shouldCreateDirectory() throws IOException {
        Path directory = tempDir.resolve("new-folder");

        operations.createDirectory(directory);

        assertTrue(Files.isDirectory(directory));
    }

    @Test
    void shouldCreateEmptyFile() throws IOException {
        Path file = tempDir.resolve("empty.txt");

        operations.createEmptyFile(file);

        assertTrue(Files.exists(file));
        assertEquals(0, Files.size(file));
    }

    @Test
    void shouldListFilesAndDirectories() throws IOException {
        Files.createFile(tempDir.resolve("a.txt"));
        Files.createDirectory(tempDir.resolve("folder"));

        List<Path> entries = operations.listEntries(tempDir);

        assertEquals(2, entries.size());
    }

    @Test
    void shouldListFilesByExtension() throws IOException {
        Files.createFile(tempDir.resolve("one.txt"));
        Files.createFile(tempDir.resolve("two.txt"));
        Files.createFile(tempDir.resolve("image.png"));

        List<Path> txtFiles =
                operations.listFilesWithExtension(tempDir, "txt");

        assertEquals(2, txtFiles.size());
        assertTrue(txtFiles.stream()
                .allMatch(path -> path.toString().endsWith(".txt")));
    }
}
