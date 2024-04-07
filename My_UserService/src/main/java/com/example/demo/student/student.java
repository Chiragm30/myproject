package com.example.demo.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class student {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
  private int sid;
  private String sname;
  private String saddr;
  private String smono;
  
  @Lob
  private byte imagedata;

}
