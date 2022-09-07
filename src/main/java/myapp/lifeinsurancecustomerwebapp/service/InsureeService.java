package myapp.lifeinsurancecustomerwebapp.service;

import java.util.List;

import myapp.lifeinsurancecustomerwebapp.model.Insuree;

public interface InsureeService {

    List<Insuree> getAllInsurees();
    
    void saveInsuree(Insuree insuree);
    
    Insuree getInsureeById(long id);
    
    void deleteInsureeById(long id);
	
}