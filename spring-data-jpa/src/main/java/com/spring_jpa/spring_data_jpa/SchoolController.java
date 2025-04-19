package com.spring_jpa.spring_data_jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolResponseDTO create(@RequestBody SchoolDTO schoolDTO) {
        var school = toSchool(schoolDTO);
        var schoolSaved = schoolRepository.save(school);
        return toSchoolResponseDTO(schoolSaved);
    }

    /**
     * Converts a SchoolDTO object to a School entity.
     *
     * @param dto the SchoolDTO object containing the data to be transformed
     * @return a School entity populated with the data from the provided SchoolDTO
     */
    private School toSchool(SchoolDTO dto) {
        var school = new School();
        school.setName(dto.name());
        school.setAddress(dto.address());
        school.setEmail(dto.email());
        school.setPhone(dto.phone());
        return school;
    }

    /**
     * Converts a School entity to a SchoolResponseDTO.
     *
     * @param school the School entity to be converted
     * @return a SchoolResponseDTO containing the name, address, and email of the school
     */
    private SchoolResponseDTO toSchoolResponseDTO(School school) {
        return new SchoolResponseDTO(school.getName(), school.getAddress(), school.getEmail());
    }

    /**
     * Retrieves all schools from the repository and converts them to a list of SchoolResponseDTOs.
     *
     * @return a list of SchoolResponseDTO objects representing all schools
     */
    @GetMapping("/schools")
    public List<SchoolResponseDTO> findAll() {
        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolResponseDTO)
                .collect(Collectors.toList());
    }
}
