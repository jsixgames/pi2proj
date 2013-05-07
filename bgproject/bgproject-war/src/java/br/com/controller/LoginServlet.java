package br.com.controller;

import br.com.interfaces.LoginRemote;
import br.com.modelos.Login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @EJB
    private LoginRemote loginRemote;
    private boolean logado = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter("btn_login") != null && request.getParameter("btn_login").equals("Logar")) {
                try {

                    Login user = new Login(request.getParameter("email"),
                            request.getParameter("senha"));
                    
                    if(user.getEmail().equals("admin@admin.com") && user.getSenha().equals("admin")){
                        logado = true;
                        session.setAttribute("verificalog", isLogado());                    
                        request.getRequestDispatcher("paineladmin.jsp").forward(request, response);                        
                    }else{

                    if (loginRemote.buscarEmail(user) == true) {  
                        logado = true;
                        session.setAttribute("username", loginRemote.buscarNome(user));
                        session.setAttribute("emailLogado", request.getParameter("email"));                        
                        session.setAttribute("senhaLogado", request.getParameter("senha"));
                        session.setAttribute("verificalog", isLogado());
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        
                    } else {
                        logado = false;
                        session.setAttribute("verificalog", isLogado());
                        request.getRequestDispatcher("loginError.jsp").forward(request, response);                        
                    }     
                    
                    }                                   
                   
                } catch (Exception e) {
                    out.println("Erro no loginServlet");
                } finally {
                    out.close();
                }               
            }
            if (request.getParameter("btn_logout") != null && request.getParameter("btn_logout").equals("Logout")) {
                try {
                    if(session.getAttribute("verificalog") == (Object) true){                        
                        session.invalidate();
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    out.println("Erro no loginServlet");
                } finally {
                    out.close();
                }   
            }
        }finally {
            out.close();
        }
    }
    public boolean isLogado() {
        return logado;
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
