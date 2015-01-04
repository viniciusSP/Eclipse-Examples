package br.com.webCarros.carros.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.webCarros.carros.dao.LoginDAO;
import br.com.webCarros.carros.model.Login;

@Controller
public class LoginController {

	@RequestMapping("login")
	public String paginaDeLogin() {
		return "actions/login";
	}
	
//	Metodo efetua Login recebe um Objeto Login e a Interface HttpSession
//	Na Classe DAO temos um metodo existeUsuario que é um booleano
//	se ele for true nos colocamos na session o usuario para pegarmos ele na pagina q foi direcionada
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Login login, HttpSession session) throws SQLException, Exception {

		if (new LoginDAO().existeUsuario(login)) {
			session.setAttribute("usuarioLogado", login);
			return "menu";
		}
		return "redirect:login";
		
	}
	
//	O httpSession tem o metodo invalidate que invalida a sessão
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping("criaLogin")
	public String criaLogin(Login login) throws Exception {
		LoginDAO dao = new LoginDAO();
		dao.adiciona(login);
		return "returns/loginCriado";
	}
}
