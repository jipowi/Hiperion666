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
									<xsl:text>Cotizaci&#243;n SOAT </xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>Tipo de Veh&#237;culo: </xsl:text>
								<xsl:value-of select="documento/tipoVehiculo" />
								<br />
								<xsl:text>Modelo: </xsl:text>
								<xsl:value-of select="documento/modelo" />
								<br />
								<xsl:text>Nombre del Asegurado: </xsl:text>
								<xsl:value-of select="documento/nombreAsegurado" />
								<br />
								<xsl:text>Color: </xsl:text>
								<xsl:value-of select="documento/color" />
								<br />
								<xsl:text>Placa: </xsl:text>
								<xsl:value-of select="documento/placa" />
								<br />
								<xsl:text>Chasis: </xsl:text>
								<xsl:value-of select="documento/chasis" />
								<br />
								<xsl:text>A&#241;o: </xsl:text>
								<xsl:value-of select="documento/anio" />
								<br />
								<xsl:text>Cilindraje: </xsl:text>
								<xsl:value-of select="documento/cilindraje" />
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