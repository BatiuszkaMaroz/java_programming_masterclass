package challenges;

public class PlayingCat {
  public static boolean isCatPlaying(boolean summer, int temperature) {
    return temperature >= 25 && (summer && temperature <= 45 || temperature <= 35);
  }
}
