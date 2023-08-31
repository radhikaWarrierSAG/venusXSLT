<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 

<xsl:template  match="/">
	<xsl:copy-of select="/invoice/by/customer"/>
</xsl:template>

</xsl:stylesheet>
