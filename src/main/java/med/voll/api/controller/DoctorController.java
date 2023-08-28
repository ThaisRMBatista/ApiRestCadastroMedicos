package med.voll.api.controller;

import med.voll.api.domain.DTO.DoctorDTO;
import med.voll.api.domain.Doctor;
import med.voll.api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    public Doctor createDoctor(@RequestBody DoctorDTO doctorDTO) {
        return service.createDoctors(doctorDTO);
    }
}
