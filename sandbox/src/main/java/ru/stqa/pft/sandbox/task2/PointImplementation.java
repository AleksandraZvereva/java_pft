package ru.stqa.pft.sandbox.task2;

import ru.stqa.pft.sandbox.task2.Point;

public class PointImplementation {
  public static void main(String[] args) {

    Point p1 = new Point(2.6, 1.7);
    Point p2 = new Point(12.4, 3.6);
    System.out.println(distance(p1, p2));

  }
  public static double distance(Point p1, Point p2){
    return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
  }
}
