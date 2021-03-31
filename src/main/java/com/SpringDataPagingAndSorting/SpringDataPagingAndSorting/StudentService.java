package com.SpringDataPagingAndSorting.SpringDataPagingAndSorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String updateStudents(Student student){
        if (student.getId() != null) {
            Optional<Student> studentOptional = studentRepository.findById(student.getId());
            if (!studentOptional.isPresent())
                return "student details not found!";
        }
        studentRepository.save(student);
        return "Operation performed!";
    }

    public List<Student> getStudentBySortingAndPagination(Integer currentPage, Integer size, String sort){

        PageRequest paged = PageRequest.of(currentPage, size, Sort.by(sort).ascending());
        Page<Student> pageResult = studentRepository.findAll(paged);

        if (pageResult.hasContent())
           return pageResult.getContent();
        else
            return new ArrayList<Student>();
    }

    /*public List<Student> getByPagingOnly(Integer currentPageNo, Integer pageSize){
        Pageable pageable = PageRequest.of(currentPageNo, pageSize);
        Page page = studentRepository.findAll(pageable);
        if (page.hasContent())
            return page.getContent();
        else
            return new ArrayList<Student>();
    }*/


}
