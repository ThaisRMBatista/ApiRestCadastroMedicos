package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.DTO.DetailsDoctosDTO;
import med.voll.api.domain.DTO.DoctorDTO;
import med.voll.api.domain.DTO.ListDoctorDTO;
import med.voll.api.domain.DTO.UpdateDoctorDTO;
import med.voll.api.domain.Doctor;
import med.voll.api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    @Transactional
    public ResponseEntity createDoctor(@RequestBody @Valid DoctorDTO doctorDTO, UriComponentsBuilder uriBuilder) {
        Doctor doctor = service.createDoctors(doctorDTO);

        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        DetailsDoctosDTO doctorDetailDTO = new DetailsDoctosDTO(doctor);
        return ResponseEntity.created(uri).body(doctorDetailDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ListDoctorDTO>> listAllDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<ListDoctorDTO> allDoctors = service.getAllDoctors(pageable);
        return ResponseEntity.ok(allDoctors);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity updateDoctor(@RequestBody @Valid UpdateDoctorDTO doctorDTO) {
        DetailsDoctosDTO doctor = service.updateDoctor(doctorDTO);
        return ResponseEntity.ok(doctor);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDoctor(@PathVariable Long id) {
        service.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detailDoctor(@PathVariable Long id) {
        Doctor doctor = service.detailDoctor(id);
        return ResponseEntity.ok(new DetailsDoctosDTO(doctor));
    }

}
