package com.demomvc.curso.boot.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demomvc.curso.boot.domain.Departamento;
import com.demomvc.curso.boot.domain.Marca;
import com.demomvc.curso.boot.domain.Modelo;
import com.demomvc.curso.boot.domain.Produto;
import com.demomvc.curso.boot.service.MarcaService;
import com.demomvc.curso.boot.service.ModeloService;
import com.demomvc.curso.boot.service.ProdutoService;
import com.demomvc.curso.boot.util.PaginacaoUtil;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ModeloService modeloService;
	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Produto produto) {
		return "/produto/cadastro";
	}
	
	/*
	@GetMapping("/listar")
	public String listar(ModelMap model, 
			 @RequestParam("page") Optional<Integer> page, 
			 @RequestParam("dir") Optional<String> dir) {
		
		int paginaAtual = page.orElse(1);
		String ordem = dir.orElse("asc");		
		
		PaginacaoUtil<Produto> pageProduto = produtoService.buscarPorPagina(paginaAtual, ordem);
		model.addAttribute("pageProduto", pageProduto);
		return "/produto/lista";
	}
	*/
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("produtos", produtoService.buscarTodos());
		return "produto/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Produto produto, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "produto/cadastro";
		}
		
		produtoService.salvar(produto);
		attr.addFlashAttribute("success", "Produto inserido com sucesso.");
		return "redirect:/produtos/cadastrar";
	}
	
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("produto", produtoService.buscarPorId(id));
		return "/produto/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Produto produto, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "produto/cadastro";
		}	
		
		produtoService.editar(produto);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/produtos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Long id, ModelMap model) {
		produtoService.excluir(id);
		//Mensagem adicionada para exibir o resultado da transação excluir
		model.addAttribute("success", "Produto removido com sucesso.");
		return "redirect:/produtos/listar";
	}
	
	@ModelAttribute("marcas")
	public List<Marca> listaDeMarcas() {
		return marcaService.buscarTodos();
	}	
	
	@ModelAttribute("modelos")
	public List<Modelo> listaDeModelos() {
		return modeloService.buscarTodos();
	}	
	

}
