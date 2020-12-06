package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisciplinaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String nome =     request.getParameter("nome");
        int carga_hr =    request.getParameter("cargahor") == null ? 
                0 : Integer.parseInt(request.getParameter("cargahor"));
        String ementa =   request.getParameter("ementa");
        String objetivo = request.getParameter("objetivo");
        String bibliog =  request.getParameter("bibliog");
        int semestre =    request.getParameter("semestre") == null ? 
                0 : Integer.parseInt(request.getParameter("semestre"));
        int id_curso =    request.getParameter("curso") == null ? 
                0 : Integer.parseInt(request.getParameter("curso"));
        int id_prof =     request.getParameter("pessoa") == null ? 
                0 : Integer.parseInt(request.getParameter("pessoa"));
        int id_disci =    request.getParameter("id") == null ? 
                0 : Integer.parseInt(request.getParameter("id"));
        
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
        PrintWriter out = response.getWriter();
        if (resultado != null) {
            out.println(resultado);
        } else {
            out.println("<h1>Operação realizada com sucesso cadastrado!</h1>");
        }
    }
    
}
