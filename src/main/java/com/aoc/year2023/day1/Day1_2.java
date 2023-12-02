package com.aoc.year2023.day1;

import com.aoc.LineReader;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day1_2 {
  public static void main(String[] args) {

    LineReader lineReader = new LineReader("src/main/java/com/aoc/year2023/day1/Day1.txt");

    Map<String, Integer> map = Map
      .of("one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight", 8,
        "nine", 9
      );

    int total = lineReader
      .getLines()
      .map(String::toCharArray)
      .map(chars -> {
        List<Integer> result = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {

          if (Character.isDigit(chars[i])) {
            result.add(Character.getNumericValue(chars[i]));
          } else {

            number.append(chars[i]);

            for (int j = i + 1; j < chars.length; j++) {

              number.append(chars[j]);

              if (map.containsKey(number.toString())) {
                result.add(map.get(number.toString()));
                number.setLength(0);
                break;
              }
            }

            number.setLength(0);

          }
        }
        return result;
      })
      .map(Day1_2::calculateResult)
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
