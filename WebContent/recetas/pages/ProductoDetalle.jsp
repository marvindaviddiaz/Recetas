<%@ include file="/taglibs.jsp"%>

<rich:modalPanel id="modalPanel" style="modalPanel" autosized="true" moveable="false" onbeforeshow="effect_hide()" onbeforehide="effect_show()" onshow="effect_show()">

	<rich:effect name="effect_show" for="detalle" type="Grow" />
	<rich:effect name="effect_hide" for="detalle" type="BlindUp" />

	<f:facet name="header">
		<h:outputText value="Productos" styleClass="subTituloPagina" />
	</f:facet>

	<a4j:form id="detalle">

		<h:panelGrid id="formularioDatos" columns="1">

			<!-- Ingreso de Nombre -->
			<h:outputText id="otpTxtLblNombre" value="Nombre" />
			<h:panelGrid id="pnlGrdContNombre" columns="3">
				<h:inputText id="nombre" required="true" styleClass="inputForm" value="#{productoBean.nombre}" readonly="#{!productoListBean.editable}">
					<a4j:support ajaxSingle="true" event="onblur" />
				</h:inputText>
				<h:outputText styleClass="required" value="*" />
				<rich:message for="nombre" errorClass="msg_invalid" />
			</h:panelGrid>

			<!-- Ingreso de Descripcion -->
			<h:outputText id="otpTxtLblDescripcion" value="Descripcion" />
			<h:inputTextarea id="descripcion" styleClass="textAreaForm" rows="4" value="#{productoBean.descripcion}" readonly="#{!productoListBean.editable}">
				<a4j:support ajaxSingle="true" event="onblur" />
			</h:inputTextarea>

			<!-- Ingreso de Marca -->
			<h:outputText id="otpTxtLblMarca" value="Marca" />
			<h:panelGrid id="pnlGrdContMarca" columns="3">
				<h:selectOneMenu id="marca" required="true" styleClass="inputForm" value="#{productoBean.marcaId}" disabled="#{!productoListBean.editable}">
					<f:selectItems value="#{productoListBean.marcasItem}" />
					<a4j:support ajaxSingle="true" event="onblur" />
				</h:selectOneMenu>
				<rich:message for="marca" errorClass="msg_invalid" />
			</h:panelGrid>


			<!-- Ingreso de Igrediente -->
			<h:outputText id="otpTxtLblIngrediente" value="Ingrediente Relacionado" />
			<h:panelGrid id="pnlGrdContIngrediente" columns="3">
				<h:selectOneMenu id="ingrediente" required="true" styleClass="inputForm" value="#{productoBean.ingredienteId}" disabled="#{!productoListBean.editable}">
					<f:selectItems value="#{productoListBean.ingredientesItem}" />
					<a4j:support ajaxSingle="true" event="onblur" />
				</h:selectOneMenu>
				<h:outputText styleClass="required" value="*" />
				<rich:message for="ingrediente" errorClass="msg_invalid" />
			</h:panelGrid>


			<br>
			<h:panelGrid columns="2">
				<a4j:commandButton id="aceptar" value="Aceptar" rendered="#{productoListBean.editable}" action="#{productoListBean.saveAction}" oncomplete="Richfaces.hideModalPanel('modalPanel');"
					reRender="panelListado">
				</a4j:commandButton>
				<a4j:commandButton id="cancelar" value="#{productoListBean.labelBotonBack}" oncomplete="Richfaces.hideModalPanel('modalPanel');" immediate="true">
				</a4j:commandButton>
			</h:panelGrid>


		</h:panelGrid>
	</a4j:form>
	<rich:hotKey key="esc" handler="#{rich:element('cancelar')}.click()" />
</rich:modalPanel>
