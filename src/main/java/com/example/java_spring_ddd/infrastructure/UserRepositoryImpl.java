package com.example.java_spring_ddd.infrastructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<UserEntity> search(Map<String, String> query, Pageable pageable) {
        System.out.println("Search called with query: " + query + " and pageable: " + pageable);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        if (query.containsKey("id")) {
            try {
                UUID id = UUID.fromString(query.get("id"));
                predicates.add(cb.equal(root.get("id"), id));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid UUID format for id: " + query.get("id"));
            }
        }

        cq.where(predicates.toArray(new Predicate[0]));

        cq.orderBy(QueryUtils.toOrders(pageable.getSort(), root, cb));

        TypedQuery<UserEntity> queryApplied = entityManager.createQuery(cq);

        queryApplied.setFirstResult((int) pageable.getOffset());
        queryApplied.setMaxResults(pageable.getPageSize());

        List<UserEntity> resultList = queryApplied.getResultList();

        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<UserEntity> countRoot = countQuery.from(UserEntity.class);
        countQuery.select(cb.count(countRoot)).where(predicates.toArray(new Predicate[0]));
        Long total = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(resultList, pageable, total);
    }
}