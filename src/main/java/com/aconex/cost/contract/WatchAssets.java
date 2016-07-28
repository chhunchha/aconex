package com.aconex.cost.contract;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Simple file watcher that hot-deploys file changes in `src/main/resources/assets` to `target/classes/assets`
 * Note: this only works if you run the `PrimaryApplication` class with an "exploded" directory structure.
 * <p>
 * You can use your IDE to do this or with the maven exec plugin...
 * <p>
 * mvn exec:java -Dexec.mainClass="com.aconex.cost.contract.PrimaryApplication" -Dexec.args="server src/main/resources/app.yml"
 * mvn exec:java -Dexec.mainClass="com.aconex.cost.contract.WatchAssets"
 */
public class WatchAssets {

    private static final String WATCH_DIR = "src/main/resources/assets";
    private static final String DESTINATION_DIR = "target/classes/assets";

    public static void main(String[] args) {

        System.out.println("> Watching " + WATCH_DIR + " for changes...");

        Path watchDir = Paths.get(WATCH_DIR);
        Path destDir = Paths.get(DESTINATION_DIR);

        try {
            WatchService watcher = watchDir.getFileSystem().newWatchService();
            watchDir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
            Files.walkFileTree(watchDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
                    return FileVisitResult.CONTINUE;
                }
            });
            while (true) {
                try {
                    WatchKey watchKey = watcher.take();
                    for (WatchEvent event : watchKey.pollEvents()) {
                        if (event.kind() == ENTRY_CREATE) {
                            System.out.println("> Created: " + event.context().toString());
                        }
                        if (event.kind() == ENTRY_DELETE) {
                            System.out.println("> Deleted: " + event.context().toString());
                        }
                        if (event.kind() == ENTRY_MODIFY) {
                            System.out.println("> Modified: " + event.context().toString());
                        }
                        FileUtils.copyDirectory(watchDir.toFile(), destDir.toFile());
                        System.out.println("  Copied files to " + DESTINATION_DIR);
                    }
                    if (!watchKey.reset()) {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
