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
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> dataQuery = cb.createQuery(UserEntity.class);
        Root<UserEntity> dataRoot = dataQuery.from(UserEntity.class);
        List<Predicate> dataPredicates = buildPredicates(query, dataRoot, cb);
        dataQuery.where(dataPredicates.toArray(new Predicate[0]));
        dataQuery.orderBy(QueryUtils.toOrders(pageable.getSort(), dataRoot, cb));
        TypedQuery<UserEntity> typedQuery = entityManager.createQuery(dataQuery);
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());
        List<UserEntity> resultList = typedQuery.getResultList();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<UserEntity> countRoot = countQuery.from(UserEntity.class);
        List<Predicate> countPredicates = buildPredicates(query, countRoot, cb);
        countQuery.select(cb.count(countRoot)).where(countPredicates.toArray(new Predicate[0]));
        Long total = entityManager.createQuery(countQuery).getSingleResult();
        return new PageImpl<>(resultList, pageable, total);
    }

    private List<Predicate> buildPredicates(Map<String, String> query, Root<UserEntity> root, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (query.containsKey("id")) {
            try {
                UUID id = UUID.fromString(query.get("id"));
                predicates.add(cb.equal(root.get("id"), id));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid UUID format for id: " + query.get("id"));
            }
        }
        return predicates;
    }
}