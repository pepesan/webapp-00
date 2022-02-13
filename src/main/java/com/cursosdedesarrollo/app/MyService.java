package com.cursosdedesarrollo.app;


import java.util.Objects;

public class MyService {
    private String data;
    public MyService(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyService myService = (MyService) o;
        return Objects.equals(getData(), myService.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData());
    }

    @Override
    public String toString() {
        return "MyService{" +
                "data='" + data + '\'' +
                '}';
    }
}
