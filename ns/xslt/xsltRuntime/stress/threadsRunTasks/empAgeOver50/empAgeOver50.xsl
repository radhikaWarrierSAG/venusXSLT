<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
<xsl:output  method="text"/>

<xsl:template match="/">
	<xsl:for-each select="/EMPLIST/EMP[AGE > 50]">
	   Name: <xsl:value-of select="EMP_NAME"/>
           Age: <xsl:value-of select="AGE"/>
	</xsl:for-each>
</xsl:template>
</xsl:stylesheet>
