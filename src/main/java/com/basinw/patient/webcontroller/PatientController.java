package com.basinw.patient.webcontroller;

import com.basinw.patient.model.Patient;
import com.basinw.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("patient")
@Transactional(readOnly = false, rollbackFor = Exception.class,
      isolation = Isolation.READ_COMMITTED)
public class PatientController {

  private PatientRepository patientRepo;

  @Autowired
  public PatientController(PatientRepository patientRepo) {
    this.patientRepo = patientRepo;
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public String create() {
    return "patient/create";
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String create(Patient patient) {
    patientRepo.add(patient);
    return "patient/created";
  }
}
