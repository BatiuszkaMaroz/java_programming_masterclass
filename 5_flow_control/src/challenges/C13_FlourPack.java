package challenges;

public class C13_FlourPack {
  public static boolean canPack(int bigCount, int smallCount, int goal) {
    if (bigCount < 0 || smallCount < 0 || goal < 0)
      return false;

    while (bigCount > 0 && goal >= 5) {
      goal -= 5;
      bigCount--;
    }

    while (smallCount > 0 && goal > 0) {
      goal--;
      smallCount--;
    }

    return goal == 0;
  }
}
