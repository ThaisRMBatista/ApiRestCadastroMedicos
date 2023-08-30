package med.voll.api.services;

import med.voll.api.domain.DTO.DoctorDTO;
import med.voll.api.domain.DTO.ListDoctorDTO;
import med.voll.api.domain.DTO.UpdateDoctorDTO;
import med.voll.api.domain.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor createDoctors(DoctorDTO doctorDTO) {
        return repository.save(new Doctor(doctorDTO));

    }

    public Page<ListDoctorDTO> getAllDoctors(Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(ListDoctorDTO::new);
    }

    public void updateDoctor(UpdateDoctorDTO doctorDTO) {
        Doctor doctor = repository.getReferenceById(doctorDTO.getId());
        doctor.updateData(doctorDTO);
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = repository.getReferenceById(id);
        doctor.remove();
    }
}
