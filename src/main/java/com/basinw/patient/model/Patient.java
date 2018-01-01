package com.basinw.patient.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


/*
 * @Entity used for tell that is model class
 *
 * @Table used for tell name of table
 *        it will created
 */
@Entity
@Table(name = "patientss")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {

  /*
   * @Id spectific that is field of table's id
   *
   * @GeneratedValue(strategy = GenerationType.IDENTITY) used for auto increment id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "hospital_number")
  private int hospitalNumber;

  /*
   * by default attribute will be first_name in database
   * you can modify it by @Column
   */
  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  public int getHospitalNumber() {
    return hospitalNumber;
  }

  public void setHospitalNumber(int hospitalNumber) {
    this.hospitalNumber = hospitalNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return String.format("Patient: [hospitalNumber=%s, firstName=%s, lastName=%s]", hospitalNumber, firstName, lastName);
  }
}
