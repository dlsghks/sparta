package project2;

import java.util.*;

public class BaseballGame {
    private final String answer;

    public BaseballGame() {
        this.answer = generateUniqueNumber();
    }


public void play() {
    Scanner sc = new Scanner(System.in);
    boolean gameOver = false;


    while (!gameOver) {
        System.out.println("숫자 3자리를 입력하세요: ");
        String answer = sc.nextLine();

        if (!validateInput(answer)) {
            System.out.println("올바르지 않은 입력값입니다.");
            continue;
        }

        int strikes = countStrike(answer);
        int balls = countBall(answer);


        displayHint(strikes, balls);

        if (strikes == 3) {
            System.out.println("정답입니다.");
            gameOver = true;
        }
    }
}

private String generateUniqueNumber() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
        numbers.add(i);
    }

    Collections.shuffle(numbers);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 3; i++) {
        sb.append(numbers.get(i));
    }
    return sb.toString();
}


protected boolean validateInput(String input) {
    if (input.length() != 3) return false;
    if (!input.matches("[0-9]*")) return false;
    Set<Character> digitsSet = new HashSet<>();
    for (char c : input.toCharArray()) {
        if (!digitsSet.add(c)) return false;
    }
    return true;
}


private int countStrike(String input) {
    int strikes = 0;
    for (int i = 0; i < 3; i++) {
        if (input.charAt(i) == answer.charAt(i)) {
            strikes++;
        }
    }
    return strikes;
}


private int countBall(String input) {
    int balls = 0;
    for (int i = 0; i < 3; i++) {
        if (answer.contains(String.valueOf(input.charAt(i))) && input.charAt(i) != answer.charAt(i)) {
            balls++;
        }
    }
    return balls;
}

private void displayHint(int strikes, int balls) {
    if (strikes == 0 && balls == 0) {
        System.out.println("아웃");
    } else {
        System.out.println(strikes + " 스트라이크, " + balls + " 볼");
    }
}
}
