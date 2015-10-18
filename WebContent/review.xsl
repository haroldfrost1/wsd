<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
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
				</style>
			</head>
			<body>
				<div class="main">
					<xsl:apply-templates />
				</div>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="review-detail">
		<table>
			<tr><td>Headline: </td><td><xsl:value-of select="@headline"/></td></tr>
			<tr><td>By: </td><td><xsl:value-of select="@author-name"/></td></tr>
			<tr><td>Date: </td><td><xsl:value-of select="@date"/></td></tr>
			<tr><td>Description: </td><td><xsl:value-of select="@description"/></td></tr>
			<tr><td>Rating: </td><td><xsl:value-of select="@rating"/></td></tr>
		</table>
	</xsl:template>
</xsl:stylesheet>