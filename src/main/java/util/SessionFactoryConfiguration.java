package util;

import entity.*;
import org.hibernate.SessionFactory;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguration {

        private static SessionFactoryConfiguration sessionFactoryConfiguration;
        private SessionFactory sessionFactory;

        public SessionFactoryConfiguration() {
            Configuration configuration=new Configuration().configure().
                    addAnnotatedClass(UserEntity.class)
                    .addAnnotatedClass(CustomerEntity.class)
                    .addAnnotatedClass(CarEntity.class)
                    .addAnnotatedClass(CarCategoriEntity.class)
                    .addAnnotatedClass(RentEntity.class);
            sessionFactory=configuration.buildSessionFactory();
        }

        public static  SessionFactoryConfiguration getInstance(){
            if (sessionFactoryConfiguration==null){
                sessionFactoryConfiguration=new SessionFactoryConfiguration();
            }else {}return sessionFactoryConfiguration;
        }
        public Session getSession(){
            return sessionFactory.openSession();
        }
    }


