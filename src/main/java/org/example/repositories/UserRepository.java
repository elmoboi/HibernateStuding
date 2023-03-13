package org.example.repositories;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserRepository {
    private final Session session;

    public UserRepository(Session session) {
        this.session = session;
    }

    public void createUser(String login, String password) {
        session.beginTransaction();
        User createdUser = new User();
        createdUser.setLogin(login);
        createdUser.setPassword(password);
        session.persist(createdUser);
        session.getTransaction().commit();
    }

    public User getUserById(Integer id) {
        User get = session.get(User.class, id);
        return get;
    }

    public void updateUserLogin(Integer id,String login) {
        session.beginTransaction();
        User get = session.get(User.class, id);
        get.setLogin(login);
        session.getTransaction().commit();
    }

    public Integer deleteUserById(Integer id) {
        session.beginTransaction();
        User get = session.get(User.class, id);
        session.delete(get);
        session.getTransaction().commit();
        return id;
    }

    public User getUserRoleById(Integer id) {
        session.beginTransaction();
        String hql = "select login, userRole from User where id = :id";
        Query<User> query = session.createQuery(hql);
        query.setParameter("id", id);
        User user = query.uniqueResult();
        return user;
    }
}
