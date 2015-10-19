<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="page">
		<html>
			<head>
			<link rel="stylesheet" type="text/css" href="style.css" />				
			</head>
			<body>
				<div class="main">
					<xsl:apply-templates />
				</div>
			</body>
		</html>
	</xsl:template>

	<!-- Header and footer -->
	<xsl:template match="header">
		<div>
			<ul class="nav">
				<li><a href="index.jsp">Home</a></li>
				<li><span>Welcome to the Hotels!</span></li>
				<li><a href="login.jsp">Login</a></li>
				<li><a href="register.jsp">Register</a></li>
			</ul>
		</div>
	</xsl:template>
	<xsl:template match="logged-in-header">
		<div>
			<ul class="nav">
				<li><a href="index.jsp">Home</a></li>
				<li><span>Welcome back! <xsl:value-of select="@username"/>.</span></li>
				<li><a href="myReviews.jsp">My Reviews</a></li>
				<xsl:if test="@admin = 1">
				<li><a href="addHotel.jsp">Manage Hotels</a></li>
				</xsl:if>
				<li><a href="logout.jsp">Logout</a></li>
			</ul>
		</div>
	</xsl:template>
	<xsl:template match="footer">
		<div class="footer">
			<span>Copyright © 2015. WSD Group Assignment. Powered by Team 28.</span>
		</div>
	</xsl:template>

	<!-- Hotel display -->
	<xsl:template match="hotel-list">
	<h2 style="text-align:center;">Hotels</h2>
	<div class="hotels">
		<table>
			<tr>
				<th>Name</th>
				<th>City</th>
				<th>Country</th>
			</tr>
			<xsl:apply-templates />
		</table>
	</div>
	</xsl:template>
	<xsl:template match="hotel-list/hotel">
		<tr>
			<td>
				<a href="hotel.jsp?id={@id}">
					<xsl:value-of select="@name" />
				</a>
			</td>
			<td>
				<xsl:value-of select="@city" />
			</td>
			<td>
				<xsl:value-of select="@country" />
			</td>
		</tr>
	</xsl:template>
	<xsl:template match="hotel-detail">
	<h2>Hotel Detail</h2>
	<div class="hotels">
		<table>
			<tr>
				<td>
					<xsl:value-of select="@name" />
				</td>
				<td colspan="2">
					<xsl:value-of select="@city" />, <xsl:value-of select="@country" />
				</td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td>Address:</td>
				<td>
					<xsl:value-of select="@address" />
				</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>
					<xsl:value-of select="@email" />
				</td>
			</tr>
			<tr>
				<td>Telephone:</td>
				<td>
					<xsl:value-of select="@telephone" />
				</td>
			</tr>
		</table>
	</div>
	</xsl:template>
	
	<!-- Reviews -->
	<xsl:template match="review-list">
		<div>
			<h2>Reviews</h2>
			<table class="reviews">
				<tr>
					<th>Headline</th>
					<th>Rating</th>
					<th>Date</th>
				</tr>
				<xsl:apply-templates/>
			</table>
		</div>
	</xsl:template>
	<xsl:template match="review">
		<tr>
			<td><a href="review.jsp?id={@id}"><xsl:value-of select="@headline" /></a></td>
			<td><xsl:value-of select="@rating" /></td>
			<td><xsl:value-of select="@date" /></td>
		</tr>
	</xsl:template>
	<xsl:template match="review-detail">
		<table class="hotels">
			<tr><td>Headline: </td><td><xsl:value-of select="@headline"/></td></tr>
			<tr><td>By: </td><td><xsl:value-of select="@author-name"/></td></tr>
			<tr><td>Date: </td><td><xsl:value-of select="@date"/></td></tr>
			<tr><td>Description: </td><td><xsl:value-of select="@description"/></td></tr>
			<tr><td>Rating: </td><td><xsl:value-of select="@rating"/></td></tr>
		</table>
	</xsl:template>
	
	<!-- Post reveiw form -->
	<xsl:template match="post-form">
	<h2>Post Review</h2>
	<form action="postAct.jsp" method="post" class="post-form">
		<p style="margin-left: 30px;">
			<span style="color: red; "><xsl:value-of select="@msg" /></span>
			<span style="color: green;"><xsl:value-of select="@success"/></span>
		</p>
		<input type="hidden" name="hotelId" value="{@hotel-id}" />
		<table>
			<tr>
				<td>
					<label>Headline</label>
				</td>
				<td>
					<input type="text" name="headline" style="width: 300px;"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>Description</label>
				</td>
				<td>
					<input type="text" name="description" style="width:300px; height:100px;"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>Rating</label>
				</td>
				<td>
					<input type="radio" name="rating" value="1" />
					<label>1</label>
					<input type="radio" name="rating" value="2" />
					<label>2</label>
					<input type="radio" name="rating" value="3" checked="defaultChecked"/>
					<label>3</label>
					<input type="radio" name="rating" value="4" />
					<label>4</label>
					<input type="radio" name="rating" value="5" />
					<label>5</label>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">Post</button>
				</td>
			</tr>
		</table>
	</form>
