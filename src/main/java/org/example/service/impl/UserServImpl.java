package org.example.service.impl;

import org.example.config.HibernateConf;
import org.example.model.User;
import org.example.service.UserService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserServImpl implements UserService {
    private static final SessionFactory SESSION_FACTORY = HibernateConf.getSessionFactory();

    @Override
    public void save(User user) {
        try {
            Session session = SESSION_FACTORY.openSession();
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        // SESSION_FACTORY.close();
    }

    @Override
    public User findById(Long id) {
        User user = null;
        try {
            Session session = SESSION_FACTORY.openSession();
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        SESSION_FACTORY.close();
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User updateById(Long id, User newUser) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try {
            Session session = SESSION_FACTORY.openSession();
            session.beginTransaction();
            session.remove(session.get(User.class, id));
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        SESSION_FACTORY.close();
    }
}
