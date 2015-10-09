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
					float: left;
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
			<p>This is a header</p>
		</div>
	</xsl:template>

	<xsl:template match="footer">
		<div>
			<p>This is a footer</p>
		</div>
	</xsl:template>

	<xsl:template match="hotellist">
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="hotel">
		<div class="hotel">
			<a href="hotel.jsp?{id}">
				<div class="hotelname">
					<xsl:value-of select="@name" />
				</div>
				<div>
					<img src="img/1.jpg" />
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
				<img src="img/1.jpg" />
			</div>
			<div>
				<table>
					<tr>
						<td colspan="2">Four Season</td>
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
		<div>
			<h1>Reviews</h1>
		</div>
	</xsl:template>
</xsl:stylesheet>