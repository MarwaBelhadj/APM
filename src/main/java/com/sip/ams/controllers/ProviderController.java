package com.sip.ams.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.ams.entities.Provider;
import com.sip.ams.repository.ProviderRepository;

@Controller
@RequestMapping("/provider")
public class ProviderController {

	private final ProviderRepository providerRepository;

	@Autowired   //Pourquoi on a mis cette annotation
	public ProviderController(ProviderRepository providerRepository) {
		
		this.providerRepository = providerRepository;
	}
	
	@GetMapping("/list")// ce que je tape dans l'url
	public String listProviders(Model model) {
		
		model.addAttribute("providers",providerRepository.findAll());
		return"provider/listProviders"; //retourne la vue de listproviders.html
	}
	
	@GetMapping("/add")
	public String showAddProviderForm(Model model) {
		
		Provider provider = new Provider();
		model.addAttribute("provider",provider);
		return"provider/addProvider";
	}
	
	@PostMapping("/add")
	public String addProvider(@Valid Provider provider, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return"provider/addProvider";
		}
		providerRepository.save(provider);
		return "redirect:list"; //c'estv pour rafréchir la liste?
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProvider(@PathVariable("id") long id, Model model) {
	
		Provider provider = providerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invald provider Id :" +id));
		System.out.println("suite du programme ...");
		providerRepository.delete(provider);
		return"redirect:list"; //j'ai pas compris cette redirection
	}
	@GetMapping("/edit/{id}")
	public String editProvider(@PathVariable("id") long id, Model model) {
		Provider provider = providerRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid provider Id :"+id));
		model.addAttribute("provider",provider);
		return"provider/updateProvider";
	}
	@PostMapping("/update")
	public String updateProvider(@Valid Provider provider, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return"provider/updateProvider";
		}
		providerRepository.save(provider);
		return "redirect:list"; 
	}
}