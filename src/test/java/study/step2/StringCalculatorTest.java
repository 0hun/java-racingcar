package study.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

  StringCalculator calculator;

  @BeforeEach
  void initCalculator() {
    calculator = new StringCalculator();
  }

  @DisplayName("단순 입력 문자열 계산")
  @Test
  void stringCalculate() {
    // given
    String calculateExpression = "2 + 3";

    // when
    double result = calculator.calculate(calculateExpression);

    // then
    assertThat(result).isEqualTo(5);
  }

  @DisplayName("입력 문자열 잘라서 계산")
  @Test
  void splitStringCalculate() {
    // given
    String calculateExpression = "2 + 3 * 4 / 2";

    // when
    double result = calculator.calculate(calculateExpression);

    // then
    assertThat(result).isEqualTo(10);
  }

  @DisplayName("입력 값이 null이거나, 공백일때 예외 테스트")
  @Test
  void expressionIsEmptyOrIsNull() {
    // given
    String calculateExpression = " ";

    // when
    Throwable thrown = catchThrowable(() -> {
      calculator.calculate(calculateExpression);
    });

    // then
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("입력 값이 여러개 일때, 묶어서 테스트하여 0보다 큰지")
  @ParameterizedTest
  @ValueSource(strings = {"2 + 3 * 4 / 2", "3 + 5 * 2 / 4"})
  void expressionParameterizedGreaterThanZero(String calculateExpression) {
    //when
    double result = calculator.calculate(calculateExpression);

    // then
    assertThat(result).isGreaterThan(0);
  }

}