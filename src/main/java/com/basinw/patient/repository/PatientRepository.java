package com.basinw.patient.repository;

import com.basinw.patient.model.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/*
 * @Repository used for `spring bean` know this class is a Repository
 */
@Repository
public class PatientRepository {

  /*
   * EntityManager is a class from JPA Hibernate that use for manage the entity class
   *              for get, getAll, remove, query data
   */

  @PersistenceContext
  private EntityManager entityManager;

  public Patient get(int hospitalNumber) {
    try {
      return entityManager.getReference(Patient.class, hospitalNumber);
    } catch (EntityNotFoundException err) {
      err.printStackTrace();
      return (Patient) new Object();
    }
  }

  public List<Patient> getAll(){
    // this query is a JPQL syntax
    Query query = entityManager.createQuery("SELECT p FROM Patient p",
            Patient.class);
    return query.getResultList();
  }

  public void add(Patient patient) {
    entityManager.persist(patient);
  }

  public void remove(Patient patient){
    entityManager.remove(patient);
  }
}
