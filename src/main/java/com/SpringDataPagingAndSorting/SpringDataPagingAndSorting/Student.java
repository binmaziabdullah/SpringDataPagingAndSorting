package com.SpringDataPagingAndSorting.SpringDataPagingAndSorting;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Student {
    @Id
    private Long id;
    private String name;
    private String address;
    private Integer marks;

}
