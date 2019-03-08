<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.pack.model.*"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Grizzly Vendor</title>
	<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css">
	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
	
	<link rel="stylesheet" href="styles/vendor.css" type="text/css">
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script language="javascript">
	window.history.forward(1);
	browser.cache.offline.enable = false;
	function noBack() {
		window.history.forward(1);

	}
	self.close()
</script>
</head>
<body onload="noBack()">
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies. 	

		if (session.getAttribute("login") == null && session.getAttribute("profile") == null) {
			response.sendRedirect("/grizzly-store-vendor-web/VendorLogin.jsp");
			return;
		}
	%>
<%!Login l=null; %>
<%!Profile p=null; %>
<div class="header container-fluid">
		<div class="row">
			<div class="col-lg-3">
				<img src="images/logo2.png" height="100%" width="100%">
			</div>
			
			<div class="col-lg-3">
				<div class="search">
					<input type="text" class="head" placeholder="&nbsp;&nbsp;Search" style="width:63%; margin-top: 27px; border: none;">
					<button style="margin-top: 27px;"><i class="fas fa-search" ></i></button>
				</div>
			</div>
			
			<div class="col-lg-1"></div>
			
			<div class="col-lg-1">
				<a id="notif" href="#"><i class="fas fa-bell fa-2x" style="margin-top: 28px;"></i></a>
			</div>
			
			<div class="col-lg-2">
			<%l=(Login)session.getAttribute("login"); %>
				<h5 style="font-size: 120%; margin-top: 37px;">Welcome, <%=l.getId() %></h5>
			</div>
			
			<div class="col-lg-2">
				<form action="/grizzly-store-vendor-web/LogoutController" method="post">
					<input type="submit" value="Logout" class="logo1" style="width:150px; border-radius:50px; border:hidden;background-color:#bfbfbf; padding:7px; margin-top: 27px; font-size: 22px;">
				</form>
			</div>
			
		</div>
	</div>
	
	<div class="row">
		<div class="card body1 col-lg-2" style="margin-left:40px; margin-top:30px; background-color: #f2f2f2; border: none;">
			<div class="card-header" style="background-color:#cccccc; margin-top:15px; margin-left:10px;  margin-right:10px; border: none;">
				<h4 style="color: white;">PROFILE</h4>
			</div>
			
			<img src="images/userimg.jpg" class="logo1" style="border: 1px solid #cccccc; margin-top: 25px;">
			
			<div class="card-body" style="margin-top:10px; margin-left:10px;  margin-right:10px; border: none;">
				<%p=(Profile)session.getAttribute("profile"); %>
				<h5 class="card-content card-title" style="font-size: 28px;"><%=p.getFirstname() %> <%=p.getLastname() %></h5><br>
				<p class="card-content card-text"><i class="fa fa-star" style="color:grey;"></i>3.7</p><br>
				<p class="card-content card-text"><b>Contact</b><br><%=p.getContact() %></p><br>
				<p class="card-content card-text"><b>Address</b><br><%=p.getAddress() %></p><br>
				<a href="#"><button class="logo1" style="width:150px; border-radius:50px; border:hidden;background-color:#bfbfbf; color:#ffffff;padding:7px; margin-top: 17px; font-size: 20px;">Contact Grizzly</button></a>
				
			</div>	
		</div>
		
		<div class="col-lg-9" style="margin-left:40px; margin-top:30px; border: none;">
			<ul class="pill-list nav nav-pills mb-3" id="pills-tab" role="tablist">
				<li class="pill-item nav-item">
					<a class="pill-link nav-link active" id="pills-prod-tab" data-toggle="pill" href="#prod" role="tab" aria-controls="prod" aria-selected="true"><h2>PRODUCTS</h2></a>
				</li>
				<li class="pill-item nav-item">
					<a class="pill-link nav-link" id="pills-invent-tab" data-toggle="pill" href="#invent" role="tab" aria-controls="invent" aria-selected="false"><h2>INVENTORY</h2></a>
				</li>
				
				<li class="pill-item nav-item">
					<a class="pill-link nav-link" id="pills-prof-tab" data-toggle="pill" href="#prof" role="tab" aria-controls="prof" aria-selected="false"><h2>PROFILE</h2></a>
				</li>
			</ul>
			
			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="prod" role="tabpanel" aria-labelledby="pills-prod-tab">
					<div class="row">
						<div class="col-lg-2">
							<select style="border-radius: 50px; border:none; background-color:#f2f2f2; padding: 7px; width:100%;">
								<option disabled value="none" selected>Category name</option>
								<option value="laptops">Laptops</option>
								<option value="electronics">Electronics</option>
								<option value="personal-care">Personal Care</option>
								<option value="art-supplies">Art Supplies</option>
							</select>
						</div>
						<div class="col-lg-3">
							<div class="search">
								<input type="text" class="head " placeholder="&nbsp;&nbsp;Product Name/id..." style="width:75%; border: none; background-color: #F2F2F2">
								<button style="background-color: #F2F2F2;"><i class="fas fa-search" ></i></button>
								</input>
							</div>
						</div>
						
						<div class="col-lg-2">
							<select style="border-radius: 50px; border:none; background-color:#f2f2f2; padding: 7px; width:100%;">
								<option disabled value="none" selected>Sort by</option>
								<option value="category">Category</option>
								<option value="brand">Brand</option>
								<option value="rating">Rating</option>
								<option value="inc" disabled>+</option>
							</select>
						</div>
						<div class="col-lg-2"></div>
						
						<div class="col-lg-3">
							<form action="/grizzly-store-vendor-web/VendorController">
								<input type="submit" value="AddProduct"class="logo1" style="width:150px; border-radius:50px; background-color:#4d4d4d; padding:7px; margin-top: 0; color:white;">
							</form>
						</div>
					</div>
					
					<div class="table-responsive table-scroll">
						<table class="table table-condensed">
							<thead>
								<tr>
									<th>Products List</th>
									<th>ID</th>
									<th>Brand</th>
									<th>Category</th>
									<th>Rating</th>
									<th></th>
								</tr>
							</thead>
							
								<tbody>
									<c:forEach var="prod" items="${product}">
									<tr>
										<td><input type="checkbox" name="product" value="trimmer" class="checkbox-round">&nbsp;<c:out value="${prod.productname}" /></td>
										<td><c:out value="${prod.pid}" /></td>
										<td><c:out value="${prod.brand}" /></td>
										<td><c:out value="${prod.category}" /></td>
										<td style="color: #bfbfbf; text-align: center;"><c:out value="${prod.rating}" /></td>
										<td>
											<div class="row">
												<div class="col-sm-6">
													<form action="/grizzly-store-vendor-web/VendorViewProductController?pid=${prod.pid }" method="post">
													<input type="submit" value="View"class="logo1" style="width:100%; border-radius:50px; background-color:#bfbfbf; padding:5px; margin-top: 0; color:#666666; font-size: 12px;">
													</form>
												</div>
												
												<div class="col-sm-6">
													<form action="/grizzly-store-vendor-web/VendorRemoveProductController?pid=${prod.pid}" method="post">
														<input type="submit" value="Remove" class="logo1" style="width:100%; border-radius:50px; background-color:#bfbfbf; padding:5px; margin-top: 0; color:#666666; font-size: 12px;">
													</form>
												</div>
											</div>
										</td>
									</tr>
									</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="invent" role="tabpanel" aria-labelledby="pills-invent-tab">
					
					<div class="row">
						<div class="col-lg-2">
							<select style="border-radius: 50px; border:none; background-color:#f2f2f2; padding: 7px; width:100%;">
								<option disabled value="none" selected>Category name</option>
								<option value="laptops">Laptops</option>
								<option value="electronics">Electronics</option>
								<option value="personal-care">Personal Care</option>
								<option value="art-supplies">Art Supplies</option>
							</select>
						</div>
						<div class="col-lg-3">
							<div class="search">
								<input type="text" class="head " placeholder="&nbsp;&nbsp;Product Name/id..." style="width:75%; border: none; background-color: #F2F2F2">
								<button style="background-color: #F2F2F2;"><i class="fas fa-search" ></i></button>
								</input>
							</div>
						</div>
						
						<div class="col-lg-2">
							<select style="border-radius: 50px; border:none; background-color:#f2f2f2; padding: 7px; width:100%;">
								<option disabled value="none" selected>Sort by</option>
								<option value="category">Category</option>
								<option value="brand">Brand</option>
								<option value="rating">Rating</option>
								<option value="inc" disabled>+</option>
							</select>
						</div>
						<div class="col-lg-2"></div>
						
						<div class="table-responsive table-scroll">
						<table class="table table-condensed">
							<thead>
								<tr>
									<th>Products List</th>
									<th>ID</th>
									<th>In Stock</th>
									<th>Req</th>
									<th>Buffer</th>
									<th>Price/Item</th>
									<th>Pending</th>
									<th>Rating</th>
									<th></th>
								</tr>
							</thead>
								<%!int i=0; %>
								<tbody>
									<c:forEach var="prod" items="${product}">
									<tr>
										<td><input type="checkbox" name="product" value="trimmer" class="checkbox-round">&nbsp;<c:out value="${prod.productname}" /></td>
										<td><c:out value="${prod.pid}" /></td>
										<td><c:out value="${prod.instock}" /></td>
										<c:if test = "${prod.buffer-prod.instock >= 0}">
											<td><c:out value="${prod.buffer-prod.instock}" /></td>
										</c:if>
										<c:if test = "${prod.buffer-prod.instock < 0}">
											<td>0</td>
										</c:if>		
										<td><c:out value="${prod.buffer}" /></td>
										<td><c:out value="${prod.price}" /></td>
										<td style="color:#bfbfbf;text-align:center"><c:out value="${prod.pending}" /></td>
										<td style="color: #bfbfbf; text-align: center;"><c:out value="${prod.rating}" /></td>
										<td>
											<div class="row">
												<div class="col-sm-12">
													<button class="logo1" style="width:100%; border-radius:50px; background-color:#bfbfbf; padding:5px; margin-top: 0; color:#666666; font-size: 12px;"data-target="#myModal" data-toggle="modal">Manage</button>
												</div>
											
											</div>
										</td>
									</tr>
									</c:forEach>			
							</tbody>
							<div class="modal fade" id="myModal" role="dialog">
									<div class="modal-dialog">
											    
													      	<!-- Modal content-->
													      	<form action="/grizzly-store-vendor-web/VendorListProductController" method="post">
													      	<div class="modal-content">
													        	<div class="modal-header">
													        		<h4 class="modal-title">Insert In Stock</h4>
													         		<button type="button" class="close" data-dismiss="modal">&times;</button>
													          		
													        	</div>
													        	<div class="modal-body">
													        	   
													          		<input type="text" name="instock">
													        	</div>
													        	<div class="modal-footer">
													        		<input type="submit" value="Save & Change" class="btn btn-primary" >
													       		</div>
													      	</div>
													      	</form>
											      
									</div>
							</div>
						</table>
					</div>
				</div>
					</div>
					
				</div>
				<div class="tab-pane fade" id="prof" role="tabpanel" aria-labelledby="pills-prof-tab"></div>
			</div>
		</div>
</body>
</html>