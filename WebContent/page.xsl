<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="page">
		<html>
			<head>
			<style>
			body{
				width:1130px;
				margin:auto;
				padding:auto;
			}
			.hotel{
				width:860px;
			}
			</style>
			</head>
			<body>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>

	<xsl:template match="hotellist">
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="hotel">
		<div class="hotel">
			<div class="hotelname"><xsl:value-of select="@name"/></div>
			<div>
				<img src="img/1.jpg" width="480px"/>
			</div>
			<div>
				<span><xsl:value-of select="@city"/>,<xsl:value-of select="@country"/></span>
			</div>
		</div>
	</xsl:template>
</xsl:stylesheet>