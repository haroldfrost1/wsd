<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="page">
		<html>
			<head>
				<style>
					body{
					width=100%;
					text-align:center;
					}
					.main{
					min-width:640px;
					max-width:1130px;
					margin:auto;
					padding:auto;
					}
					.hotel{
					width:480px;
					padding: 28px;
					}
					img{
					width:480px;
					}
				</style>
			</head>
			<body>
				<div class="main">
					<xsl:apply-templates />
				</div>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="header">
		<div>
			<span>This is a header</span>
			<ul>
				<li><a href="login.jsp">Login</a></li>
				<li><a href="register.jsp">Register</a></li>
			</ul>
		</div>
	</xsl:template>
	
	<xsl:template match="logged-in-header">
		<div>
			<span>Welcome! <xsl:value-of select="@username"/>.</span>
			<ul>
				<li><a href="myReviews.jsp">My Reviews</a></li>
				<li><a href="logout.jsp">Logout</a></li>
			</ul>
		</div>
	</xsl:template>

	<xsl:template match="footer">
		<div>
			<span>THis is a footer</span>
		</div>
	</xsl:template>

	<xsl:template match="hotel-list">
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="hotel">
		<div class="hotel">
			<a href="hotel.jsp?id={@id}">
				<div class="hotelname">
					<xsl:value-of select="@name" />
				</div>
				<div>
					<span>
						<xsl:value-of select="@city" />, <xsl:value-of select="@country" />
					</span>
				</div>
			</a>
		</div>
	</xsl:template>

	<xsl:template match="hotel-detail">
		<div>
			<div>
				<table>
					<tr>
						<td colspan="2"><xsl:value-of select="@name" /></td>
					</tr>
					<tr>
						<td><xsl:value-of select="@city" />,	<xsl:value-of select="@country" /></td>
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
		</div>
	</xsl:template>
	
	<xsl:template match="review-list">
		<div>
			<h1>Reviews</h1>
			<ul>
				<xsl:apply-templates/>
			</ul>
		</div>
	</xsl:template>
	
	<xsl:template match="post-review-link">
		<xsl:choose>
			<xsl:when test="@logged = 1"><a href="post.jsp?userId={@user-id}&amp;hotelId={@hotel-id}">Write a review</a></xsl:when>
			<xsl:otherwise><a href="login.jsp">Login to write a review</a></xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template match="post-review-form">
		<form method="post" action="postAct.jsp">
			<table>
				<tr><td>Hotel name: </td><td><xsl:value-of select="@hotel-name"/></td></tr>
				<tr><td>Headline: </td><td><input type="text" name="headline"/></td></tr>
				<tr><td>Description: </td><td><input type="text" name="description"/></td></tr>
				<tr>
					<td>Rating: </td>
					<td>
						<input type="radio" name="star" value="1"/>1
						<input type="radio" name="star" value="2"/>2
						<input type="radio" name="star" value="3" checked="defaultChecked"/>3
						<input type="radio" name="star" value="4"/>4
						<input type="radio" name="star" value="5"/>5
					</td>
				</tr>
				<tr><td><input type="hidden" name="hotelId" value="{@hotel-id}"></input></td><td><input type="submit" value="submit"></input></td></tr>				
			</table>
		</form>
	</xsl:template>
	
	<xsl:template match="my-review-list">
		<ul>
			<xsl:apply-templates/>
		</ul>
		<a href="index.jsp">Back to main page</a>
	</xsl:template>
	
	<xsl:template match="my-review">
		<li><xsl:value-of select="@headline"/> <xsl:value-of select="@date"/><a href="deleteAct.jsp?reviewId={@id}">Delete</a></li>
	</xsl:template>
	
	<xsl:template match="post-act">
		<p>Review successfully submitted!</p>
		<p>Please click <a href="index.jsp">here</a> to return to the main page.</p>
	</xsl:template>
	
	<xsl:template match="review">
		<li><a href="review.jsp?id={@id}&amp;hotelname={@hotel-name}"><xsl:value-of select="@headline"/></a><xsl:value-of select="@author"/> <xsl:value-of select="@date"/></li>
	</xsl:template>
	
	<xsl:template match="review-detail">
		<table>
			<tr><td>Headline: </td><td><xsl:value-of select="@headline"/></td></tr>
			<tr><td>By: </td><td><xsl:value-of select="@author-name"/></td></tr>
			<tr><td>Date: </td><td><xsl:value-of select="@date"/></td></tr>
			<tr><td>Description: </td><td><xsl:value-of select="@description"/></td></tr>
			<tr><td>Rating: </td><td><xsl:value-of select="@star"/></td></tr>
		</table>
	</xsl:template>
	
	<xsl:template match="delete-message">
		<p>Successfully deleted!</p>
		<p>Please click <a href="myReviews.jsp">here</a> to return to my reviews page.</p>
	</xsl:template>
		
	<xsl:template match="login-form">
		<form action="loginAct.jsp" method="post">
			<table>
				<tr><td>Username: </td><td><input type="text" name="name"/></td></tr>
				<tr><td>Password: </td><td><input type="password" name="password"/></td></tr>
				<tr><td></td><td><input type="submit">Submit</input></td></tr>
			</table>
		</form>
	</xsl:template>
	
	<xsl:template match="welcome">
		<p>Welcome! <xsl:value-of select="@username"/>.</p>
		<p>Please click <a href="index.jsp">here</a> to return to the main page.</p>
	</xsl:template>
	
	<xsl:template match="loggin-fail">
		<p>Sorry, incorrect combination of username and password.</p>
		<p>Please click <a href="login.jsp">here</a> to try again.</p>
	</xsl:template>
	
	<xsl:template match="logout">
		<p>You have successfullly logged out.</p>
		<p>Please click <a href="index.jsp">here</a> to return to the main page.</p>
	</xsl:template>
</xsl:stylesheet>