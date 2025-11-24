package edu.ntnu.iir.bidata.utility;

import edu.ntnu.iir.bidata.diary.entry.Post;
import edu.ntnu.iir.bidata.diary.registers.AuthorRegister;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

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

  private static Path dir;
  private static String split;

  /**
   * Initializer for {@link FileSave}.
   *
   * @param directory Name of directory to create.
   * @param regex Regex to split text on.
   */
  public static void init(String directory, String regex) {
    dir = Path.of(directory);
    split = regex;
    try {
      Files.createDirectory(dir);
    } catch (IOException e) {
      // Directory already exists, do nothing.
    }
  }

  /**
   * Deletes text from a file.
   *
   * @param filename name of the file.
   * @param text text to delete if it exists in the file.
   */
  public static void deleteText(String filename, String text) {
    final Path filePath = dir.resolve(filename + ".save");
    String lines;
    try {
      lines = String.join("\n", Files.readAllLines(filePath));
      if (lines.isEmpty()) {
        deleteFile(filePath);
        throw new NullPointerException("File has been deleted");
      } else if (lines.contains("\n" + split + "\n" + text)) {
        lines = lines.replace("\n" + split + "\n" + text, "");
      } else if (lines.contains(text + "\n" + split + "\n")) {
        lines = lines.replace(text + "\n" + split + "\n", "");
      } else if (lines.contains(text)) {
        lines = lines.replace(text, "");
      }
      if (lines.isEmpty()) {
        deleteFile(filePath);
      } else {
        Files.writeString(filePath, lines);
      }
    } catch (NullPointerException e) {
      // Do nothing. File is deleted.
    } catch (IOException e) {
      throw new NullPointerException(e.getMessage());
    }
  }

  /**
   * Adds text to a file.
   *
   * @param fileName Name of the file.
   * @param text Text to add.
   */
  public static void addText(String fileName, String text) {
    final Path saveFile = dir.resolve(fileName + ".save");
    createFile(saveFile);
    try {
      if (Files.readString(saveFile).isEmpty()) {
        Files.writeString(saveFile, text);
      } else {
        Files.writeString(saveFile,  "\n" + split + "\n" + text, StandardOpenOption.APPEND);
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

  /**
   * Parses all files in the directory and returns an {@link AuthorRegister} of the file contents.
   *
   * @return file contents as an {@link AuthorRegister}.
   */
  public static AuthorRegister parseFilesContent() {
    List<Path> paths = getAllPaths();
    AuthorRegister register = new AuthorRegister();

    for (Path path : paths) {
      try {
        List<String> lines = Files.readAllLines(path);

        String post = "";
        for (String line : lines) {
          if (line.startsWith(split)) {
            register.addDiaryPost(new Post(post));
            post = "";
          } else {
            post = post.concat(line + '\n');
          }
        }
        register.addDiaryPost(new Post(post));

      } catch (IOException e) {
        throw new NullPointerException(e.getMessage());
      }
    }
    return register;
  }

  /**
   * Returns all paths in the directory.
   *
   * @return List of paths.
   */
  private static List<Path> getAllPaths() {
    List<Path> returnPaths = new ArrayList<>();
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
      stream.forEach(returnPaths::add);
    } catch (IOException e) {
      throw new NullPointerException(e.getMessage());
    }
    return returnPaths;
  }
}

