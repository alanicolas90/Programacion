<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Detail</th>
        <th>Price(without IVA)</th>
        <th>Price(with IVA)</th>
      </tr>
      <xsl:for-each select="items/item">
        <tr>
          <td><xsl:value-of select="detail"/></td>
          <td><xsl:value-of select="price"/></td>
          <td><xsl:value-of select="price*1.21"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>