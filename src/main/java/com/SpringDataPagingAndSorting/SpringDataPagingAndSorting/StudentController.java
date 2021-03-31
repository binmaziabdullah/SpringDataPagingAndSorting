package com.SpringDataPagingAndSorting.SpringDataPagingAndSorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public String addStudents(@RequestBody Student student){
         return studentService.updateStudents(student);

    }

    @GetMapping
    public List<Student> getStudentByPagingAndSorting(@RequestParam(defaultValue = "0") Integer currentPage,
                                                      @RequestParam(defaultValue = "3") Integer size,@RequestParam(defaultValue = "name") String sort){
        return studentService.getStudentBySortingAndPagination(currentPage,size,sort);
    }

    //if you want pagination only so you can do that in this way
    /*@GetMapping
    public List<Student> getPagingOnly(@RequestParam(defaultValue = "0") Integer currentPageNo,
                                       @RequestParam(defaultValue = "3") Integer pageSize){
        return studentService.getByPagingOnly(currentPageNo,pageSize);
    }*/
}
