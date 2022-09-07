package myapp.lifeinsurancecustomerwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import myapp.lifeinsurancecustomerwebapp.model.Insuree;
import myapp.lifeinsurancecustomerwebapp.service.InsureeService;

@Controller
public class InsureeController {

    @Autowired
    private InsureeService insureeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listInsurees", insureeService.getAllInsurees());
        return "index";
    }
    
    @GetMapping("/showNewInsureeForm")
    public String showNewInsureeForm(Model model) {
    	Insuree insuree = new Insuree();
    	model.addAttribute("insuree", insuree);
    	return "new_insuree";
    }
    
    @PostMapping("/saveInsuree")
	public String saveInsuree(@ModelAttribute("insuree") Insuree insuree) {
		// save insuree to database
		insureeService.saveInsuree(insuree);
		return "redirect:/";
	}
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value="id") long id, Model model) {
    	
    	Insuree insuree = insureeService.getInsureeById(id);
    	
    	model.addAttribute("insuree", insuree);
    	return "update_insuree";
    	
    }
    
    @GetMapping("/deleteInsuree/{id}")
    public String deleteInsuree(@PathVariable (value="id") long id) {
    	
    	this.insureeService.deleteInsureeById(id);
    	return "redirect:/";
    	
    }
}
