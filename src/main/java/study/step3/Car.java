package study.step3;

import org.apache.commons.lang3.StringUtils;

public class Car {

  private int position;

  private String path;

  public Car() { }

  public Car(int position) {
    this.position = position;
  }

  public int curPosition() {
    return position;
  }

  public String curPath() {
    return this.path;
  }

  public void move(int conditionNumber) {
    if (isMove(conditionNumber)) {
      this.position +=  + 1;
      this.path = StringUtils.isEmpty(this.path) ? "-" : this.path + "-";
    }
  }

  public boolean isMove(int conditionNumber) {
    if (conditionNumber > 3) {
      return true;
    }

    return false;
  }

}
