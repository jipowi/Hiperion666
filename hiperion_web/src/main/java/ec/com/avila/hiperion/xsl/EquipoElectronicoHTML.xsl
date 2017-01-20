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
									<xsl:text>Cotizacion Equipo Electr&#243;nico</xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>Equipos Fijos: </xsl:text>
								<xsl:value-of select="documento/equiposFijos" />
								<br />
								<xsl:text>Equipos Port&#225;tiles: </xsl:text>
								<xsl:value-of select="documento/equiposPortatiles" />
								<br />
								<xsl:text>Celulares: </xsl:text>
								<xsl:value-of select="documento/celulares" />
								<br />
								<xsl:text>Tasa Otros: </xsl:text>
								<xsl:value-of select="documento/tasaOtros" />
								<br />
								<xsl:text>Portadores externos de Datos: </xsl:text>
								<xsl:value-of select="documento/portadoresExternosDatos" />
								<br />
								<xsl:text>Incremento en costos de operaci&#237;n: </xsl:text>
								<xsl:value-of select="documento/incrementoCostoOperacion" />
								<br />
								<xsl:text>Hurto: </xsl:text>
								<xsl:value-of select="documento/hurto" />
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