</xsl:template>
	
	<xsl:template match="my-review-list">
		<h2>My Reviews</h2>
		<table class="hotels">
			<tr>
				<th>Headline</th>
				<th>Rating</th>
				<th>Date</th>
			</tr>
			<xsl:apply-templates/>
		</table>
		<div style="text-align: center; padding-bottom:10px;" ><a href="index.jsp">Back to main page</a></div>
	</xsl:template>
	
	<xsl:template match="my-review">
		<tr>
			<td><a href="review.jsp?id={@id}"><xsl:value-of select="@headline" /></a></td>
			<td><xsl:value-of select="@rating" /></td>
			<td><xsl:value-of select="@date" /></td>
			<td><a href="deleteAct.jsp?id={@id}">Delete</a></td>
		</tr>
	</xsl:template>
			
	<xsl:template match="login-form">
	<div style="text-align: center;"><span style="color:red;"><xsl:value-of select="@msg"/></span></div>
		<form action="loginAct.jsp" method="post">
			<table class="hotels">
				<tr><td>Username: </td><td><input type="text" name="username"/></td></tr>
				<tr><td>Password: </td><td><input type="password" name="password"/></td></tr>
				<tr><td></td><td><input type="submit">Submit</input></td></tr>
			</table>
		</form>
		<div style="text-align: center; padding-bottom:10px;" ><a href="index.jsp">Back to main page</a></div>
	</xsl:template>
		
	
	<xsl:template match="register-form">
	<h2>Register Form</h2>
	<div style="text-align:center; color:red;"><span><xsl:value-of select="@msg"/></span></div>
	<form method="post" action="registerAct.jsp">
		<table class="hotels">
			<tr><td>Username: </td><td><input type="text" name="username"/></td></tr>
			<tr><td>Password: </td><td><input type="password" name="password"/></td></tr>
			<tr><td>Email: </td><td><input type="email" name="email"/></td></tr>
			<tr><td></td><td><input type="submit" value="submit">Submit</input></td></tr>
		</table>
	</form>
	<div style="text-align: center; padding-bottom:10px;" ><a href="index.jsp">Back to main page</a></div>
	</xsl:template>
	
	<xsl:template match="add-hotel-form">
		<h2>New Hotel Form</h2>
	<div style="text-align:center; color:red;"><span><xsl:value-of select="@msg"/></span></div>
	<form method="post" action="addHotelAct.jsp">
		<table class="hotels">
			<tr><td>Hotel Name: </td><td><input type="text" name="name"/></td></tr>
			<tr><td>City: </td><td><input type="text" name="city"/></td></tr>
			<tr><td>Country: </td><td><input type="text" name="country"/></td></tr>
			<tr><td>Address: </td><td><input type="text" name="address"/></td></tr>
			<tr><td>Email: </td><td><input type="email" name="email"/></td></tr>
			<tr><td>Telephone: </td><td><input type="telephone" name="telephone"/></td></tr>
			<tr><td></td><td><input type="submit" value="submit">Submit</input></td></tr>
		</table>
	</form>
	<div style="text-align: center; padding-bottom:10px;" ><a href="index.jsp">Back to main page</a></div>
	</xsl:template>
	
</xsl:stylesheet>