package com.gerenciadorapp.gerenciadorapp.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gerenciadorapp.gerenciadorapp.model.ArquivoModel;
import com.gerenciadorapp.gerenciadorapp.repository.ArquivoRepository;
import com.gerenciadorapp.gerenciadorapp.repository.UsuarioRepository;

@Controller
public class ArquivoController {

	@Autowired
	private ArquivoRepository arqRep;
	@Autowired
	private UsuarioRepository userRep;

	@RequestMapping(value = "/cadastrarArquivo", method = RequestMethod.GET)
	public String form() {
		return "arquivo/formArquivo";
	}

	@RequestMapping(value = "/cadastrarArquivo", method = RequestMethod.POST)
	public String insertForm(ArquivoModel arquivo) {
		arqRep.save(arquivo);
		return "redirect:/arquivos";
	}

	@RequestMapping("/arquivos")
	public ModelAndView listaArquivos() {
		ModelAndView modelView = new ModelAndView("arquivo/indexArquivo");
		Iterable<ArquivoModel> arquivos = arqRep.findAll();
		modelView.addObject("arquivos", arquivos);
		return modelView;
	}

	@RequestMapping(value = "/detalhesArquivo", params = "id")
	public ModelAndView detalhesArquivo(@RequestParam(required = true) long id) {
		ModelAndView modelView = new ModelAndView("/arquivo/detalhesArquivo.html");
		ArquivoModel arquivo = arqRep.findById(id);
		System.out.println(arquivo.getNome());
		modelView.addObject("arquivo",arquivo);
		return modelView;
	}
	
	@Transactional
	@RequestMapping(value = "/removerArquivo", params = "id",method = RequestMethod.POST)
	public String removerArquivo(@RequestParam(required = true) long id) {
		arqRep.deleteById(id);
		return "redirect:/arquivos";
	}
	
	@RequestMapping(value = "/editarArquivo", method = RequestMethod.POST)
	public String updateForm(ArquivoModel arquivo) {
		arqRep.save(arquivo);
		return "redirect:/arquivos";
	}
}
