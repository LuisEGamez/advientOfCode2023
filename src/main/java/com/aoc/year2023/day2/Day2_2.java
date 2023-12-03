package com.aoc.year2023.day2;

import com.aoc.LineReader;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Day2_2 {


  public static void main(String[] args) {

    LineReader lineReader = new LineReader("src/main/java/com/aoc/year2023/day2/Day2.txt");

    int total = lineReader
      .getLines()
      .map(string -> string.split(":"))
      .map(gameIdAndSets -> {

        // Get all sets from setsAsString
        String setsAsString = gameIdAndSets[1];

        String[] arrayOfSet = setsAsString.split(";");

        StringBuilder sb = new StringBuilder();

        List<Integer> redCubes = new ArrayList<>();
        List<Integer> greenCubes = new ArrayList<>();
        List<Integer> blueCubes = new ArrayList<>();

        for (String set : arrayOfSet) {

          String[] arrayOfCubes = set.split(",");

          for (String cube : arrayOfCubes) {

            if (cube.contains("red")) {

              getNumberOfCubes(cube, sb);

              int numberOfRedCubes = Integer.parseInt(sb.toString());

              redCubes.add(numberOfRedCubes); // Add the number of red cubes

              sb.setLength(0);
            }

            if (cube.contains("green")) {

              getNumberOfCubes(cube, sb);

              int numberOfGreenCubes = Integer.parseInt(sb.toString());

              greenCubes.add(numberOfGreenCubes); // Add the number of green cubes

              sb.setLength(0);
            }

            if (cube.contains("blue")) {

              getNumberOfCubes(cube, sb);

              int numberOfBlueCubes = Integer.parseInt(sb.toString());

              blueCubes.add(numberOfBlueCubes); // Add the number of blue cubes

              sb.setLength(0);
            }

          }


        }
        int maxOfRedCubes = redCubes
          .stream()
          .mapToInt(Integer::intValue)
          .max()
          .orElse(1); // return the max number of red cubes 1 if there are no red cubes

        int maxOfGreenCubes = greenCubes
          .stream()
          .mapToInt(Integer::intValue)
          .max()
          .orElse(1);

        int maxOfBlueCubes = blueCubes
          .stream()
          .mapToInt(Integer::intValue)
          .max()
          .orElse(1);

        return maxOfBlueCubes * maxOfGreenCubes * maxOfRedCubes;

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
