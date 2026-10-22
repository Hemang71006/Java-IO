package payroll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryWatchServiceTest {

    @TempDir
    Path tempDir;

    private final DirectoryWatchService service =
            new DirectoryWatchService();

    @Test
    void shouldCountFilesAndSubdirectories() throws IOException {
        Files.createFile(tempDir.resolve("first.txt"));

        Path subdirectory = Files.createDirectory(tempDir.resolve("sub"));
        Files.createFile(subdirectory.resolve("second.txt"));

        assertEquals(3, service.countEntries(tempDir));
    }

    @Test
    void shouldRegisterRootAndSubdirectoryForWatching()
            throws IOException {

        Files.createDirectory(tempDir.resolve("sub"));

        Map<WatchKey, Path> registered = new HashMap<>();

        try (WatchService watcher =
                     service.startWatching(tempDir, registered)) {

            assertEquals(2, registered.size());
        }
    }
}
