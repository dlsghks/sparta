package project2;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("환영합니다! 야구 게임에 오신 것을 환영합니다.");
        System.out.println("1. 게임 시작");
        System.out.println("3. 게임 종료");


        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("메뉴를 선택하세요: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("게임을 시작합니다.");
                BaseballGame game = new BaseballGame();
                game.play();
            } else if (choice == 3) {
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
        sc.close();
    }
}


