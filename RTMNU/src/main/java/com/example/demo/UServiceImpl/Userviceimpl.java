package com.example.demo.UServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.University;
import com.example.demo.UServiceI.UServices;
import com.example.demo.Urepository.RepositoryU;

@Service
public class Userviceimpl implements UServices {

	@Autowired
	RepositoryU urs;
	
	@Override
	public University upost(University u) 
	      {
	         return	urs.save(u);
          }

	@Override
	public List<University> UgetList() {
		
		return urs.findAll();
		
	}

	@Override
	public University Uupdate(Integer uid, University u) {
		  Optional<University> un=urs.findByUid(uid);
		  if (un.isPresent()) {
			  University unv=un.get();
			  unv.setUid(u.getUid());
			  unv.setUname(u.getUname());
			  unv.setUaddr(u.getUaddr());
			  unv.setCollege(u.getCollege());;
			  unv.setUcode(u.getUcode());
			  return urs.save(unv);
			
		} else {
               return null;
		}
	}

	@Override
	public void Udelete(Integer uid) {
		urs.deleteById(uid);
	}

}
