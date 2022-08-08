package V2_IO;

public interface ISaveable {
  public int getId();

  public String getDataString();

  public void restoreFromDataString(String dataString);
}
