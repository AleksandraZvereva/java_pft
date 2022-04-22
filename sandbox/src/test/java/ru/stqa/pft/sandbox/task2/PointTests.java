package ru.stqa.pft.sandbox.task2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void distance(){

    Point p1 = new Point(10.0, 15.0);
    Point p2 = new Point(12.0, 18.0);

    Assert.assertEquals(p1.distance(p2), 3.605551275463989);
  }

  @Test
  public void distanceWithNegativeNumbers(){

    Point p1 = new Point(-10.0, -15.0);
    Point p2 = new Point(-12.0, -18.0);

    Assert.assertEquals(p2.distance(p1), 3.605551275463989);
  }

  @Test
  public void distanceEqualsP1P2(){
    Point p1 = new Point(12.5, 10.4);
    Point p2 = new Point(2.4, 18.7);

    Assert.assertEquals(p1.distance(p2), p2.distance(p1));
  }

  @Test
  public void distanceWithZeros(){
    Point p1 = new Point(0.0, 0.0);
    Point p2 = new Point(0.0, 0.0);

    assert p2.distance(p1) == 0;
  }
}
