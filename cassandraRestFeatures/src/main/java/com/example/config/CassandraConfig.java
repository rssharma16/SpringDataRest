package com.example.config;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.context.annotation.PropertySource;import org.springframework.core.env.Environment;import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;import org.springframework.data.cassandra.config.SchemaAction;import org.springframework.data.cassandra.convert.CassandraConverter;import org.springframework.data.cassandra.convert.MappingCassandraConverter;import org.springframework.data.cassandra.core.CassandraOperations;import org.springframework.data.cassandra.core.CassandraTemplate;import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;import org.springframework.data.cassandra.mapping.CassandraMappingContext;import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;/** * Created by rahul.sharma on 4/20/16. */@Configuration@PropertySource(value = {"classpath:cassandra.properties"})@EnableCassandraRepositories(basePackages = {"com.example.repositories"})public class CassandraConfig {    @Autowired    Environment environment;    @Bean    public CassandraClusterFactoryBean cluster()    {        CassandraClusterFactoryBean cassandraClusterFactoryBean = new CassandraClusterFactoryBean();        cassandraClusterFactoryBean.setContactPoints(environment.getProperty("cassandra.contactpoints"));        cassandraClusterFactoryBean.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));        return cassandraClusterFactoryBean;    }    @Bean    public CassandraConverter converter()    {        return new MappingCassandraConverter(mappingContext());    }    @Bean    public CassandraMappingContext mappingContext() {        return new BasicCassandraMappingContext();    }    @Bean    public CassandraSessionFactoryBean session() throws Exception {        CassandraSessionFactoryBean cassandraSessionFactoryBean = new CassandraSessionFactoryBean();        cassandraSessionFactoryBean.setCluster(cluster().getObject());        cassandraSessionFactoryBean.setKeyspaceName(environment.getProperty("cassandra.keyspace"));        cassandraSessionFactoryBean.setConverter(converter());        cassandraSessionFactoryBean.setSchemaAction(SchemaAction.NONE);        return cassandraSessionFactoryBean;    }    @Bean    public CassandraOperations cassandraTemplate() throws Exception {        return new CassandraTemplate(session().getObject());    }}