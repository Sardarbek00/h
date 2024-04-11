package org.example.config;
import org.hibernate.cfg.Configuration;
import org.example.model.Passport;
import org.example.model.User;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;



public class HibernateConf {
    public static SessionFactory getSessionFactory() {
SessionFactory sessionFactory=null;

try{
    Configuration configuration=new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
    .addAnnotatedClass(Passport.class);
    sessionFactory=configuration.buildSessionFactory();
}catch (SessionException e){
    System.out.println(e.getMessage());
}
        return sessionFactory;
    }
}
