<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% if(session.getAttribute("verificalog") == (Object) true){
    request.getRequestDispatcher("index.jsp").forward(request, response);    
}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head> 
        <title>BOX GAMES - A SUA LOJA DE GAMES</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="description" content="BOX GAMES | Loja de Games | Compre Consoles, Jogos e Equipamentos para sua divers�o"/>
        <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.9.1/build/cssreset/cssreset-min.css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>   
        <script src="js/jquery-1.9.1.js" type="text/javascript"></script>
        <script src="js/jquery.maskedinput.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(function() {
                $('input[name=data]').mask('99/99/9999'),
                $('input[name=cep]').mask('99999-999'),
                $('input[name=cpf]').mask('999.999.999-99'),
                $('input[name=telefone]').mask('(99)9999-9999'),                               
                $('input[name=celular]').mask('(99)99999-9999');
            });		
                                          
        </script>        
    </head>
    <body>
        <c:import url="header.jsp" />

        <div id="conteudo"> 
         <h1 id="titulocadastro">Formul�rio de cadastro</h1>
        <c:import url="formcad.jsp" />
        </div>

        <c:import url="footer.jsp" />
    </body>
</html>


