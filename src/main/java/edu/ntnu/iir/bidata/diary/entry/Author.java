package edu.ntnu.iir.bidata.diary.entry;

/**
 * Class for authors.
 *
 *
 * @author jorgen
 * @version 1.0
 * @see String
 */
public class Author {
  private String name;

  /**
   * Constructor for author.
   *
   *
   * @param name Name of author.
   */
  public Author(String name) {
    this.setName(name);
  }

  /**
   * Getter for name.
   *
   *
   * @return this.name Returns name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Formats the name to be Uppercase letter at the start.
   *
   *
   * @param name Name of the author.
   * @return Formated string with uppercase letters.
   */
  public static String formatName(final String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException("Name is empty");
    }
    String[] names = name.split(" ");
    String returnString = "";
    for (String s : names) {
      char[] c = s.toCharArray();
      c[0] = Character.toUpperCase(c[0]);
      for (int i = 1; i < c.length; i++) {
        c[i] = Character.toLowerCase(c[i]);
      }
      if (!returnString.isEmpty()) {
        returnString = returnString.concat(" ");
      }
      returnString = returnString.concat(new String(c));
    }
    return returnString;
  }

  /**
   * Sets the this.name as @param.
   *
   *
   * @param name Name.
   */
  private void setName(String name) {
    this.name = formatName(name);
  }
}
