package com.example;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.example.cassandra.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

@SpringBootApplication
public class SpringDataRestCass2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestCass2Application.class, args);
	}
    private static final Logger LOG = LoggerFactory.getLogger(SpringDataRestCass2Application.class);

    private static Cluster cluster;
    private static Session session;

    /*public static void main(String[] args) {
        //EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        final Cluster cluster = Cluster.builder().addContactPoints("127.0.0.1").withPort(9042).build();
        //cluster = Cluster.builder().addContactPoints(InetAddress.getLocalHost()).build();

        session = cluster.connect("example");

        CassandraOperations cassandraOps = new CassandraTemplate(session);

        cassandraOps.insert(new Person("1234567890", "David", 40));

        Select s = QueryBuilder.select().all().from("person");
        s.where(QueryBuilder.eq("id", "1234567890"));
        Person person = cassandraOps.selectOne(s, Person.class);
        LOG.info("Queried:"+person);
        //LOG.info(cassandraOps.queryForObject(s, Person.class).getId());

        cassandraOps.truncate("person");

    }*/

}
