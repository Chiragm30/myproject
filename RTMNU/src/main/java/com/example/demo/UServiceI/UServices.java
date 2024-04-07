package com.example.demo.UServiceI;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.University;


public interface UServices {

public University upost(University u);

public List<University> UgetList();

public University Uupdate(Integer uid, University u);

public void Udelete(Integer uid);
}
