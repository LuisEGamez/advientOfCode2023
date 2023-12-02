package com.aoc.aoc02;

import com.aoc.LineReader;
import org.jetbrains.annotations.NotNull;

public class Main {

  private static final @NotNull Integer RED_CUBE_MAX = 12;
  private static final @NotNull Integer GREEN_CUBE_MAX = 13;
  private static final @NotNull Integer BLUE_CUBE_MAX = 14;

  public static void main(String[] args) {

    LineReader lineReader = new LineReader("02.txt");

    int total = lineReader
      .getLines()
      .map(string -> string.split(":"))
      .map(gameIdAndSets -> {

        // Get all sets from setsAsString
        String setsAsString = gameIdAndSets[1];

        String[] arrayOfSet = setsAsString.split(";");

        boolean isValid = true;

        StringBuilder sb = new StringBuilder();

        for (String set : arrayOfSet) {

          String[] arrayOfCubes = set.split(",");

          for (String cube : arrayOfCubes) {

            if (cube.contains("red")) {

              getNumberOfCubes(cube, sb);

              int numberOfRedCubes = Integer.parseInt(sb.toString());

              if (numberOfRedCubes > RED_CUBE_MAX) {
                isValid = false;
                sb.setLength(0);
                break;
              }
              sb.setLength(0);
            }

            if (cube.contains("green")) {

              getNumberOfCubes(cube, sb);

              int numberOfGreenCubes = Integer.parseInt(sb.toString());

              if (numberOfGreenCubes > GREEN_CUBE_MAX) {
                isValid = false;
                sb.setLength(0);
                break;
              }
              sb.setLength(0);
            }

            if (cube.contains("blue")) {

              getNumberOfCubes(cube, sb);

              int numberOfBlueCubes = Integer.parseInt(sb.toString());

              if (numberOfBlueCubes > BLUE_CUBE_MAX) {
                isValid = false;
                sb.setLength(0);
                break;
              }
              sb.setLength(0);
            }

          }

          if (!isValid) {
            break;
          }
        }

        String gameId = gameIdAndSets[0];

        char[] charArray = gameId.toCharArray();

        int result = 0;

        if (isValid) {

          for (char c : charArray) {
            if (Character.isDigit(c)) {
              sb.append(c);
            }
          }
          result = Integer.parseInt(sb.toString());
        }


        return result;

      })
      .mapToInt(Integer::intValue)
      .sum();

    System.out.println(total);

  }

  private static void getNumberOfCubes(
    final @NotNull String cube,
    final @NotNull StringBuilder sb
  ) {
    char[] greenCubeArray = cube.toCharArray();
    for (char greenCube : greenCubeArray) {

      if (Character.isDigit(greenCube)) {
        sb.append(greenCube);
      }

    }
  }

}
