package med.voll.api.services;

import med.voll.api.domain.DTO.DoctorDTO;
import med.voll.api.domain.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor createDoctors(DoctorDTO doctorDTO) {
        return repository.save(new Doctor(doctorDTO));

    }
}
