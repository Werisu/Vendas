<%
    String usuario = (String)session.getAttribute("usuario");
    if(usuario == null){
        response.sendRedirect("login.jsp");
    }else{
        response.sendRedirect("../index.xhtml");
    }
%>