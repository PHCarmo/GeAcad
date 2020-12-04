package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.Professor;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfessorVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String exemplo = request.getParameter("example");
        
        Professor professor = new Professor();
        return professor;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if (resultado != null) {
            out.println(resultado);
        } else {
            out.println("<h1>Operação realizada com sucesso cadastrado!</h1>");
        }
    }
    
}