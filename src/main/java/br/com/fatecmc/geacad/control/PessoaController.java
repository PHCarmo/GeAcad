/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmc.geacad.control;

import br.com.fatecmc.geacad.model.dao.IDAO;
import br.com.fatecmc.geacad.model.dao.PessoaDAO;
import br.com.fatecmc.geacad.model.domain.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PessoaController", urlPatterns = {"/Pessoa"})
public class PessoaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        int cpf = Integer.parseInt(request.getParameter("cpf"));
        String email = request.getParameter("email");
        Date data_nascimento = new Date(request.getParameter("dt_nsc"));
        String sexo = request.getParameter("sexo");
        Pessoa pessoa = new Pessoa(nome, rg, cpf, email, data_nascimento, sexo);
        IDAO dao = new PessoaDAO();
        dao.salvar(pessoa);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>GeAcad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Salvo com sucesso!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
