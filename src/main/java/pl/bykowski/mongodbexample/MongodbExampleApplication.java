package pl.bykowski.mongodbexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbExampleApplication.class, args);
    }

//    @Bean
//    public MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory mongoDatabaseFactory) {
//        return new MongoTransactionManager(mongoDatabaseFactory);
//    }

//    @Autowired
//    MongoDbConfig mongoDbConfig;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void get() {
//        mongoDbConfig.tryAddElement();
//    }
}
