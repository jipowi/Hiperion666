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
									<xsl:text>Cotizacion Cumplimiento Contrato</xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>ObjetoAsegurado: </xsl:text>
								<xsl:value-of select="documento/objetoAsegurado" />
								<br />
								<xsl:text>Valor Contrato: </xsl:text>
								<xsl:value-of select="documento/valorContrato" />
								<br />
								<xsl:text>Valor Asegurado: </xsl:text>
								<xsl:value-of select="documento/valorAsegurado" />
								<br />
								<xsl:text>Tipo Contragarantia: </xsl:text>
								<xsl:value-of select="documento/tipoContraGaranta" />

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