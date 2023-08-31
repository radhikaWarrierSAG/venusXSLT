<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="document">
    <见面>Greeting from 小吴 <xsl:value-of select="."/></见面>
  </xsl:template>
</xsl:stylesheet>