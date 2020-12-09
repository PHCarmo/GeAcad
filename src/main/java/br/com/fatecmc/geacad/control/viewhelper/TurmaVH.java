package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.Curso;
import br.com.fatecmc.geacad.model.domain.Turma;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.util.ParameterParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TurmaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String descricao = request.getParameter("descricao");
        Date data_inic =   ParameterParser.toDate(request.getParameter("datainicio"));
        int id_curso =     ParameterParser.toInt(request.getParameter("curso"));
        int id_turma =     ParameterParser.toInt(request.getParameter("id"));
        
        Curso curso  = new Curso();
        curso.setId(id_curso);
                
        Turma turma = new Turma(descricao, data_inic, curso, id_turma);
        return turma;
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/geacad/ListTurma.xhtml");
    }
    
}
