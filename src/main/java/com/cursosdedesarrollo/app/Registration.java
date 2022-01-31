package com.cursosdedesarrollo.app;

import java.util.Objects;

public class Registration {
    private Integer id;
    private Integer age;
    private String first;
    private String last;

    public Registration() {
        this.id = 0;
        this.age = 0;
        this.first = "";
        this.last = "";
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAge(), that.getAge()) && Objects.equals(getFirst(), that.getFirst()) && Objects.equals(getLast(), that.getLast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAge(), getFirst(), getLast());
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", age=" + age +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
