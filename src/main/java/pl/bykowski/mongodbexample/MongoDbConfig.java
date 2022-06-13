package pl.bykowski.mongodbexample;

import com.github.javafaker.Faker;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MongoDbConfig {

    private MongoTemplate mongoTemplate;
    private ArticleRepo articleRepo;

    public MongoDbConfig(MongoTemplate mongoTemplate, ArticleRepo articleRepo) {
        this.mongoTemplate = mongoTemplate;
        this.articleRepo = articleRepo;
    }

//    @Transactional
    public void tryAddElement() {
        Faker fakerHC = new Faker();
        Article articleHC = new Article();
        articleHC.setAuthor("Przemek");
        articleHC.setTitle("NoSQL");
        Comment comment1HC = new Comment();
        comment1HC.setText(fakerHC.chuckNorris().fact());
        Comment comment2HC = new Comment();
        comment2HC.setText(fakerHC.chuckNorris().fact());
        articleHC.setCommentList(Arrays.asList(comment1HC, comment2HC));
        articleRepo.save(articleHC);
        System.out.println(10/0);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        // Przemek
        Faker fakerHC = new Faker();
        Article articleHC = new Article();
        articleHC.setAuthor("Przemek");
        articleHC.setTitle("NoSQL");
        Comment comment1HC = new Comment();
        comment1HC.setText(fakerHC.chuckNorris().fact());
        Comment comment2HC = new Comment();
        comment2HC.setText(fakerHC.chuckNorris().fact());
        articleHC.setCommentList(Arrays.asList(comment1HC, comment2HC));
        articleRepo.save(articleHC);

        Article article1 = articleRepo.findArticleByTitle("NoSQL").get();
        System.out.println(article1.getCommentList() + " " + article1.getAuthor());


        int index = 0;
        while (index < 10) {
            Faker faker = new Faker();
            Article article = new Article();
            article.setAuthor(faker.gameOfThrones().character());
            article.setTitle(faker.book().title());

            Comment comment1 = new Comment();
            comment1.setText(faker.chuckNorris().fact());
            Comment comment2 = new Comment();
            comment2.setText(faker.chuckNorris().fact());

            article.setCommentList(Arrays.asList(comment1, comment2));

            mongoTemplate.insert(article);
            index++;
        }

        List<Article> all = mongoTemplate.findAll(Article.class);

        Query query = new Query((Criteria.where("author").is("Przemek")));
        List<Article> byPrzemek = mongoTemplate.find(query, Article.class, "article");
        System.out.println("by Przemek: " + byPrzemek);
        System.out.println("wszystkie: " + all);
    }

}
