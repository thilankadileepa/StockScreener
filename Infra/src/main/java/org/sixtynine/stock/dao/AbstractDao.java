package org.sixtynine.stock.dao;

import org.hibernate.criterion.Criterion;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author Thilanka
 *
 * @param <E>
 * @param <I>
 */
@Transactional(readOnly = true)
public interface AbstractDao<E, I extends Serializable> {

    E findById(I id);
    E findById(I id, Class<E> clazz);
    void saveOrUpdate(E e);
    void delete(E e);
    List<E> findByCriteria(Criterion criterion);
    List<E> findByCriteria(Criterion criterion, Class<E> clazz);
    List<E> findByCriteria(Class<E> clazz, Criterion... criterion);
    List<E> findAll(Class<E> clazz);
}
