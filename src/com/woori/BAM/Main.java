package com.woori.BAM;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");
        Scanner sc = new Scanner(System.in);
        int lastArticleID = 1;
        List<Article> articles = new ArrayList<>();

        while (true) {
            System.out.printf("cmd) ");
            String cmd = sc.nextLine().trim();

            if (cmd.length() == 0) {
                System.out.println("명령어를 입력해 주세요");
                continue;
            }
            if (cmd.equals("exit")) {
                break;
            }
            if (cmd.equals("article list")) {
                if (articles.size() == 0) {
                    System.out.println("게시글이 없습니다");
                    continue;
                }
                System.out.println("번호  |   제목   |  내용  |       regDate    |   조회수");
                for (int i = articles.size() - 1; i >= 0; i--) {
                    Article article = articles.get(i);
                    System.out.printf("%d    |    %s   |  %s  |   %s  |  %d\n", article.id, article.title, article.body, article.regDate , article.viewCnt );  //static 메서드 호출
                }
            } else if (cmd.equals("article write")) {
                System.out.print("제목 : ");
                String title = sc.nextLine();
                System.out.print("내용 : ");
                String body = sc.nextLine();
                System.out.println(lastArticleID + " 번글이 생성되었습니다");


                Article article = new Article(lastArticleID, title, body, Util.getDateStr(),0 ); // viewCnt --> write 실행, 저장 --> viewCnt --> 0 이다

                articles.add(article);
                lastArticleID++;
            } else if (cmd.startsWith("article detail")) {
                String[] cmdBits = cmd.split(" ");
                Article foundArticle = null;
                int id = 0;

                try {
                    id = Integer.parseInt(cmdBits[2]);

                } catch (NumberFormatException e) {
                    System.out.println("정수를 입력하시길 바랍니다");
                    continue;   // while 다시 실행해
                } catch (Exception e) {
                    //(그밖에 모든 Exception 변수명)
                }
                for (Article article : articles) {
                    if (article.id == id) {
                        foundArticle = article;   //search 성공시 article 객체를 --> foundArticle 대입 -->
                                                  //article.viewCnt --> 값이 0 --> 이유: 객체가 생성시 초기화 안되면 --> 무조건 초기값으로 저장
                        break;  //for문을 빠져나감
                    }
                }
                if (foundArticle == null) { //serarch 수행했으나 게시글이 없음
                    System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
                    continue; //while문을 다시 시작해라
                }

                foundArticle.viewCnt++;  // 객체의 viewCnt++ --> deatil ~ 실행이 되면 1씩 증가함

                // serach후 detail 내용 출력
                System.out.println("번호 : " + foundArticle.id);
                System.out.println("날짜 : " + foundArticle.regDate); //날짜 + 시간 출력
                System.out.println("제목 : " + foundArticle.title);
                System.out.println("내용 : " + foundArticle.body);
                System.out.println("조회수 : " + foundArticle.viewCnt);


            } else {
                System.out.println("존재하지 않는 명령어 입니다");
            }
        }
        System.out.println("== 프로그램 종료 ==");
    }
}

class Article {
    int id;
    String title;
    String body;
    String regDate;  // 필드 추가 --> yyyy-mm-dd hh:mm:ss
    int viewCnt;

    public Article(int lastArticleID, String title, String body, String regDate , int viewCnt) {
        this.id = lastArticleID;
        this.title = title;
        this.body = body;
        this.regDate = regDate;
        this.viewCnt = viewCnt;   // 필드 추가 , viewCnt
    }
}