public class Main {
    public static void main(String[] args) {
        exam01();
    }

    static void exam01()  {   //articleLength 변수 생성, for문을 이용해서 NPE 회피 --> 리모델링 필요
        int articleLength = 0 ;
        Article[] articles = new Article[10];

        articles[0] = new Article();
        articleLength++;
        articles[1] = new Article();
        articleLength++;
        articles[2] = new Article();
        articleLength++;
        articles[3] = new Article();
        articleLength++;
        articles[4] = new Article();
        articleLength++;
        articles[5] = new Article();
        articleLength++;

        for(int i = 0 ; i < articleLength; i++ ) {
            Article article = articles[i];
            System.out.println(article.id);
        }
    }
}

class Article {
        static int lastId;
        int id;

        static {
            lastId = 0;
        }

        Article() {
            this(lastId + 1);
            lastId++;
        }

        Article(int id) {
            this.id = id;
        }
}
