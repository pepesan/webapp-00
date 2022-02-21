package com.cursosdedesarrollo.app;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

}
