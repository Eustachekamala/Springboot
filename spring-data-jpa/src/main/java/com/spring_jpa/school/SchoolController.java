package com.spring_jpa.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolResponseDTO create(@RequestBody SchoolDTO schoolDTO) {
        return schoolService.addSchool(schoolDTO);
    }

    /**
     * Retrieves all schools from the repository and converts them to a list of SchoolResponseDTOs.
     *
     * @return a list of SchoolResponseDTO objects representing all schools
     */
    @GetMapping("/schools")
    public List<SchoolResponseDTO> findAll() {
       return schoolService.findAllSchool();
    }

    @PatchMapping("/schools/{id}")
    public SchoolResponseDTO update(@PathVariable Integer id, @RequestBody SchoolDTO schoolDTO) {
        return schoolService.updateSchool(id, schoolDTO);
    }
}
