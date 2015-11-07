<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>
     
     <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ek+Mukta">
     <link type="text/css" rel="stylesheet" href="home.css"/>
     <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
     <script type="text/javascript" src="home.js"></script>
     
<div id="inner"> 
				<div id="top">
					<div id= "general">
						<ul id="toplist">
							<li style="width: 58px"><a href="http://localhost:8080/E-ThisIsSparta/welcome.jsp"><span>HOME</span></a></li>
							
							<li style="width: 88px"><a href="<s:url action='listOfProducts' />"><span>SHOP</span></a></li>
							
							<li style="width: 68px"><s:a action="account"><span>MY ACCOUNT</span></s:a></li>
							
							<li style="width: 78px"><a href="<s:url action='checkout'/>"><span>CHECKOUT</span></a></li>
							
							<li> <a href="">CONTACT US</a>							
						</ul>
					</div>
					

					<div id= "phonenum">
						<div id="account">
							<ul>
							<li><s:a action="login"><em>Log In</em></s:a></li>
							
							<li><s:a action="signup"><em>Sign Up</em></s:a></li>
							</ul>
						</div>

						
						
						
					</div>
				</div>
					<div id="header">
													
								<ul>
									<li class="dropdown"><s:a action="" ><span>CATEGORIES</span></s:a>
										<ul class="sub-menu">
											<li><s:a action="">ELECTRONICS</s:a></li>
											<li><s:a action="">CLOTHING</s:a></li>
											<li><s:a action="">ENTERTAINMENT</s:a></li>
											<li><s:a action="">BOOKS</s:a></li>
										</ul>
									</li>
										
									<li class="dropdown"><s:a action=""><span>ELECTRONICS</span></s:a>
										<ul class="sub-menu">
											<li><s:a action="">TVs</s:a></li>
											<li><s:a action="">Laptop</s:a></li>
											<li><s:a action="">PCs</s:a></li>
											<li><s:a action="">Camera</s:a></li>
											<li><s:a action="">PlayStation</s:a></li>
											<li><s:a action="">XBox</s:a></li>
										</ul>
									</li>	
									
									<li class="dropdown"><s:a action="" ><span>CLOTHING</span></s:a>
										<ul class="sub-menu">
											<li><s:a action="">Women</s:a></li>
											<li><s:a action="">Men</s:a></li>
											<li><s:a action="">Children</s:a></li>
											<li><s:a action="">Babies</s:a></li>
											
										</ul>
									</li>
									
									<li class="dropdown"><s:a action=""><span>ENTERTAINMENT</span></s:a>
										<ul class="sub-menu">
											<li><s:a action="">Movies</s:a></li>
											<li><s:a action="">Music</s:a></li>
											<li><s:a action="">Video Games</s:a></li>
										</ul>
									</li>
									<li class="dropdown"><s:a action=""><span>BOOKS</span></s:a>
										<ul class="sub-menu">
											<li><s:a action="">Spritual</s:a></li>
											<li><s:a action="">Fiction</s:a></li>
																				
										</ul>
									</li>
									<li><s:a action=""><span>ON SALE</span></s:a></li>
						
								</ul>

						
						

						<div id="shoppingKart">
						<s:if test="#session.cart.size == 1">							
							You Have <s:property value="#session.cart.size"/> Order<br>
						</s:if>
						<s:elseif test="#session.cart.size > 1">
							You Have <s:property value="#session.cart.size"/> Orders<br>
						</s:elseif>
						
						</div>

						

					</div>
			</div>
			<div id="leftsidebar" ><p></p></div>
			<div id="rightsidebar" ><p></p></div>
			<div id="foooterBar" > 
				
					<ul>
					
						<li><s:a action="">Home</s:a></li>
						<li><s:a>All Categories</s:a></li>
						
					</ul>
					
					<ul>
					
						<li><s:a action="viewShoppingKart">View Cart</s:a></li>
						<li><s:a action="account">Account</s:a></li>
						<li><s:a action="login">Log In</s:a></li>
						<li><s:a action="signup">SignUp</s:a></li>
				
					</ul>	
					
					<ul>
					
						<li><s:a>Contact Us</s:a></li>
						<li><s:a>Return Policy</s:a></li>
						<li><s:a>Privacy Policy</s:a></li>
					
					</ul>
									
			</div>
			