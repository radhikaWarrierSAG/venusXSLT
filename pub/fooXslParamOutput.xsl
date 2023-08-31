<?xml version="1.0"?> 
<xsl:stylesheet version="1.1" 
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:Output="java://com.wm.pkg.xslt.extension.Output"
                exclude-result-prefixes="Output">
  <xsl:param name="output"/>
  <xsl:param name="firstName"/>
  <xsl:param name="lastName"/>
  <xsl:param name="title" select="'manager'"/>

  <xsl:output method="xml" indent="yes" />

  <xsl:template match="/" >
    <xsl:value-of select="Output:put($output, 'firstName', $firstName)" />
    <xsl:value-of select="Output:put($output, 'lastName', $lastName)" />
    <xsl:value-of select="Output:put($output, 'title', $title)" />
    <xsl:apply-templates />
  </xsl:template> 

  <xsl:template match="*">
    <xsl:element name="{name()}">
      <xsl:apply-templates />
    </xsl:element>
  </xsl:template>

  <xsl:template match="text" xml:space="preserve">
    <out><xsl:value-of select="."/><xsl:text> </xsl:text><xsl:value-of select="$firstName"/><xsl:text> </xsl:text><xsl:value-of select="$lastName"/><xsl:text>!!!</xsl:text></out>  
  </xsl:template>

</xsl:stylesheet>
