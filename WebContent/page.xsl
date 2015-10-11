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
			<span>This is a logged-in-header</span>
			<ul>
				<li><a href="account.jsp">My Account</a></li>
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
	
	<xsl:template match="review">
		<li><a href="review.jsp?id={@id}&amp;hotelname={@hotelname}"><xsl:value-of select="@headline"/></a> <xsl:value-of select="@author"/> <xsl:value-of select="@date"></xsl:value-of></li>
	</xsl:template>
	
	<xsl:template match="review-detail">
		<table>
			<tr><td>Headline: </td><td><xsl:value-of select="@headline"/></td></tr>
			<tr><td>By: </td><td><xsl:value-of select="@author-name"></xsl:value-of></td></tr>
			<tr><td>Date: </td><td><xsl:value-of select="@date"></xsl:value-of></td></tr>
			<tr><td>Description: </td><td><xsl:value-of select="@description"></xsl:value-of></td></tr>
		</table>
	</xsl:template>
</xsl:stylesheet>