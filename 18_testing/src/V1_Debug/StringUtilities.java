package V1_Debug;

public class StringUtilities {
  // private StringBuilder builder = new StringBuilder();
  private int charsAdded = 0;

  public void addChar(StringBuilder builder, char c) {
    builder.append(c);
    charsAdded++;
  }

  public int getCharsAdded() {
    return charsAdded;
  }
}
