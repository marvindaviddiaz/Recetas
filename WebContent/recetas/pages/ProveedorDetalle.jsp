<%@ include file="/taglibs.jsp"%>

<rich:modalPanel id="modalPanel" style="modalPanel" autosized="true" moveable="false" onbeforeshow="effect_hide()" onbeforehide="effect_show()" onshow="effect_show()">

	<rich:effect name="effect_show" for="detalle" type="Grow" />
	<rich:effect name="effect_hide" for="detalle" type="BlindUp" />

	<f:facet name="header">
		<h:outputText value="Proveedores" styleClass="subTituloPagina" />
	</f:facet>

	<a4j:form id="detalle">

		<h:panelGrid id="formularioDatos" columns="1">

			<!-- Ingreso de Nombre -->
			<h:outputText id="otpTxtLblNombre" value="Nombre" />
			<h:panelGrid id="pnlGrdContNombre" columns="3">
				<h:inputText id="nombre" required="true" styleClass="inputForm" value="#{proveedorBean.nombre}" readonly="#{!proveedorListBean.editable}">
					<a4j:support ajaxSingle="true" event="onblur" />
				</h:inputText>
				<h:outputText styleClass="required" value="*" />
				<rich:message for="nombre" errorClass="msg_invalid" />
			</h:panelGrid>

			<!-- Ingreso de Descripcion -->
			<h:outputText id="otpTxtLblDescripcion" value="Sitio" />
			<h:inputTextarea id="descripcion" styleClass="textAreaForm" rows="4" value="#{proveedorBean.sitio}" readonly="#{!proveedorListBean.editable}">
				<a4j:support ajaxSingle="true" event="onblur" />
			</h:inputTextarea>


			<br>
			<h:panelGrid columns="2">
				<a4j:commandButton id="aceptar" value="Aceptar" rendered="#{proveedorListBean.editable}" action="#{proveedorListBean.saveAction}" oncomplete="Richfaces.hideModalPanel('modalPanel');"
					reRender="panelListado">
				</a4j:commandButton>
				<a4j:commandButton id="cancelar" value="#{proveedorListBean.labelBotonBack}" oncomplete="Richfaces.hideModalPanel('modalPanel');" immediate="true" >
				</a4j:commandButton>
			</h:panelGrid>


		</h:panelGrid>
	</a4j:form>
	<rich:hotKey key="esc" handler="#{rich:element('cancelar')}.click()"  />
</rich:modalPanel>
