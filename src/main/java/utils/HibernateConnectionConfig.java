package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnectionConfig {
    private static final SessionFactory sessionFactory;

    private HibernateConnectionConfig() {}

    static {
        Configuration configuration = new Configuration();
        configuration.configure(); // load properties from hibernate.cfg.xml
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}

