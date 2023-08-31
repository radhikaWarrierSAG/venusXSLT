<?xml version="1.0"?>
<xsl:stylesheet version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:output method="xml" indent="yes"/>

<xsl:template match="/">
 <xsl:apply-templates select="invoice"/>
</xsl:template>

<xsl:template match="invoice">
 <xsl:copy>
    Hello World!
 </xsl:copy>
</xsl:template>

</xsl:stylesheet>
