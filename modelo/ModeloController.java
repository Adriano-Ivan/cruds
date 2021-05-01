package com.demomvc.curso.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demomvc.curso.boot.domain.Modelo;
import com.demomvc.curso.boot.service.ModeloService;


@Controller
@RequestMapping("/modelos")
public class ModeloController {
	
	@Autowired //Injeção de dependência
	private ModeloService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Modelo modelo) {
		return "/modelo/cadastro";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(@Valid Modelo modelo, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "modelo/cadastro";
		}
		
		service.salvar(modelo);
		//Mensagem adicionada para exibir o resultado da transação cadastrar
		attr.addFlashAttribute("success", "Modelo "+modelo.getNome() +" inserido com sucesso.");
		return "redirect:/modelos/cadastrar";
	}
		
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("modelos",service.buscarTodos());
		return "modelo/lista";
	}
			
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("modelo",service.buscarPorId(id));
		return "/modelo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Modelo modelo, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "modelo/cadastro";
		}
		
		service.editar(modelo);
		//Mensagem adicionada para exibir o resultado da transação editar
		attr.addFlashAttribute("success", "Modelo "+modelo.getNome() +" editado com sucesso.");
		return "redirect:/modelos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Long id, ModelMap model) {
		service.excluir(id);
		//Mensagem adicionada para exibir o resultado da transação excluir
		model.addAttribute("success", "Modelo removido com sucesso.");
		return listar(model);
	}
}
