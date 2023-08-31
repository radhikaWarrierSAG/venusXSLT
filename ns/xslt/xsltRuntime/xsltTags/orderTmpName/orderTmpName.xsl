<?xml version="1.0"?>
<xsl:stylesheet  version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


	<xsl:template match="/">
		<html><body><xsl:call-template name="OrderTable"/>
		</body></html>
	</xsl:template>

	<xsl:template name="OrderTable">
		<table border="1">
			<xsl:for-each select="invoice/order/product">
				<xsl:call-template name="OrderRow"/>
			</xsl:for-each>
		</table>
	</xsl:template>

	<xsl:template name="OrderRow">
		<tr><td>
		<xsl:value-of select="@name"/>
		</td><td>
		<xsl:value-of select="price/@RRP"/>
		</td></tr>
	</xsl:template>
	
	
</xsl:stylesheet>
