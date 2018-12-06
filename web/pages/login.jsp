<%-- 
    Document   : login
    Created on : 06/12/2018, 11:53:18
    Author     : Wellysson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login SIGE</title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="../imagens/icons/favicon.ico"/>
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../resources/fonts/iconic/css/material-design-iconic-font.min.css" />
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../resources/vendor/animate/animate.css" />
    <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="../resources/vendor/css-hamburgers/hamburgers.min.css" />
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../resources/vendor/animsition/css/animsition.min.css" />
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../resources/vendor/select2/select2.min.css" />
    <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css" />
    <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../resources/css/util.css" />
        <link rel="stylesheet" type="text/css" href="../resources/css/main.css" />
    </head>
    <body>
        <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
                            <form class="login100-form validate-form" action="#" method="post">
					<span class="login100-form-title p-b-26">
						Welcome
					</span>
					<span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
						<input class="input100" type="text" name="usuario" />
						<span class="focus-input100" data-placeholder="Usuário"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="pass" />
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
                                                        <button type="submit" class="login100-form-btn">
                                                            Logar
                                                        </button>
                                                        
						</div>
					</div>

					<div class="text-center p-t-115">
						<span class="txt1">
							Don’t have an account?
						</span>

						<a class="txt2" href="#">
							Sign Up
						</a>
					</div>
				</form>
                            
                            <%
                                String usuario = request.getParameter("usuario");
                                String senha = request.getParameter("pass");
                                
                                if(usuario!=null && senha!=null && !usuario.isEmpty() && !senha.isEmpty()){
                                    session.setAttribute("usuario", usuario);
                                    response.sendRedirect("valida.jsp");
                                }
                            %>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="../resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/vendor/bootstrap/js/popper.js"></script>
	<script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="../resources/vendor/daterangepicker/moment.min.js"></script>
	<script src="../resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="../resources/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
        <script src="../resources/js/main.js"></script>
    </body>
</html>
