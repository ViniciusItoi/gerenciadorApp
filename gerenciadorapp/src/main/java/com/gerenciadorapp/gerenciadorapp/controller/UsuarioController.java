package com.gerenciadorapp.gerenciadorapp.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gerenciadorapp.gerenciadorapp.model.ArquivoModel;
import com.gerenciadorapp.gerenciadorapp.model.UsuarioModel;
import com.gerenciadorapp.gerenciadorapp.repository.ArquivoRepository;
import com.gerenciadorapp.gerenciadorapp.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private ArquivoRepository ArqRep;
	@Autowired
	private UsuarioRepository UserRep;
	
	@RequestMapping(value = "/cadastrarUsuario", method=RequestMethod.GET)
	public String form() {
		return "usuario/formUsuario";
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method=RequestMethod.POST)
	public String insertForm(UsuarioModel usuario) {
		if(usuario.getIsAdm()==null) {
			usuario.setIsAdm(false);
		}
		UserRep.save(usuario);
		return "redirect:/usuarios";
	}
	
	@RequestMapping("/usuarios")
	public ModelAndView listarUsuarios() {
		ModelAndView modelView = new ModelAndView("/usuario/indexUsuario.html");
		Iterable<UsuarioModel> usuarios = UserRep.findAll();
		modelView.addObject("usuarios",usuarios);
		return modelView;
	}
	
	@RequestMapping(value="/detalheUsuario" ,params="id")
	public ModelAndView detalhesUsuario(@RequestParam(required = true) long id) {
		ModelAndView modelView = new ModelAndView("/usuario/detalhesUsuario.html");
		modelView.addObject(UserRep.findById(id));
		return modelView;
	}
	
	@Transactional
	@RequestMapping(value = "/removerUsuario", params = "id",method = RequestMethod.POST)
	public String removerUsuario(@RequestParam(required = true) long id) {
		UserRep.deleteById(id);
		return "redirect:/usuarios";
	}
	
	@RequestMapping(value = "/editarUsuario", method = RequestMethod.POST)
	public String updateForm(UsuarioModel usuario) {
		UserRep.save(usuario);
		return "redirect:/usuarios";
	}
}
