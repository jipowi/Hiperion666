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
									<xsl:text>Cotizacion Casco Maritimo</xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>Nombre de la Nave: </xsl:text>
								<xsl:value-of select="documento/nombreNave" />
								<br />
								<xsl:text>Registro n&#250;mero: </xsl:text>
								<xsl:value-of select="documento/registroNumero" />
								<br />
								<xsl:text>Tonelaje Bruto: </xsl:text>
								<xsl:value-of select="documento/tonelajeBruto" />
								<br />
								<xsl:text>Clase Embarcaci&#243;n: </xsl:text>
								<xsl:value-of select="documento/claseEmbarcacion" />
								<br />
								<xsl:text>Bandera: </xsl:text>
								<xsl:value-of select="documento/bandera" />
								<br />
								<xsl:text>Zona Navegaci&#243;n: </xsl:text>
								<xsl:value-of select="documento/zonaNavegacion" />
								<br />
								<xsl:text>Eslora: </xsl:text>
								<xsl:value-of select="documento/eslora" />
								<br />
								<xsl:text>Puntal: </xsl:text>
								<xsl:value-of select="documento/puntal" />
								<br />
								<xsl:text>A&#241;o de Construcci&#243;n: </xsl:text>
								<xsl:value-of select="documento/anioConstruccion" />
								<br />
								<xsl:text>Manga: </xsl:text>
								<xsl:value-of select="documento/manga" />
								<br />
								<xsl:text>Marca Motor: </xsl:text>
								<xsl:value-of select="documento/marcaMotor" />
								<br />
								<xsl:text>Avalu&#243;: </xsl:text>
								<xsl:value-of select="documento/avlauo" />
								<br />
								<xsl:text>Valor Casco: </xsl:text>
								<xsl:value-of select="documento/valorCasco" />
								<br />
								<xsl:text>Valor Maquinaria: </xsl:text>
								<xsl:value-of select="documento/valorMaquinaria" />
								<br />
								<xsl:text>Valor Redes: </xsl:text>
								<xsl:value-of select="documento/valorRedes" />
								<br />
								<xsl:text>Otros: </xsl:text>
								<xsl:value-of select="documento/otros" />
								<br />
								<xsl:text>Total: </xsl:text>
								<xsl:value-of select="documento/total" />

							</td>
						</tr>
						<!-- <tr> <td> <table width="100%" border="1" cellspacing="0" cellpadding="0" 
							class="blanco"> <col style="width:100%;" /> <tbody style="background-color: 
							silver; font-weight: bold;"> <tr> <td align="center" colspan="2" style="font-weight: 
							bold;"> <h3> <xsl:text> COBERTURAS </xsl:text> </h3> </td> </tr> </tbody> 
							</table> </td> </tr> <tr> <td> <table width="100%" border="1" cellspacing="0" 
							cellpadding="0" class="blanco"> <col style="width:100%;" /> <tbody> <xsl:for-each 
							select="documento/coberturas"> <tr> <td> <xsl:value-of select="coberturas" 
							/> </td> </tr> </xsl:for-each> </tbody> </table> </td> </tr> <tr> <td> <table 
							width="100%" border="1" cellspacing="0" cellpadding="0" class="blanco"> <col 
							style="width:100%;" /> <tbody style="background-color: silver; font-weight: 
							bold;"> <tr> <td align="center" colspan="2" style="font-weight: bold;"> <h3> 
							<xsl:text> COBERTURAS ADICIONALES </xsl:text> </h3> </td> </tr> </tbody> 
							</table> </td> </tr> <tr> <td> <table width="100%" border="1" cellspacing="0" 
							cellpadding="0" class="blanco"> <col style="width:100%;" /> <tbody> <xsl:for-each 
							select="documento/coberturasAdicionales"> <tr> <td> <xsl:value-of select="coberturasAdicionales" 
							/> </td> </tr> </xsl:for-each> </tbody> </table> </td> </tr> <tr> <td> <table 
							width="100%" border="1" cellspacing="0" cellpadding="0" class="blanco"> <col 
							style="width:100%;" /> <tbody style="background-color: silver; font-weight: 
							bold;"> <tr> <td align="center" colspan="2" style="font-weight: bold;"> <h3> 
							<xsl:text> CLAUSULAS ADICIONALES </xsl:text> </h3> </td> </tr> </tbody> </table> 
							</td> </tr> <tr> <td> <table width="100%" border="1" cellspacing="0" cellpadding="0" 
							class="blanco"> <col style="width:100%;" /> <tbody> <xsl:for-each select="documento/clausulasAdicionales"> 
							<tr> <td> <xsl:value-of select="clausulasAdicionales" /> </td> </tr> </xsl:for-each> 
							</tbody> </table> </td> </tr> <tr> <td style="height:0.8cm;"></td> </tr> -->
					</tbody>
				</table>

			</center>
		</html>
	</xsl:template>
</xsl:stylesheet>