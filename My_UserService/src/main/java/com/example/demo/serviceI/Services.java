package com.example.demo.serviceI;

import java.util.List;

import com.example.demo.student.student;

public interface Services {

 public	student poststu(student s);

 public List<student> getstu();

public student updatestu(Integer sid, student s);

public void deletestu(Integer sid);

}
