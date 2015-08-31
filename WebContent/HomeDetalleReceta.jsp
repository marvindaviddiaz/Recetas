<%@ include file="taglibs.jsp"%>

<rich:modalPanel id="listadoRecetasBox" autosized="true"  onbeforeshow="std_effect_hide_CancionesLista()" onbeforehide="std_effect_show_CancionesLista()" onshow="std_effect_show_CancionesDetalle()">

	<rich:effect name="std_effect_show_CancionesDetalle" for="CancionesDetalle" type="Grow" />
	<rich:effect name="std_effect_hide_CancionesLista" for="CancionesLista" type="BlindUp" />
	<rich:effect name="std_effect_show_CancionesLista" for="CancionesDetalle" type="BlindDown" />

	<f:facet name="header">
		<h:outputText value="Detalle de Receta" />
	</f:facet>

	<DIV id="screen" class="fondoListado">
		<a4j:form id="CancionesDetalle" styleClass="fondoForm">
			<h:panelGroup>
				<h:outputText value="#{detalleRecetaBean.nombre}" styleClass="tituloPagina" />
				<br>
				<rich:spacer styleClass="separadorTitulo" />
			</h:panelGroup>
			<br>
			<br>
			<h:panelGrid cellpadding="1" cellspacing="0" styleClass="centrar">
				<h:panelGrid id="GridDatos" columns="1" styleClass="centrar" cellspacing="1" cellpadding="0">
					<h:panelGrid id="formularioDatos" columns="1">

						<!-- Ingreso de Descripcion -->
						<h:outputText id="otpTxtLblDescripcion" value="Descripcion" />
						<h:inputTextarea id="descripcion" styleClass="textAreaForm" rows="4" value="#{detalleRecetaBean.descripcion}" readonly="true">
						</h:inputTextarea>

						<!-- Ingreso de TipoReceta -->
						<h:outputText id="otpTxtLblTipoReceta" value="TipoReceta" />
						<h:inputText id="tipoReceta" styleClass="inputForm" value="#{detalleRecetaBean.tipoReceta.nombre}" readonly="true">
						</h:inputText>

						<h:outputText value="Ingredientes" />
						<rich:dataTable id="ingredientes" rowClasses="listadoDatosDetalle1 ,listadoDatosDetalle2" headerClass="listadoDatosHeader" value="#{detalleRecetaBean.detalleIngredientes}" var="ing" border="0"
							cellpadding="3" cellspacing="0" styleClass="listadoDatosTable" rows="5">
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Cantidad" styleClass="subTituloPagina" style="margin-left:5px !important;margin-right:5px !important;" />
								</f:facet>
								<h:outputText value="#{ing.cantidad}" />
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Tipo Medida" styleClass="subTituloPagina" style="margin-left:5px !important;margin-right:5px !important;" />
								</f:facet>
								<h:outputText value="#{ing.tipoMedida.nombre}" />
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Ingrediente" styleClass="subTituloPagina" style="margin-left:5px !important;margin-right:5px !important;" />
								</f:facet>
								<h:outputText value="#{ing.ingrediente.nombre}" />
							</rich:column>
						</rich:dataTable>
						<br>
						<rich:datascroller align="center" for="ingredientes" maxPages="20" page="1" />

						<!-- Ingreso de Procedimiento -->
						<h:outputText id="otpTxtLblProcedimiento" value="Procedimiento" />
						<h:inputTextarea id="procedimiento" styleClass="textAreaForm" rows="6" value="#{detalleRecetaBean.procedimiento}" readonly="true">
						</h:inputTextarea>

						<br>

					</h:panelGrid>
					<br>
					<br>
					<h:panelGrid styleClass="centrar">
						<a4j:commandLink id="regresar" oncomplete="Richfaces.hideModalPanel('listadoRecetasBox')" reRender="panelPrincipal">
							<h:outputText value="Regresar" />
						</a4j:commandLink>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</a4j:form>
	</DIV>
	<rich:hotKey key="esc" handler="#{rich:element('regresar')}.click()" />
</rich:modalPanel>