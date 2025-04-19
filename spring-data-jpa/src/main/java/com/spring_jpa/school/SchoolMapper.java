package com.spring_jpa.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    /**
     * Converts a SchoolDTO object to a School entity.
     *
     * @param dto the SchoolDTO object containing the data to be transformed
     * @return a School entity populated with the data from the provided SchoolDTO
     */
    public School toSchool(SchoolDTO dto) {
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
    public SchoolResponseDTO toSchoolResponseDTO(School school) {
        return new SchoolResponseDTO(school.getName(), school.getAddress(), school.getEmail());
    }
}
