package web.dao;



import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEm() {
        return this.em;
    }

    @Override
    public List<User> getAllUsers() {
        return getEm().createQuery("from User", User.class).getResultList();
    }


    @Override
    public User getById(Long id) {
        return getEm().find(User.class, id);
    }

    //save
    @Override
    public void add(User user) {
        getEm().persist(user);
    }

    //update
    @Override
    public void edit(User user) {
        getEm().merge(user);
    }

    //delete
    @Override
    public void remove(Long id) {
        User user = getEm().find(User.class, id);
        getEm().remove(user);
    }
}
