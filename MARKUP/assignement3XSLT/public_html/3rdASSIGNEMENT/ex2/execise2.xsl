<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <table border="0">
      <tr bgcolor="#9acd32">
        <th>Food Item</th>
        <th>Carbs (g)</th>
        <th>Fiber (g)</th>
        <th>Fat (g)</th>
        <th>Enegy (kj)</th>
      </tr>
      <xsl:for-each select="food_list/food_item">
        <tr style="background-color: green">
          <td><xsl:value-of select="name"/></td>
          <td><xsl:value-of select="carbs_per_serving"/></td>
          <td><xsl:value-of select="fiber_per_serving"/></td>
          <td><xsl:value-of select="fat_per_serving"/></td>
          <td><xsl:value-of select="kj_per_serving"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>
