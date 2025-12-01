package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");
        Scanner sc = new Scanner(System.in);

        int id = 1;

        List<Article> articles = new ArrayList<>();  // 변수 articles 의 타입은 --> 제너릭 <article>
                                                     // ArrayList --> List를 구현하는 구현 class

        while (true) {
            System.out.printf("cmd) ");
            String cmd = sc.nextLine().trim();
            System.out.println("명령어) " + cmd);

            if (cmd.length() == 0) {
                System.out.println("명령어를 입력해 주세요");
                continue;
            }

            if ( cmd.equals("article list")) {
                if (articles.size() == 0) {           // size() 공부,  누구의 메서드?
                     System.out.println("게시글이 없습니다");
                     continue;
                }

                System.out.println("번호  |   제목");
                for(int i = 0 ; i < articles.size() ; i++ ) {
                   Article article= articles.get(i);
                    System.out.printf("%d    |    %s\n" , article.id, article.title);
                }


            } else if (cmd.equals("article write")) {
                System.out.print("제목 :");
                String title = sc.nextLine();
                System.out.println("내용 :");
                String body = sc.nextLine();
                System.out.println(id + " 번글이 생성되었습니다");

                Article article = new Article();
                article.id = id;
                article.title = title;
                article.body = body;

                articles.add(article);
                id++;
            } else if (cmd.startsWith("article detail")) { //startswith() 특정 문자열로 문자열 시작? -> trus or false
                String[] cmdBits = cmd.split(" ");    //split(" ")  "  " 구분자로 문자열 분리해서 배열로 return
                System.out.println(cmdBits[0]);
                System.out.println(cmdBits[1]);
                System.out.println(cmdBits[2]);
            } else {
                System.out.println("존재하지 않는 명령어 입니다");
            }

            if (cmd.equals("exit")) {
                break;
            }

        }

        System.out.println("== 프로그램 종료 ==");
    }

}

class Article {

    int id;
    String title;
    String body;
}
