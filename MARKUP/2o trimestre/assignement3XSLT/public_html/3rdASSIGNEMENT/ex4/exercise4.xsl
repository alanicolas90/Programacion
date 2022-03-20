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
                        <xsl:sort select="fiber_per_serving"/>
                        <xsl:choose>
                            <xsl:when test="@type='vegetable'">
                                <tr style="background-color: green">
                                    <td>
                                        <xsl:value-of select="name"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="carbs_per_serving"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="fiber_per_serving"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="fat_per_serving"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="kj_per_serving"/>
                                    </td>
                                </tr>
                            </xsl:when>
                            <xsl:when test="@type='fruit'">
                                <tr style="background-color: pink">
                                    <td>
                                        <xsl:value-of select="name"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="carbs_per_serving"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="fiber_per_serving"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="fat_per_serving"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="kj_per_serving"/>
                                    </td>
                                </tr>
                            </xsl:when>
                            <xsl:otherwise>
                                <tr>
                                    <td>
                                        <xsl:value-of select="name"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="carbs_per_serving"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="fiber_per_serving"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="fat_per_serving"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="kj_per_serving"/>
                                    </td>
                                </tr>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>