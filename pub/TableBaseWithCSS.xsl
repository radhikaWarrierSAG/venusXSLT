<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <!--
   | TableBaseWithCSS:
   | Basic Stylesheet to format any EMPLIST of EMP into a table
   | with column headings in a generic way. Leverages Table.css
   | CSS stylesheet to control font/color information for the page.
   +-->
  <xsl:template match="/">
    <html>
      <!-- Generated HTML Result will be linked to Table.css CSS Stylesheet -->
      <head><link rel="stylesheet" type="text/css" href="Table.css"/></head>
      <body><xsl:apply-templates/></body>
    </html>
  </xsl:template>
  <xsl:template match="EMPLIST">
    <table border="1" cellspacing="0">
      <!-- Apply templates in "ColumnHeader" mode to just *first* EMP child -->
      <xsl:apply-templates select="EMP[1]/*" mode="ColumnHeaders"/>
      <!-- Then apply templates to all child nodes normally -->
      <xsl:apply-templates/>
    </table>
  </xsl:template>
  <xsl:template match="EMP">
    <tr><xsl:apply-templates/></tr>
  </xsl:template>
  <!-- Match any element child of a EMP -->
  <xsl:template match="EMP/*">
    <td><xsl:apply-templates/></td>
  </xsl:template>
  <!-- Match any element child of a EMP when in "ColumnHeaders" Mode-->
  <xsl:template match="EMP/*" mode="ColumnHeaders">
    <th>
      <!-- Put the value of the *name* of the current element -->
      <xsl:value-of select="name(.)"/>
    </th>
  </xsl:template>
</xsl:stylesheet>