package myapp.lifeinsurancecustomerwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import myapp.lifeinsurancecustomerwebapp.model.Insuree;
import myapp.lifeinsurancecustomerwebapp.repository.InsureeRepository;

import java.util.List;

@Service
public class InsureeServiceImpl implements InsureeService {

	@Autowired
	private InsureeRepository insureeRepository;

	@Override
	public List<Insuree> getAllInsurees() {
		return insureeRepository.findAll();
    }
	
	@Override
	public void saveInsuree(Insuree insuree) {
		this.insureeRepository.save(insuree);
	}
	
	@Override
	public void deleteInsureeById(long id) {
		this.insureeRepository.deleteById(id);
	}

	
	public Insuree getInsureeById(long id) {
		java.util.Optional<Insuree> optional = insureeRepository.findById(id);
		Insuree insuree = null;
		if(optional.isPresent()) {
			insuree = optional.get();
		} else {
			throw new RuntimeException(" Insuree not found for id :: " + id);
		}
		return insuree;
	}
}