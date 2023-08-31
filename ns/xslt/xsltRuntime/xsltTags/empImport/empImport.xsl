<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <!-- Import all the templates from "TableBaseWithCSS.xsl" as a base -->
  <xsl:import href="../../../../../pub/TableBaseWithCSS.xsl"/>
  <!-- Override Imported template for ROW to match ROW's with a SAL > 3000 -->
  <xsl:template match="EMP[ AGE > 30 ]">
    <tr class="Highlight"><xsl:apply-templates/></tr>
  </xsl:template>
</xsl:stylesheet>
