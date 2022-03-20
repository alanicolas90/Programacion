<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Titles of the books</h2>
                <xsl:for-each select="bookShop/book">
                    <ul>
                        <li>
                            <xsl:value-of select="title"/>
                        </li>
                    </ul>
                </xsl:for-each>
                <h2>Table of the books</h2>
                <table border="0">
                    <tr bgcolor="#9acd32">
                        <th>Title</th>
                        <th>Author</th>
                        <th>Year</th>
                        <th>Price</th>
                        <th>Number of pages</th>
                    </tr>
                    <xsl:for-each select="bookShop/book">
                        <tr style="background-color: green">
                            <td>
                                <xsl:value-of select="title"/>
                            </td>
                            <td>
                                <xsl:value-of select="author"/>
                            </td>
                            <td>
                                <xsl:value-of select="year"/>
                            </td>
                            <td>
                                <xsl:value-of select="price"/>
                            </td>
                            <xsl:choose>
                                <xsl:when test="section/chapter/@num">
                                    <td>
                                        <xsl:value-of select="section/chapter[1]/npages + section/chapter[2]/npages"/>
                                    </td>
                                </xsl:when>
                                <xsl:when test="chapter/@num">
                                    <td>
                                        <xsl:value-of select="chapter[1]/npages + chapter[2]/npages"/>
                                    </td>
                                </xsl:when>
                                <xsl:otherwise>
                                    <td>
                                        Null
                                    </td>
                                </xsl:otherwise>
                            </xsl:choose>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

