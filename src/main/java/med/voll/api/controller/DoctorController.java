package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.DTO.DoctorDTO;
import med.voll.api.domain.DTO.ListDoctorDTO;
import med.voll.api.domain.Doctor;
import med.voll.api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    @Transactional
    public Doctor createDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        return service.createDoctors(doctorDTO);
    }

    @GetMapping
    public Page<ListDoctorDTO> listAllDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return service.getAllDoctors(pageable);
    }

}
