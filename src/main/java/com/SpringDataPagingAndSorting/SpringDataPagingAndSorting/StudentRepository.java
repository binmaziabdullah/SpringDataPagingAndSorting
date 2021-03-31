package com.SpringDataPagingAndSorting.SpringDataPagingAndSorting;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
}
