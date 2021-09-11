<%@ page import="javax.servlet.http.HttpSession" %>
			<header class="p-3 bg-dark text-white">
				<div class="container">
					<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
						<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
							<li><a href="/ebookshop/" class="nav-link px-2 text-secondary">Home</a></li>
							<% if(session.getAttribute("user") !=null) { int admin=(int) session.getAttribute("role"); if (admin !=1
								){%>
								<li><a href="/ebookshop/cart" class="nav-link px-2 text-white">Cart</a></li>
								<% }} %>
									<li><a href="#" class="nav-link px-2 text-white">Contacts</a></li>
									<li><a href="#" class="nav-link px-2 text-white">About</a></li>
						</ul>

						<div class="text-end">
							<% if(session.getAttribute("user")==null) { %>
								<a href="login"><button type="button" class="btn btn-outline-light me-2">Login</button></a>
								<a href="signup"><button type="button" class="btn btn-warning">Sign-up</button></a>
								<% } else { Cookie ck[]=request.getCookies(); 
								out.println("<div class='d-flex'><div class='m-2' style='color: #ffc107;'>"+ ck[1].getValue() +"</div><a href='logout'><button type='button' class='btn btn-danger'>Logout</button></a><div>");%>
										<% } %>
									</div>
						</div>
					</div>
			</header>