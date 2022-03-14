<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Article</th>
        <th>Detail</th>
        <th>Price</th>
        <th>Order</th>
        <th>Reference</th>
      </tr>
      <xsl:for-each select="items/item">
        <tr>
          <td><xsl:value-of select="article"/></td>
          <td><xsl:value-of select="detail"/></td>
          <td><xsl:value-of select="price"/></td>
          <td><xsl:value-of select="order"/></td>
          <td><xsl:value-of select="reference"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
