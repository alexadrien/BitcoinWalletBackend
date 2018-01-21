package io.swagger;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import io.swagger.model.Transaction;
import java.math.BigDecimal;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"io.swagger", "io.swagger.api"})
public class Swagger2SpringBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {

//        MongoClient mongoClient = new MongoClient();
//        MongoDatabase database = mongoClient.getDatabase("bitcoinwallet");
//        MongoCollection<Document> coll = database.getCollection("transactions");
//        coll.drop();

//        Block<Document> block = new Block<Document>() {
//            @Override
//            public void apply(final Document document) {
//                System.out.println(document.toJson());
//            }
//        };
//        coll.find(eq("owner", "acube")).forEach(block);
//        Transaction t = new Transaction();
//        t.setOwner("woody");
//        t.setTimestamp("oulaa");
//        t.setBtc(Double.parseDouble("23.56"));
//        t.setUsd(Double.parseDouble("23.56"));
//        t.setType(Boolean.TRUE);
//        new MongoDB().insertOneTransation(t);
//        new MongoDB().getAllTransactionsFromNickname("woody");


        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {

        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
