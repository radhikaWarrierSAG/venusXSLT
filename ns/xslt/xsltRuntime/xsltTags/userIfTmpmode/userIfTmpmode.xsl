<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="user">
	<xsl:if test="@group = 'supplier'">
	   <xsl:apply-templates select="." mode="admin"/>
	</xsl:if>
	<xsl:if test="@group = 'store'">
	   <xsl:apply-templates select="." mode="guest"/>
	</xsl:if>
</xsl:template>

         <xsl:template match="user" mode="admin">
		       Hi Boss!<b>
		       <xsl:value-of select="email"/>
		       </b><br/>
         </xsl:template>

         <xsl:template match="user" mode="guest">
		      <h2><i>
		      <xsl:value-of select="email"/>
		      </i></h2>
         </xsl:template>

</xsl:stylesheet>
