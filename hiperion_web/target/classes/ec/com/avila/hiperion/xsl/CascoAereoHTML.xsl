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
									<xsl:text>Cotizacion Casco Aereo</xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>&#205;tem: </xsl:text>
								<xsl:value-of select="documento/item" />
								<br />
								<xsl:text>Matr&#237;cula: </xsl:text>
								<xsl:value-of select="documento/matricula" />
								<br />
								<xsl:text>A&#241;o construcci&#243;n: </xsl:text>
								<xsl:value-of select="documento/anioConstruccion" />
								<br />
								<xsl:text>Peso m&#225;ximo Total: </xsl:text>
								<xsl:value-of select="documento/pesoMaximoTotal" />
								<br />
								<xsl:text>Valor Casco: </xsl:text>
								<xsl:value-of select="documento/valorCasco" />
								<br />
								<xsl:text>Marca: </xsl:text>
								<xsl:value-of select="documento/marca" />
								<br />
								<xsl:text>T&#237;po modelo: </xsl:text>
								<xsl:value-of select="documento/tipoModelo" />
								<br />
								<xsl:text>Horas Voladas: </xsl:text>
								<xsl:value-of select="documento/horasVoladas" />
								<br />
								<xsl:text>M&#225;xima Carga Autorizada: </xsl:text>
								<xsl:value-of select="documento/maximaCargaAutorizada" />
								<br />
								<xsl:text>Marca Motor: </xsl:text>
								<xsl:value-of select="documento/marcaMotor" />
								<br />
								<xsl:text>Tipo Motor: </xsl:text>
								<xsl:value-of select="documento/tipoMotor" />
								<br />
								<xsl:text>Total asegurado(valor casco m&#225;
								s extras): </xsl:text>
								<xsl:value-of select="documento/totalAsegurado" />
								<br />
								<xsl:text>Tasa: </xsl:text>
								<xsl:value-of select="documento/tasa" />
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