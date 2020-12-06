package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.Curso;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CursoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String nome =      request.getParameter("nome");
        String turno =     request.getParameter("turno");
        String descricao = request.getParameter("descricao");
        int duracao =      request.getParameter("duracao") == null ? 
                0 : Integer.parseInt(request.getParameter("duracao"));
        int id_curso =     request.getParameter("id") == null ? 
                0 : Integer.parseInt(request.getParameter("id"));
        
        Curso curso = new Curso(nome, turno, descricao, duracao, id_curso);
        return curso;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if (resultado != null) {
            out.println(resultado);
        } else {
            out.println("<h1>Operação realizada com sucesso cadastrado!</h1>");
        }
    }
    
}
