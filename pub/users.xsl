<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">   
   <xsl:param name="user"/>
   <xsl:param name="password"/>  
   

 <xsl:template match="/">
   <html><body>
   Here is the input for user <xsl:value-of select="$user" />
   and input for password <xsl:value-of select="$password"/>
	 <xsl:choose>
		<xsl:when test="users/user[$user = @place]/password = $password">
		  <xsl:apply-templates select="//user[$user=@place]" mode="ok"/>
		</xsl:when>

		<xsl:otherwise>
		  <xsl:apply-templates select="//user[1]" mode="fail"/>
		</xsl:otherwise>
	 </xsl:choose>		
	 </body></html>
 </xsl:template>

<xsl:template  match="user" mode="ok">
	You have typed in a real user name and password...
</xsl:template>


<xsl:template  match="user" mode="fail">
	Hard luck try again...
</xsl:template>


</xsl:stylesheet>
