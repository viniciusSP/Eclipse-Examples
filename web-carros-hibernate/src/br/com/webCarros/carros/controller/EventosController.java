package br.com.webCarros.carros.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.webCarros.carros.dao.CarroDAO;
import br.com.webCarros.carros.model.Carro;

@Transactional
@Controller
public class EventosController {

//	Criamos um atributo dao do tipo CarroDAO
	@Autowired
	private CarroDAO dao;
	
	//P�gina com formul�rio para adicionar novo ve�culo
	@RequestMapping("adicionaCarro")
	public String novoCarro() {
		return "actions/adicionaCarro";
	}
	//Controller que vem da action do Form do adicionaVeiculo
	@RequestMapping("adicionandoCarro")
	
	//Annotation @Valid para o Bean Validation da minha classe Modelo
	//BindingResult � necess�rio para guardar os resultados de erros de valida��o
	public String adicionaCarro(@Valid Carro carro, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			//Se no objeto result tiver erros de valida��o, retorne para o formul�rio
			return "actions/adicionaCarro";
		}
		
//		INATIVO DEVIDO A INJECAO DE DEPENDENCIAS
//		CarroDAO dao = new CarroDAO();
		dao.adiciona(carro);
		return "returns/carroAdicionado";
	}
	
	//ListaCarros recebe um Objeto do tipo Model onde eu adiciono atributos recebidos 
	//Neste exemplo estou mandando meu objeto carros(lista) com o nome de "carros"
	//esse atributo ser� pego na pagina pela Expression Language na pagina ${carros}
	//fazendo um la�o de forEach eu consigo listar meus objetos na p�gina
	@RequestMapping("listaCarros")
	public String listaCarros(Model model) throws Exception {
		
//		INATIVO DEVIDO A INJECAO DE DEPENDENCIAS
//		CarroDAO dao = new CarroDAO();
		
		List<Carro> carros = dao.lista();
		model.addAttribute("carros", carros);
		return "actions/listaCarros";
	}
	@RequestMapping("removeCarro")
	public String removeCarro(Carro carro) throws Exception {
		
//		INATIVO DEVIDO A INJECAO DE DEPENDENCIAS
//		CarroDAO dao = new CarroDAO();
		
		dao.remove(carro);
		
		return "forward:listaCarros";
	}
}
