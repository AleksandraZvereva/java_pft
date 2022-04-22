package ru.stqa.pft.sandbox.task2;

import ru.stqa.pft.sandbox.task2.Point;

public class PointImplementation {
  public static void main(String[] args) {

    Point p1 = new Point(2.6, 1.7);
    Point p2 = new Point(12.4, 3.6);
    System.out.println(p1.distance(p2));
    System.out.println(p2.distance(p1));

  }

}
