package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.Aluno;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.model.domain.Turma;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlunoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String status = request.getParameter("status");
        String ra =     request.getParameter("ra");
        int id_turma =  request.getParameter("turma") == null ? 
                0 : Integer.parseInt(request.getParameter("turma"));
        int id_pessoa = request.getParameter("pessoa") == null ? 
                0 : Integer.parseInt(request.getParameter("pessoa"));
        String nome =   request.getParameter("nome");
        String email =  request.getParameter("email");
        String rg =     request.getParameter("rg");
        String cpf =    request.getParameter("cpf");
        String data =   request.getParameter("datanasc");
        String sexo =   request.getParameter("sexo");
        int id_aluno =  request.getParameter("id") == null ? 
                0 : Integer.parseInt(request.getParameter("id"));
        
        Turma turma  = new Turma();
        turma.setId(id_turma);
        
        Date dt_nasc;
        try { dt_nasc = new SimpleDateFormat("yyyy-MM-dd").parse(data); }
        catch (ParseException ex) { return null; }
        
        Aluno aluno = new Aluno(status, ra, turma, id_pessoa, nome, rg, cpf, email, dt_nasc, sexo, id_aluno);
        return aluno;
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
