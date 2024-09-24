package project;
import java.util.ArrayList;
import java.util.List;

public class Calculator {


    private List<Double> resultHistory = new ArrayList<>();


    public double calculate(int num1, int num2, char operator) {
        double result = 0;


        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / (double) num2;
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return 0;
                }
                break;
            default:

                System.out.println("유효하지 않은 연산자입니다.");
                return 0;
        }


        resultHistory.add(result);

        return result;
    }

  List<Double> getResultHistory() {
        return resultHistory;
    }


    public void setResultHistory(List<Double> resultHistory) {
        this.resultHistory = resultHistory;
    }

    public void removeFirstResult() {
        if (!resultHistory.isEmpty()) {
            resultHistory.remove(0);
            System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 연산 결과가 없습니다.");
        }
    }
}
