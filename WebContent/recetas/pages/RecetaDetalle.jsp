<%@ include file="/taglibs.jsp"%>

<rich:modalPanel id="modalPanel" style="modalPanel" autosized="true" moveable="false" onbeforeshow="effect_hide()" onbeforehide="effect_show()" onshow="effect_show()">

	<rich:effect name="effect_show" for="detalle" type="Grow" />
	<rich:effect name="effect_hide" for="detalle" type="BlindUp" />

	<f:facet name="header">
		<h:outputText value="Recetas" styleClass="subTituloPagina" />
	</f:facet>

	<a4j:form id="detalle">

		<h:panelGrid id="formularioDatos" columns="1">

			<!-- Ingreso de Nombre -->
			<h:outputText id="otpTxtLblNombre" value="Nombre" />
			<h:panelGrid id="pnlGrdContNombre" columns="3">
				<h:inputText id="nombre" required="true" styleClass="inputForm" value="#{recetaBean.nombre}" readonly="#{!recetaListBean.editable}">
					<a4j:support ajaxSingle="true" event="onblur" />
				</h:inputText>
				<h:outputText styleClass="required" value="*" />
				<rich:message for="nombre" errorClass="msg_invalid" />
			</h:panelGrid>

			<!-- Ingreso de Descripcion -->
			<h:outputText id="otpTxtLblDescripcion" value="Descripcion" />
			<h:inputTextarea id="descripcion" styleClass="textAreaForm" rows="4" value="#{recetaBean.descripcion}" readonly="#{!recetaListBean.editable}">
				<a4j:support ajaxSingle="true" event="onblur" />
			</h:inputTextarea>

			<!-- Ingreso de TipoReceta -->
			<h:outputText id="otpTxtLblTipoReceta" value="TipoReceta" />
			<h:panelGrid id="pnlGrdContTipoReceta" columns="3">
				<h:selectOneMenu id="tipoReceta" required="true" styleClass="inputForm" value="#{recetaBean.tipoRecetaId}" disabled="#{!recetaListBean.editable}">
					<f:selectItems value="#{recetaListBean.tiposRecetasItem}" />
					<a4j:support ajaxSingle="true" event="onblur" />
				</h:selectOneMenu>
				<rich:message for="tipoReceta" errorClass="msg_invalid" />
			</h:panelGrid>


			<!-- Ingreso de Procedimiento -->
			<h:outputText id="otpTxtLblProcedimiento" value="Procedimiento" />
			<h:inputTextarea id="procedimiento" styleClass="textAreaForm" rows="6" value="#{recetaBean.procedimiento}" readonly="#{!recetaListBean.editable}">
				<a4j:support ajaxSingle="true" event="onblur" />
			</h:inputTextarea>


			<br>
			<h:panelGrid columns="2">
				<a4j:commandButton id="aceptar" value="Aceptar" rendered="#{recetaListBean.editable}" action="#{recetaListBean.saveAction}" oncomplete="if ('#{facesContext.maximumSeverity.ordinal}' < 2)  Richfaces.hideModalPanel('modalPanel');"
					reRender="panelListado">
				</a4j:commandButton>
				<a4j:commandButton id="cancelar" value="#{recetaListBean.labelBotonBack}" oncomplete="Richfaces.hideModalPanel('modalPanel');" immediate="true">
				</a4j:commandButton>
			</h:panelGrid>


		</h:panelGrid>
	</a4j:form>
	<rich:hotKey key="esc" handler="#{rich:element('cancelar')}.click()" />
</rich:modalPanel>
