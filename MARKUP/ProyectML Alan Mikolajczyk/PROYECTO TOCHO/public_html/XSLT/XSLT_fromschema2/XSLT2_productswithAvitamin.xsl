<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : XSLT2_productswithAvitamin.xsl
    Created on : 19 de marzo de 2022, 17:04
    Author     : Alan
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <body>
                <h2>All products with vitamin A sorted by price</h2>
                <table border="1px solid #ddd">
                    <tr bgcolor="#04AA6D">
                        <th>Name</th>
                        <th>icon</th>
                        <th>Vitamin</th>
                        <th>Properties</th>
                        <th>Price</th>
                        <th>Country of origin</th>
                    </tr>
                    <xsl:for-each select="//Product[properties[@vitamin='K']]">
                        <xsl:sort select="prices/price" order="descending"/>
                        <tr>
                            <td >
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="icon"/>
                            </td>
                            <td>
                                <xsl:value-of select="properties/@vitamin"/>
                            </td>
                            <td>
                                <xsl:value-of select="properties"/>
                            </td>
                            <td>
                                <xsl:value-of select="prices/price"/>
                            </td>
                            <td>
                                <xsl:value-of select="origin/country"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
