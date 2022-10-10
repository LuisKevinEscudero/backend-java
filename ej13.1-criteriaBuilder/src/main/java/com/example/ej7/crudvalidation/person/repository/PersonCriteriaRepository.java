package com.example.ej7.crudvalidation.person.repository;

import com.example.ej7.crudvalidation.person.model.Person;
import com.example.ej7.crudvalidation.person.model.PersonPage;
import com.example.ej7.crudvalidation.person.model.PersonSearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonCriteriaRepository {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public PersonCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Person> findAllWithFilters(PersonPage personPage, PersonSearchCriteria personSearchCriteria)
    {
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);
        Predicate predicate = getPredicate(personSearchCriteria, personRoot);

        criteriaQuery.where(predicate);
        setOrder(personPage, criteriaQuery, personRoot);

        TypedQuery<Person> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(personPage.getPageNumber() * personPage.getPageSize());
        typedQuery.setMaxResults(personPage.getPageSize());

        Pageable pageable = getPageable(personPage);

        long personsCount = getPersonsCount(predicate);
        return new PageImpl<>(typedQuery.getResultList(), pageable, personsCount);
    }




    private Predicate getPredicate(PersonSearchCriteria personSearchCriteria, Root<Person> personRoot)
    {
        List<Predicate> predicates = new ArrayList<>();

        if(personSearchCriteria.getUsername() != null)
        {
            predicates.add(criteriaBuilder.like(personRoot.get("username"), "%" + personSearchCriteria.getUsername() + "%"));
        }
        if(personSearchCriteria.getName() != null)
        {
            predicates.add(criteriaBuilder.like(personRoot.get("name"), "%" + personSearchCriteria.getName() + "%"));
        }
        if(personSearchCriteria.getSurname() != null)
        {
            predicates.add(criteriaBuilder.like(personRoot.get("surname"), "%" + personSearchCriteria.getSurname() + "%"));
        }
        if(personSearchCriteria.getCreatedDate() != null)
        {
            if(personSearchCriteria.getCriteriaDate() != null)
            {
                if (personSearchCriteria.getCriteriaDate().equals("prev"))
                {
                    predicates.add(criteriaBuilder.equal(personRoot.get("createdDate"), personSearchCriteria.getCreatedDate()));
                }
            }
            else
            {
                predicates.add(criteriaBuilder.lessThan(personRoot.get("createdDate"), personSearchCriteria.getCreatedDate()));
            }

        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(PersonPage personPage, CriteriaQuery<Person> criteriaQuery, Root<Person> personRoot)
    {
        if (personPage.getSortDirection().equals(Sort.Direction.ASC))
        {
            criteriaQuery.orderBy(criteriaBuilder.asc(personRoot.get(personPage.getSortBy())));
        }
        else
        {
            criteriaQuery.orderBy(criteriaBuilder.desc(personRoot.get(personPage.getSortBy())));
        }
    }

    private Pageable getPageable(PersonPage personPage)
    {
        Sort sort = Sort.by(personPage.getSortDirection(), personPage.getSortBy());
        return PageRequest.of(personPage.getPageNumber(), personPage.getPageSize(), sort);
    }

    private long getPersonsCount(Predicate predicate)
    {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Person> countRoot = countQuery.from(Person.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}
