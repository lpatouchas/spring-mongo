package gr.patouchas.spring.mongo.poc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories(basePackages = {"gr.patouchas.spring.mongo.poc.repositories"})
@ComponentScan(basePackages = "gr.patouchas.spring.mongo.poc.repositories")
public class SpringMongoConfig {

	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		final SimpleMongoDbFactory factory = new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "dbtest");
		factory.setWriteConcern(WriteConcern.ACKNOWLEDGED);
		return factory;
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {
		final MongoTemplate mongoTemplate = new MongoTemplate(this.mongoDbFactory());
		return mongoTemplate;
	}

}
