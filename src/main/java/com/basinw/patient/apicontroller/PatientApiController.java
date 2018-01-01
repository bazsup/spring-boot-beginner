package com.basinw.patient.apicontroller;

import com.basinw.patient.model.Patient;
import com.basinw.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @RestController used for REST API this class
 *                and convert return data to JSON
 *                if you use `@Controller` you must use @@ResponseBody every method/function
 */
@RestController
@RequestMapping("/api/patients")
@Transactional(readOnly = false, rollbackFor = Exception.class,
          isolation = Isolation.READ_COMMITTED)
public class PatientApiController {

  private PatientRepository patientRepo;

  /*
   * @Autowired used for assign data
   *            that inject by @Autowired's constructor class.
   */
  @Autowired
  public PatientApiController(PatientRepository patientRepo) {
    this.patientRepo = patientRepo;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public int addPatient(@RequestBody Patient patient){
    patientRepo.add(patient);
    return patient.getHospitalNumber();
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Patient> getAllPatients() {
    return patientRepo.getAll();
  }

  @RequestMapping(value = "/{hospitalNumber}", method = RequestMethod.GET)
  public Patient getPatient(@PathVariable int hospitalNumber) {
    return patientRepo.get(hospitalNumber);
  }

  @RequestMapping(value = "/{hospitalNumber}", method = RequestMethod.PUT)
  public void updatePatient(@PathVariable int hospitalNumber,
                            @RequestBody Patient patientReq) {
    Patient patient = patientRepo.get(hospitalNumber);
    patient.setFirstName(patientReq.getFirstName());
    patient.setLastName(patientReq.getLastName());
  }

  @RequestMapping(value = "/{hospitalNumber}", method = RequestMethod.DELETE)
  public void removePatient(@PathVariable int hospitalNumber) {
    Patient patient = patientRepo.get(hospitalNumber);
    patientRepo.remove(patient);
  }

}
