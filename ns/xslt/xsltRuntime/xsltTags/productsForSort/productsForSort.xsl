<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
<xsl:output  method="html"/>

<xsl:template match="/products">
<html><body><h3>We sell these products:</h3>
	<xsl:for-each select="product">

	<xsl:sort select="required_features/category"/>

	<xsl:value-of select="required_features/name"/> 
	<br/>
  </xsl:for-each>
</body></html>
</xsl:template>

</xsl:stylesheet>
