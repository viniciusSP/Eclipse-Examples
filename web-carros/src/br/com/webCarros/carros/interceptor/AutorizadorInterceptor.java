package br.com.webCarros.carros.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


//Al�m de configurarmos o Interceptor no xml do spring temos que extender nossa classe
//do HandlerInterceptorAdapter para termos os metodos de reescrita
//preHandler significa o que faz antes na sess�o
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {
		
//		Estamos declarando aqui a url requirida em uma String para efetuarmos o IF
		String uri = request.getRequestURI();
		if (uri.endsWith("login") || uri.endsWith("efetuaLogin") || uri.contains("resources")) {
			return true;
		}
		
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		
//		Se a URI n�o satisfaz nenhuma condi��o acima (de pagia de login) vou retornar false
//		e mand�lo para a pagina de login novamente
//		isso bloqueia usuarios para acesso indevido sem login no meu sistema
		response.sendRedirect("login");
		return false;
	}
}
