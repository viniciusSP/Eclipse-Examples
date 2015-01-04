package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {

		long tempoInicial = System.currentTimeMillis();

		fc.doFilter(req, res);

		long tempoFinal = System.currentTimeMillis();

		String uri = ((HttpServletRequest) req).getRequestURI();
		String parametros = ((HttpServletRequest) req).getParameter("logica");
		System.out.println("Tempo de requisicao de " + uri + "?logica="
				+ parametros + " demorou (ms): " + (tempoFinal - tempoInicial));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
