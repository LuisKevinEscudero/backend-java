package com.example.ej7.crudvalidation.person.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonPage
{
    private int pageNumber=0;
    private int pageSize=10;
    private Sort.Direction sortDirection = Direction.ASC;
    private String sortBy="name";
}
