<%@ include file="/taglibs.jsp"%>

<rich:modalPanel id="modalPanel" style="modalPanel" autosized="true" moveable="false" onbeforeshow="effect_hide()" onbeforehide="effect_show()" onshow="effect_show()">

	<rich:effect name="effect_show" for="detalle" type="Grow" />
	<rich:effect name="effect_hide" for="detalle" type="BlindUp" />

	<f:facet name="header">
		<h:outputText value="Ingredientes" styleClass="subTituloPagina" />
	</f:facet>

	<a4j:form id="detalle">

		<h:panelGrid id="formularioDatos" columns="1">

			<!-- Ingreso de Nombre -->
			<h:outputText id="otpTxtLblNombre" value="Nombre" />
			<h:panelGrid id="pnlGrdContNombre" columns="3">
				<h:inputText id="nombre" required="true" styleClass="inputForm" value="#{ingredienteBean.nombre}" readonly="#{!ingredienteListBean.editable}">
					<a4j:support ajaxSingle="true" event="onblur" />
				</h:inputText>
				<h:outputText styleClass="required" value="*" />
				<rich:message for="nombre" errorClass="msg_invalid" />
			</h:panelGrid>

			<br>
			<h:panelGrid columns="2">
				<a4j:commandButton id="aceptar" value="Aceptar" rendered="#{ingredienteListBean.editable}" action="#{ingredienteListBean.saveAction}" oncomplete="Richfaces.hideModalPanel('modalPanel');"
					reRender="panelListado">
				</a4j:commandButton>
				<a4j:commandButton id="cancelar" value="#{ingredienteListBean.labelBotonBack}" oncomplete="Richfaces.hideModalPanel('modalPanel');" immediate="true" >
				</a4j:commandButton>
			</h:panelGrid>


		</h:panelGrid>
	</a4j:form>
	<rich:hotKey key="esc" handler="#{rich:element('cancelar')}.click()"  />
</rich:modalPanel>
