package com.furkanpinar.framework.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicConnectionUtil {

    public void getConnection(DR_Connection connection) {
        Map properties = new HashMap<>();
        properties.put("hibernate.connection.driver_class", connection.getDriverClass());
        properties.put("hibernate.connection.url", connection.getUrl());
        properties.put("hibernate.connection.username", connection.getUsername());
        properties.put("hibernate.connection.password", connection.getPassword());
        properties.put("hibernate.dialect", connection.getDialect());
        properties.put("hibernate.show-sql", "true");
        properties.put("connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
        properties.put("hibernate.c3p0.acquire_increment", "1");
        properties.put("hibernate.c3p0.idle_test_period", "60");
        properties.put("hibernate.c3p0.min_size", "1");
        properties.put("hibernate.c3p0.max_size", "2");
        properties.put("hibernate.c3p0.max_statements", "50");
        properties.put("hibernate.c3p0.timeout", "0");
        properties.put("hibernate.c3p0.acquireRetryAttempts", "1");
        properties.put("hibernate.c3p0.acquireRetryDelay", "250");

        properties.put("hibernate.use_sql_comments", "true");

        properties.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
        properties.put("hibernate.current_session_context_class", "thread");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DynamicConnectionUnit", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager;
    }
}
