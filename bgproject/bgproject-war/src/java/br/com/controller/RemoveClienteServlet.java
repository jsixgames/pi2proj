package br.com.controller;

import br.com.classes.Login;
import br.com.interfaces.CadastroClienteRemote;
import br.com.interfaces.LoginRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "RemoveClienteServlet", urlPatterns = {"/RemoveClienteServlet"})
public class RemoveClienteServlet extends HttpServlet {

    @EJB
    private LoginRemote loginRemote;
    private CadastroClienteRemote clienteRemote;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();                    
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = (String)session.getAttribute("emailLogado");
        String senha = (String) session.getAttribute("senhaLogado");
        try {
            if (request.getParameter("btn-encsim") != null && request.getParameter("btn-encsim").equals("Sim, tenho")) {
                try {                                        
                    Login x = new Login(email,senha); 
                    loginRemote.buscarCadastro(x);
//                    clienteRemote.remover(x);
                    session.invalidate();
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (Exception e) {                                        
                    out.println("Problema ao excluir o usuario, provavel problema no glassfish");
//                    request.getRequestDispatcher("painel.jsp").forward(request, response);                    
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