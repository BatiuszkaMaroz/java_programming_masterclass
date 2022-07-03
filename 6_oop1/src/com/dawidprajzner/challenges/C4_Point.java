package com.dawidprajzner.challenges;

class Point {
  private int x;
  private int y;

  public Point() {

  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public double distance(int x0, int y0) {
    int a = Math.abs(x - x0);
    int b = Math.abs(y - y0);

    double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    return c;
  }

  public double distance() {
    return distance(0, 0);
  }

  public double distance(Point p) {
    return distance(p.getX(), p.getY());
  }
}

public class C4_Point {
}