package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.Curso;
import br.com.fatecmc.geacad.model.domain.Turma;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TurmaVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String descricao = request.getParameter("descricao");
        String data =      request.getParameter("datainicio");
        int id_curso =     request.getParameter("curso") == null ? 
                0 : Integer.parseInt(request.getParameter("curso"));
        int id_turma =     request.getParameter("turma") == null ? 
                0 : Integer.parseInt(request.getParameter("turma"));
        
        Curso curso  = new Curso();
        curso.setId(id_curso);
        
        Date data_inic;
        try { data_inic = new SimpleDateFormat("yyyy-MM-dd").parse(data); }
        catch (ParseException ex) { return null; }
        
        Turma turma = new Turma(descricao, data_inic, curso, id_turma);
        return turma;
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
