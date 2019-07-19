package com.ygor.javahibernate.repository;

import com.ygor.javahibernate.model.Post;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PostRepository {

    private EntityManager entityManager;

    public PostRepository() {
        this.entityManager = getEntityManager();
    }

    public Post getById(int id) {
        return entityManager.find(Post.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Post> getAll() {
        return entityManager.createQuery("FROM " + Post.class.getName()).getResultList();
    }

    public Post create(Post post) throws HibernateException{
        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();

        return post;
    }

    public void update(Post post) throws HibernateException {
        entityManager.getTransaction().begin();
        entityManager.merge(post);
        entityManager.getTransaction().commit();
    }

    public void remove(int id) throws HibernateException {
        Post post = entityManager.find(Post.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(post);
        entityManager.getTransaction().commit();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HibernateExample");

        return (entityManager == null) ? factory.createEntityManager() : entityManager;
    }
}