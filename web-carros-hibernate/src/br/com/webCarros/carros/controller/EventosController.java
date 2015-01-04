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
	
	//Página com formulário para adicionar novo veículo
	@RequestMapping("adicionaCarro")
	public String novoCarro() {
		return "actions/adicionaCarro";
	}
	//Controller que vem da action do Form do adicionaVeiculo
	@RequestMapping("adicionandoCarro")
	
	//Annotation @Valid para o Bean Validation da minha classe Modelo
	//BindingResult é necessário para guardar os resultados de erros de validação
	public String adicionaCarro(@Valid Carro carro, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			//Se no objeto result tiver erros de validação, retorne para o formulário
			return "actions/adicionaCarro";
		}
		
//		INATIVO DEVIDO A INJECAO DE DEPENDENCIAS
//		CarroDAO dao = new CarroDAO();
		dao.adiciona(carro);
		return "returns/carroAdicionado";
	}
	
	//ListaCarros recebe um Objeto do tipo Model onde eu adiciono atributos recebidos 
	//Neste exemplo estou mandando meu objeto carros(lista) com o nome de "carros"
	//esse atributo será pego na pagina pela Expression Language na pagina ${carros}
	//fazendo um laço de forEach eu consigo listar meus objetos na página
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
