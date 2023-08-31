<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
<xsl:output  method="html"/>

<xsl:template match="/">
  
	<html><head><title>Where is the current node?</title></head>
	<body>

	<p>Thank you for shopping at Scoops and Scooters.</p>
	
	<table border="1">
		<xsl:for-each select="//order/product">
			<tr><td>
			<xsl:value-of select="@name"/>
			</td><td>
			<xsl:value-of select="price/@RRP"/>
			</td></tr>
		</xsl:for-each>
	</table>

	
	<xsl:choose>
	<xsl:when test="count(//order/product) &lt;= 1">
		<h3> Have an awful day, and don't come back!!</h3>
	</xsl:when>
	<xsl:when test="count(//order/product) &gt;= 5">
	  	<h3> You are one of our best customers!!</h3>
	</xsl:when>
	<xsl:otherwise>
	  	<h3> You a bought few items, next time buy more!!</h3> </xsl:otherwise>
	</xsl:choose>

	</body></html>
</xsl:template>


</xsl:stylesheet>


