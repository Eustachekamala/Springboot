package com.spring_jpa.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }


    //To create a school
    public SchoolResponseDTO addSchool(SchoolDTO schoolDTO) {
        var school = schoolMapper.toSchool(schoolDTO);
        var schoolSaved = schoolRepository.save(school);
        return schoolMapper.toSchoolResponseDTO(schoolSaved);
    }

    //To Get all the Schools
    public List<SchoolResponseDTO> findAllSchool(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * Finds a school by its ID and updates its details with the provided SchoolDTO.
     *
     * @param id the ID of the school to be updated
     * @param schoolDTO the SchoolDTO containing the updated details
     * @return a SchoolResponseDTO with the updated school details, or null if the school is not found
     */
    public SchoolResponseDTO updateSchool(Integer id, SchoolDTO schoolDTO) {
        return schoolRepository.findById(id)
                .map(existingSchool -> {
                    existingSchool.setName(schoolDTO.name());
                    existingSchool.setAddress(schoolDTO.address());
                    existingSchool.setEmail(schoolDTO.email());
                    existingSchool.setPhone(schoolDTO.phone());
                    var updatedSchool = schoolRepository.save(existingSchool);
                    return schoolMapper.toSchoolResponseDTO(updatedSchool);
                })
                .orElse(null);
    }
}
