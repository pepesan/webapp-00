package com.cursosdedesarrollo.app;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Registration {
    Integer id;
    Integer age;
    String first;
    String last;

    public Registration(Integer id, Integer age, String first, String last) {
        this.id = id;
        this.age = age;
        this.first = first;
        this.last = last;
    }

}
