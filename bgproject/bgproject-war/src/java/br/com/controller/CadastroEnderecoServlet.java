package br.com.controller;

import br.com.modelos.CadastroEndereco;
import br.com.modelos.MetodosGerais;
import br.com.interfaces.CadastroEnderecoRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastroEnderecoServlet", urlPatterns = {"/CadastroEnderecoServlet"})
public class CadastroEnderecoServlet extends HttpServlet {

    @EJB
    private CadastroEnderecoRemote enderecoRemote;    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            if (request.getParameter("btn-newend") != null && request.getParameter("btn-newend").equals("Cadastrar")) {
                try {
            
                    CadastroEndereco endereco = new CadastroEndereco();
                    endereco.setEndereco(request.getParameter("endereco"));
                    endereco.setNumero(request.getParameter("numero"));
                    endereco.setComplemento(request.getParameter("complemento"));
                    endereco.setCep(new MetodosGerais().tirardotecoma(request.getParameter("cep")));
                    endereco.setBairro(request.getParameter("bairro"));
                    endereco.setCidade(request.getParameter("cidade"));
                    endereco.setEmail((String) session.getAttribute("emailLogado"));
                    endereco.setEstado(request.getParameter("estado"));
                    endereco.setDescricaoEndereco(request.getParameter("descricao"));
                    enderecoRemote.salvar(endereco);
                    session.setAttribute("respnewend", true);
                    request.getRequestDispatcher("painel.jsp").forward(request, response);                    
                 
                           } catch (Exception e) {
                    session.setAttribute("respnewend", false);
                    request.getRequestDispatcher("respcadfail.jsp").forward(request, response);                    
                } 
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
