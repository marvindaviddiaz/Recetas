<%@ include file="/taglibs.jsp"%>

<title>Ingrediente</title>
<body class="fondo">
	<f:view>
		<h:form styleClass="fondoForm">
			<h:inputHidden value="#{ingredienteListBean.load}" />
			<rich:panel styleClass="panelPrincipalLista">
				<h:outputText value="Listado de Ingredientes" styleClass="tituloPagina" />
				<br>

				<rich:messages globalOnly="true" errorClass="msg_error" infoClass="msg_info" />
				<br />
				<h:panelGrid columns="2" width="90%">
					<rich:panelMenu styleClass="menuPanel" width="200px;" mode="ajax" iconExpandedGroup="disc" iconCollapsedGroup="disc" iconExpandedTopGroup="chevronUp" iconGroupTopPosition="right"
						iconCollapsedTopGroup="chevronDown">
						<rich:panelMenuGroup label="Acciones" expanded="true">
							<rich:panelMenuItem label="Agregar" action="#{ingredienteListBean.addAction}" oncomplete="Richfaces.showModalPanel('modalPanel');" reRender="formDetalle">
							</rich:panelMenuItem>
							<rich:panelMenuItem label="Editar" action="#{ingredienteListBean.editAction}" oncomplete="if ('#{facesContext.maximumSeverity.ordinal}' < 2) Richfaces.showModalPanel('modalPanel');"
								reRender="formDetalle">
							</rich:panelMenuItem>
							<rich:panelMenuItem label="Eliminar" action="#{ingredienteListBean.deleteAction}" reRender="panelListado">
							</rich:panelMenuItem>
							<rich:panelMenuItem label="Regresar" action="menuPrincipal" />
						</rich:panelMenuGroup>
					</rich:panelMenu>

					<h:panelGrid id="panelListado" columns="1" cellspacing="1" cellpadding="0">
						<rich:dataTable id="listado" rowClasses="listadoDatosDetalle1 ,listadoDatosDetalle2" headerClass="listadoDatosHeader" value="#{ingredienteListBean.lista}" var="bean" border="0" cellpadding="3"
							cellspacing="0" styleClass="listadoDatosTable" rows="10">
							<h:column>
								<f:facet name="header">
								</f:facet>
								<h:selectBooleanCheckbox value="#{bean.selected}" />
							</h:column>
							<rich:column sortBy="#{bean.nombre}">
								<f:facet name="header">
									<h:outputText id="otpTxtNombre" value="Nombre" styleClass="subTituloPagina" style="margin-left:60px !important;margin-right:60px !important; text-decoration: underline !important;" />
								</f:facet>
								<a4j:commandLink value="#{bean.nombre}" action="#{ingredienteListBean.loadBean}" oncomplete="Richfaces.showModalPanel('modalPanel');" reRender="formularioDatos">
									<f:param name="BEAN_SELECTED" value="#{bean.id}" />
								</a4j:commandLink>
							</rich:column>
						</rich:dataTable>
						<br>
						<rich:datascroller align="center" for="listado" maxPages="20" page="1" />
					</h:panelGrid>
				</h:panelGrid>
			</rich:panel>
		</h:form>

		<a4j:include id="formDetalle" viewId="IngredienteDetalle.jsp" ajaxRendered="false" />

	</f:view>
</body>