<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
			<center>
				<table width="100%" cellpadding="0" cellspacing="5" border="0">
					<col style="width:80%;" />
					<tbody>
						<tr>
							<td align="center" colspan="2" style="font-weight: bold;">
								<h3>
									<xsl:text>Cotizaci&#243;n Dinero y Valores</xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>Tasa: </xsl:text>
								<xsl:value-of select="documento/tasa" />
								<br />
								<xsl:text>Porcentaje Valor del Siniestro: </xsl:text>
								<xsl:value-of select="documento/porcentajeSiniestro" />
								<br />
								<xsl:text>Valor min&#237;mo Siniestro: </xsl:text>
								<xsl:value-of select="documento/valorMinimoSiniestro" />
								<br />
								<xsl:text>Porcentaje Embarque: </xsl:text>
								<xsl:value-of select="documento/porcentajeEmbarque" />
								<br />
								<xsl:text>Porcentae mini&#237;mo por Embarque: </xsl:text>
								<xsl:value-of select="documento/porcentajeMinimoEmbarque" />
								<br />

							</td>
						</tr>

						<tr>
							<td style="height:0.8cm;"></td>
						</tr>
					</tbody>
				</table>

			</center>
		</html>
	</xsl:template>
</xsl:stylesheet>