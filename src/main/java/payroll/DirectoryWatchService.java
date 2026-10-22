package payroll;

import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.stream.Stream;

public class DirectoryWatchService {

    public long countEntries(Path directory) throws IOException {
        try (Stream<Path> paths = Files.walk(directory)) {
            return paths.filter(path -> !path.equals(directory)).count();
        }
    }

    public void registerDirectoryTree(
            Path directory,
            WatchService watchService,
            Map<WatchKey, Path> registeredDirectories) throws IOException {

        try (Stream<Path> paths = Files.walk(directory)) {
            for (Path path : (Iterable<Path>) paths.filter(Files::isDirectory)::iterator) {
                WatchKey key = path.register(
                        watchService,
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE,
                        StandardWatchEventKinds.ENTRY_MODIFY
                );

                registeredDirectories.put(key, path);
            }
        }
    }

    public WatchService startWatching(
            Path directory,
            Map<WatchKey, Path> registeredDirectories) throws IOException {

        WatchService watchService =
                FileSystems.getDefault().newWatchService();

        registerDirectoryTree(directory, watchService, registeredDirectories);

        return watchService;
    }
}
