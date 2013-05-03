package br.com.controller;

import br.com.classes.MetodosGerais;
import br.com.interfaces.CadastroClienteRemote;
import br.com.modelos.CadastroCliente;
import br.com.modelos.CadastroEndereco;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastroClienteServlet", urlPatterns = {"/CadastroClienteServlet"})
public class CadastroClienteServlet extends HttpServlet {

    @EJB
    private CadastroClienteRemote clienteRemote;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            if (req.getParameter("btn_cadastrar") != null && req.getParameter("btn_cadastrar").equals("Cadastrar")) {
                try {                    
                    
                    CadastroEndereco endereco = new CadastroEndereco();
                    endereco.setEndereco(req.getParameter("endereco"));
                    endereco.setNumero(req.getParameter("numero"));
                    endereco.setComplemento(req.getParameter("complemento"));
                    endereco.setCep(new MetodosGerais().tirardotecoma(req.getParameter("cep")));
                    endereco.setBairro(req.getParameter("bairro"));
                    endereco.setCidade(req.getParameter("cidade"));
                    endereco.setEmail(req.getParameter("email"));
                    endereco.setEstado(req.getParameter("estado"));
                    endereco.setDescricaoEndereco("Endereco Principal");


                    CadastroCliente c = new CadastroCliente();
                    c.setNome(req.getParameter("nome"));
                    c.setCpf(new MetodosGerais().tirardotecoma(req.getParameter("cpf")));
                    c.setDnasc(new MetodosGerais().formataData(req.getParameter("data")));
                    c.setSexo(req.getParameter("sexo"));
                    c.setTelefone(new MetodosGerais().tirardotecoma(req.getParameter("telefone")));
                    c.setCelular(new MetodosGerais().tirardotecoma(req.getParameter("celular")));
                    c.setEmail(req.getParameter("email"));
                    c.setSenha(req.getParameter("senha"));
                    c.setEndereco(endereco);
                    clienteRemote.salvar(c);

                    session.setAttribute("user", req.getParameter("nome"));
                    req.getRequestDispatcher("respcadok.jsp").forward(req, resp);

                } catch (Exception e) {
                    req.getRequestDispatcher("respcadfail.jsp").forward(req, resp);
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