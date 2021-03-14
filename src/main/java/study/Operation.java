package study;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
  PLUS("+", (num1, num2) -> num1 + num2),
  MINUS("-", (num1, num2) -> num1 - num2),
  MULTIPLY("*", (num1, num2) -> num1 * num2),
  DIVIDE("/", (num1, num2) -> num1 / num2);

  private final String operator;
  private final BiFunction<Double, Double, Double> expression;

  Operation(String operator, BiFunction<Double, Double, Double> expression) {
    this.operator = operator;
    this.expression = expression;
  }

  public static Operation getOperation(String operator) {
    return Arrays.stream(values())
        .filter(operations -> operations.operator.equals(operator))
        .findFirst()
        .get();
  }

  public double calculate(double num1, double num2) {
    return this.expression.apply(num1, num2);
  }

  public static double calculate(String operator, double num1, double num2) {
    Operation operation = getOperation(operator);

    return operation.calculate(num1, num2);
  }

}
