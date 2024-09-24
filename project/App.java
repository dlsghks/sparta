package project;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;


        while (continueCalculation) {
            System.out.print("첫 번째 숫자를 입력하세요 (0 포함 양의 정수): ");
            int num1 = scanner.nextInt();


            System.out.print("연산자를 입력하세요 (+, -, *, /): ");
            char operator = scanner.next().charAt(0);


            System.out.print("두 번째 숫자를 입력하세요 (0 포함 양의 정수): ");
            int num2 = scanner.nextInt();


            double result = calculator.calculate(num1, num2, operator);
            System.out.println("결과: " + result);


            System.out.print("계산을 이어가시겠습니까? (Y/N): ");
            char response = scanner.next().charAt(0);


            if (response != 'Y' && response != 'y') {
                continueCalculation = false;
            }
            System.out.print("가장 먼저 저장된 결과를 삭제하시겠습니까? (Y/N): ");
            char deleteResponse = scanner.next().charAt(0);

            if (deleteResponse == 'Y' || deleteResponse == 'y') {
                calculator.removeFirstResult();
            }
        }


        System.out.println("모든 연산 결과: " + calculator.getResultHistory());


        scanner.close();
    }
}
