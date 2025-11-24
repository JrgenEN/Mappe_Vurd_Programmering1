package edu.ntnu.iir.bidata.utility;

import java.io.IOException;
import java.nio.file.*;

/**
 * Class to handle text to file saving.
 *
 * @author jorge
 * @version 1.0
 * @see Path
 * @see Files
 * @see StandardOpenOption
 * @since 1.0
 */
public class FileSave {
  private FileSave() {}
  private static final Path DIR = Path.of("Diary");

  public static void init() {
    try {
      Files.createDirectory(DIR);
    } catch (IOException e) {
      // Directory already exists, do nothing.
    }
  }

  /**
   * Adds text to a file.
   *
   * @param fileName Name of the file.
   * @param text Text to add.
   */
  public static void addText(String fileName, String text) {
    final Path saveFile = DIR.resolve(fileName + ".save");
    createFile(saveFile);
    try {
      if (Files.readString(saveFile).isEmpty()) {
        Files.writeString(saveFile, text);
      } else {
        Files.writeString(saveFile, "\n//\n" + text, StandardOpenOption.APPEND);
      }
    } catch (IOException e) {
      throw new NullPointerException("Failed to write to file: " + fileName);
    }
  }

  /**
   * Creates a file if it does not exist.
   *
   * @param path Path to file creation.
   */
  private static void createFile(Path path) {
    try {
      Files.createFile(path);
    } catch (FileAlreadyExistsException e) {
      // Do nothing. File already exists.
    } catch (IOException e) {
      throw new NullPointerException("Failed to create file: " + path);
    }
  }

  /**
   * Deletes a file if it exists.
   *
   * @param path File to delete.
   */
  private static void deleteFile(Path path) {
    try {
      Files.deleteIfExists(path);
    } catch (IOException e) {
      throw new NullPointerException("Failed to delete file: " + path);
    }
  }
}

