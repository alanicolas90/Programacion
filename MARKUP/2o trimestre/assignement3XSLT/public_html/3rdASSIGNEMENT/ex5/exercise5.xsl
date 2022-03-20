<?xml version="1.0" encoding="UTF-8"?>
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
                    <xsl:apply-templates/>  
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="food_item">
        <tr style="background-color: green">
            <xsl:apply-templates select="name"/>  
            <xsl:apply-templates select="carbs_per_serving"/>
            <xsl:apply-templates select="fiber_per_serving"/>
            <xsl:apply-templates select="fat_per_serving"/>
            <xsl:apply-templates select="kj_per_serving"/>
        </tr>
    </xsl:template>

    <xsl:template match="name">
        <td>
            <xsl:value-of select="."/>
        </td>
    </xsl:template>
    <xsl:template match="carbs_per_serving">
        <td>
            <xsl:value-of select="."/>
        </td>
    </xsl:template>
    <xsl:template match="fiber_per_serving">
        <td>
            <xsl:value-of select="."/>
        </td>
    </xsl:template>
    <xsl:template match="fat_per_serving">
        <td>
            <xsl:value-of select="."/>
        </td>
    </xsl:template>
    <xsl:template match="kj_per_serving">
        <td>
            <xsl:value-of select="."/>
        </td>
    </xsl:template>

</xsl:stylesheet>