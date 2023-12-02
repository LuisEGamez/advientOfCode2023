package com.aoc.year2023.day1;

import com.aoc.LineReader;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Day1_1 {

  public static void main(String[] args) {

    LineReader lineReader = new LineReader("src/main/java/com/aoc/year2023/day1/Day1.txt");

    int total = lineReader
      .getLines()
      .map(String::toCharArray)
      .map(chars -> {
        List<Integer> integers = new ArrayList<>();
        for (char c : chars) {
          if (Character.isDigit(c)) {
            integers.add(Character.getNumericValue(c));
          }
        }
        return integers;
      })
      .map(Day1_1::calculateResult)
      .mapToInt(Integer::intValue)
      .sum();

    System.out.println(total);

  }

  private static @NotNull Integer calculateResult(
    @NotNull List<Integer> integers
  ) {
    if (integers.size() > 1) {
      return (integers.get(0) * 10) + integers.get(integers.size() - 1);
    } else if (integers.size() == 1) {
      return (integers.get(0) * 10) + integers.get(0);
    } else {
      return 0;
    }
  }

}
