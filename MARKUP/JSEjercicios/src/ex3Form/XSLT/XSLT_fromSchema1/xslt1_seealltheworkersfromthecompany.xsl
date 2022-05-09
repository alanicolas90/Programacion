<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>All the workers of the company</h2>
                <table border="1px solid #ddd">
                    <tr bgcolor="#04AA6D">
                        <th border-collapse="collapse">Name</th>
                        <th>Surname</th>
                        <th>Work charge</th>
                    </tr>
                    <xsl:for-each select="fruitStore//*/worker">
                        <tr>
                            <td >
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="surname"/>
                            </td>
                            <td>
                                <xsl:value-of select="@charge "/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
