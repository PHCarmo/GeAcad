package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.*;
import br.com.fatecmc.geacad.util.ParameterParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisciplinaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String nome =     request.getParameter("nome");
        int carga_hr =    ParameterParser.toInt(request.getParameter("cargahor"));
        String ementa =   request.getParameter("ementa");
        String objetivo = request.getParameter("objetivo");
        String bibliog =  request.getParameter("bibliog");
        int semestre =    ParameterParser.toInt(request.getParameter("semestre"));
        int id_curso =    ParameterParser.toInt(request.getParameter("curso"));
        int id_prof =     ParameterParser.toInt(request.getParameter("professor"));
        int id_disci =    ParameterParser.toInt(request.getParameter("id"));
        
        Curso curso  = new Curso();
        curso.setId(id_curso);
        Professor professor  = new Professor();
        professor.setId(id_prof);
        
        Disciplina disciplina = new Disciplina(nome, carga_hr, ementa, objetivo, bibliog, semestre, curso, professor, id_disci);
        return disciplina;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/geacad/ListTurma.xhtml");
    }
    
}
