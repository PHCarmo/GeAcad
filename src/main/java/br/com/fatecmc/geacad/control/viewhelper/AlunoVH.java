package br.com.fatecmc.geacad.control.viewhelper;

import br.com.fatecmc.geacad.model.domain.Aluno;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.model.domain.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlunoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        String data = request.getParameter("datanasc");
        Date dt_nasc = null;
        try {
            dt_nasc = new SimpleDateFormat("yyyy-MM-dd").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(AlunoVH.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Pessoa pessoa = new Pessoa(nome, rg, cpf, email, dt_nasc, sexo);
        //Aluno aluno = new Aluno();
        return pessoa;
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
