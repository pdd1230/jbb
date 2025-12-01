package com.woori.BAM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.printf("cmd) ");
            String cmd = sc.next();
            System.out.println("명령어) " + cmd);
//            if (cmd == "exit") {   // 주소값이 값은지
//                break;
//            }

            if (cmd.equals("exit")) { //cmd 객체의 값이 "exit" 같은지
                break;                //반복문을 빠져나감
            }
        }

        System.out.println("== 프로그램 종료 ==");
    }

}
