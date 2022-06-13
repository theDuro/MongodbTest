package pl.bykowski.mongodbexample;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepo extends MongoRepository<Article, String> {

    Optional<Article> findArticleByTitle(String title);
}
