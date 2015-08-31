<%@ include file="/taglibs.jsp"%>

<title>Proveedores</title>
<body class="fondo">
	<f:view>
		<h:form styleClass="fondoForm">
			<h:inputHidden value="#{proveedorListBean.load}" />
			<rich:panel styleClass="panelPrincipalLista">
				<h:outputText value="Listado de Proveedores" styleClass="tituloPagina" />
				<br>

				<rich:messages globalOnly="true" errorClass="msg_error" infoClass="msg_info"  />
				<br />
				<h:panelGrid columns="2" width="90%">
					<rich:panelMenu styleClass="menuPanel" width="200px;" mode="ajax" iconExpandedGroup="disc" iconCollapsedGroup="disc" iconExpandedTopGroup="chevronUp" iconGroupTopPosition="right"
						iconCollapsedTopGroup="chevronDown">
						<rich:panelMenuGroup label="Acciones" expanded="true">
							<rich:panelMenuItem label="Agregar" action="#{proveedorListBean.addAction}" oncomplete="Richfaces.showModalPanel('modalPanel');" reRender="formDetalle">
							</rich:panelMenuItem>
							<rich:panelMenuItem label="Editar" action="#{proveedorListBean.editAction}" oncomplete="if ('#{facesContext.maximumSeverity.ordinal}' < 2) Richfaces.showModalPanel('modalPanel');"
								reRender="formDetalle">
							</rich:panelMenuItem>
							<rich:panelMenuItem label="Eliminar" action="#{proveedorListBean.deleteAction}" reRender="panelListado">
							</rich:panelMenuItem>
							<rich:panelMenuItem label="Regresar" action="menuPrincipal" />
						</rich:panelMenuGroup>
					</rich:panelMenu>

					<h:panelGrid id="panelListado" columns="1" cellspacing="1" cellpadding="0">
						<rich:dataTable id="listado" rowClasses="listadoDatosDetalle1 ,listadoDatosDetalle2" headerClass="listadoDatosHeader" value="#{proveedorListBean.lista}" var="bean" border="0" cellpadding="3"
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
								<a4j:commandLink value="#{bean.nombre}" action="#{proveedorListBean.loadBean}" oncomplete="Richfaces.showModalPanel('modalPanel');" reRender="formularioDatos">
									<f:param name="BEAN_SELECTED" value="#{bean.id}" />
								</a4j:commandLink>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText id="otpTxtDescripcion" value="Sitio" styleClass="subTituloPagina" style="margin-left:60px !important;margin-right:60px !important;" />
								</f:facet>
								<h:outputText value="#{bean.sitio}" />
							</rich:column>
						</rich:dataTable>
						<br>
						<rich:datascroller align="center" for="listado" maxPages="20" page="1" />
					</h:panelGrid>
				</h:panelGrid>
			</rich:panel>
		</h:form>

		<a4j:include id="formDetalle" viewId="ProveedorDetalle.jsp" ajaxRendered="false" />

	</f:view>
</body>