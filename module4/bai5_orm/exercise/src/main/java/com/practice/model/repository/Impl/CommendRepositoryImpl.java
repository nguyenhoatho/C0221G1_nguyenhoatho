package com.practice.model.repository.Impl;

import com.practice.model.bean.Commend;
import com.practice.model.repository.ICommendRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommendRepositoryImpl implements ICommendRepository {

    @Override
    public List<Commend> findAll() {
        String queryStr = "SELECT c FROM Commend c";
        TypedQuery<Commend> query = BaseRepository.entityManager.createQuery(queryStr, Commend.class);
        return query.getResultList();
    }

    @Override
    public void save(Commend comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            comment.setLikeCount(0);
            session.saveOrUpdate(comment);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Commend update(Commend comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Commend origin = findById(comment.getId());
            origin.setRating(comment.getRating());
            origin.setAuthor(comment.getAuthor());
            origin.setMessage(comment.getMessage());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Commend like(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Commend comment = findById(id);
            comment.setLikeCount(comment.getLikeCount()+1);
            session.saveOrUpdate(comment);
            transaction.commit();
            return comment;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Commend findById(Long id) {
        String queryStr = "SELECT c FROM Commend c WHERE c.id = :id";
        TypedQuery<Commend> query = BaseRepository.entityManager.createQuery(queryStr, Commend.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
