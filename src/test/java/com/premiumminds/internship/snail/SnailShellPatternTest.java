package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };

  @Test
  public void ScreenLockinPatternTestEmptyMatrix()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { {} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = {};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst1Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst2Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2 }, { 8, 9 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 9, 8 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest4Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 1 },
                       { 4, 5, 6, 4 },
                       { 7, 8, 9, 7 },
                       { 7, 8, 9, 7 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 1, 4, 7, 7, 9, 8, 7, 7, 4, 5, 6, 9, 8 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest5Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 1, 6 },
                       { 4, 5, 6, 4, 0 },
                       { 7, 8, 9, 7, 1 },
                       { 7, 8, 9, 7, 2 },
                       { 1, 2, 3, 4, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 1, 6, 0, 1, 2, 5, 4, 3, 2, 1, 7, 7, 4, 5, 6, 4, 7, 7, 9, 8, 8, 9 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest6Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 1, 6, 1 },
                       { 4, 5, 6, 4, 0, 2 },
                       { 7, 8, 9, 7, 1, 3 },
                       { 7, 8, 9, 7, 2, 4 },
                       { 1, 2, 3, 4, 5, 5 },
                       { 1, 2, 3, 4, 5, 6 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 1, 6, 1 ,2,3,4,5,6,5,4,3,2,1,1,7,7,4,5,6,4,0,1,2,5,4,3,2,8,8,9,7,7,9};
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest7Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 1, 6, 1 ,0},
                       { 4, 5, 6, 4, 0, 2 ,1},
                       { 7, 8, 9, 7, 1, 3 ,2},
                       { 7, 8, 9, 7, 2, 4 ,3},
                       { 1, 2, 3, 4, 5, 5 ,4},
                       { 1, 2, 3, 4, 5, 6 ,5},
                       { 9, 8, 7, 6, 5, 4, 3} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 1, 6, 1 ,0,1,2,3,4,5,3,4,5,6,7,8,9,1,1,7,7,4,5,6,4,0,2,3,4,5,6,5,4,3,2,2,8,8,9,7,1,2,5,4,3,9,7};
    assertArrayEquals(result, expected);
  }
}