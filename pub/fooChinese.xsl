<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="document">
    <out>Greeting from 小吴 <xsl:value-of select="."/></out>
  </xsl:template>
</xsl:stylesheet>
