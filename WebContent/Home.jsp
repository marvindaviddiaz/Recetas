<%@ include file="taglibs.jsp"%>

<title>Recetas</title>
<head>
<script type="text/javascript">
	function setfocus() {
        var input = document.getElementById ("busquedaTxt");
        input.focus ();
	}
</script>
</head>
<body class="fondo" onload="setfocus();">
	<f:view>
		<a4j:form styleClass="fondoForm">
			<h:inputHidden value="#{inicioBean.load}" id="hiddenLoad" />
			<h:panelGrid id="panelPrincipal" styleClass="centrar" width="100%" columns="2">

				<rich:panelMenu styleClass="menuPanel" width="175px;" mode="ajax" iconExpandedGroup="disc" iconCollapsedGroup="disc" iconExpandedTopGroup="chevronUp" iconGroupTopPosition="right"
					iconCollapsedTopGroup="chevronDown">
					<rich:panelMenuGroup label="Mantenimientos" expanded="true">
						<rich:panelMenuItem label="Tipos de Recetas" action="TipoReceta" />
						<rich:panelMenuItem label="Ingredientes" action="Ingrediente" />
						<rich:panelMenuItem label="Marcas" action="Marca" />
						<rich:panelMenuItem label="Productos" action="Producto" />
						<rich:panelMenuItem label="Recetas" action="Receta" />
						<rich:panelMenuItem label="Proveedores" action="Proveedor" />
					</rich:panelMenuGroup>
				</rich:panelMenu>


				<h:panelGrid columns="1">
					<h:panelGrid id="panelSubPrincipalIzquierdo" columns="1" styleClass="centrar" width="100%">

						<h:panelGrid id="panelBusqueda" columns="1" styleClass="panelRecetas" width="100%">
							<h:panelGrid columns="2" styleClass="centrar">
								<h:inputText id="busquedaTxt" styleClass="busqueda" value="#{inicioBean.filtro}">
									<a4j:support ajaxSingle="true" event="onchange" reRender="hiddenLoad,panelRecetas" />
								</h:inputText>
							</h:panelGrid>
						</h:panelGrid>


						<h:panelGrid id="panelRecetas" columns="3" styleClass="panelRecetas" columnClasses="cell, cell, cell" width="100%">
							<h:panelGrid columns="1" styleClass="centrar" rendered="#{inicioBean.listaRecetas[0] !=null}">
								<rich:panel styleClass="box">
									<f:facet name="header"></f:facet>
									<rich:effect event="onclick" type="DropOut" params="duration:0.8" />
									<rich:effect event="onclick" for="dobox" type="Appear" params="delay:3.0,duration:0.5" />
									<h:graphicImage id="im01" value="#{inicioBean.listaRecetas[0].imagen}" styleClass="imagen">
										<a4j:support event="onclick" ajaxSingle="true" action="#{inicioBean.mostrarListadoRecetas}" oncomplete="Richfaces.showModalPanel('listadoRecetasBox')" reRender="listadoRecetas">
											<f:param value="#{inicioBean.listaRecetas[0].id}" name="recetaSeleccionada" />
										</a4j:support>
									</h:graphicImage>
									<h:outputText value="#{inicioBean.listaRecetas[0].nombre}" />
								</rich:panel>
								<br>
								<br>
							</h:panelGrid>

							<h:panelGrid columns="1" styleClass="centrar" rendered="#{inicioBean.listaRecetas[1] !=null}">
								<rich:panel styleClass="box">
									<f:facet name="header"></f:facet>
									<rich:effect event="onclick" type="DropOut" params="duration:0.8" />
									<rich:effect event="onclick" for="dobox" type="Appear" params="delay:3.0,duration:0.5" />
									<h:graphicImage id="im02" value="#{inicioBean.listaRecetas[1].imagen}" styleClass="imagen">
										<a4j:support event="onclick" ajaxSingle="true" action="#{inicioBean.mostrarListadoRecetas}" oncomplete="Richfaces.showModalPanel('listadoRecetasBox')"
											reRender="listadoRecetas,listadoRecetasBox">
											<f:param value="#{inicioBean.listaRecetas[1].id}" name="recetaSeleccionada" />
										</a4j:support>
									</h:graphicImage>
									<h:outputText value="#{inicioBean.listaRecetas[1].nombre}" />
								</rich:panel>
								<br>
								<br>
							</h:panelGrid>

							<h:panelGrid columns="1" styleClass="centrar" rendered="#{inicioBean.listaRecetas[2] !=null}">
								<rich:panel styleClass="box">
									<f:facet name="header"></f:facet>
									<rich:effect event="onclick" type="DropOut" params="duration:0.8" />
									<rich:effect event="onclick" for="dobox" type="Appear" params="delay:3.0,duration:0.5" />
									<h:graphicImage id="im03" value="#{inicioBean.listaRecetas[2].imagen}" styleClass="imagen">
										<a4j:support event="onclick" ajaxSingle="true" action="#{inicioBean.mostrarListadoRecetas}" oncomplete="Richfaces.showModalPanel('listadoRecetasBox')" reRender="listadoRecetas">
											<f:param value="#{inicioBean.listaRecetas[2].id}" name="recetaSeleccionada" />
										</a4j:support>
									</h:graphicImage>
									<h:outputText value="#{inicioBean.listaRecetas[2].nombre}" />
								</rich:panel>
								<br>
								<br>
							</h:panelGrid>

						</h:panelGrid>

						<h:panelGrid id="panelPagineo" columns="3" styleClass="centrar" width="45%" columnClasses="columnaIzquierda,columnaCentro,columnaDerecha">
							<h:graphicImage value="/images/left-arrows-disabled.png" styleClass="columnaIzquierda" rendered="#{!inicioBean.showPrevPage}" />
							<h:graphicImage id="prevButton" value="/images/left-arrows.png" styleClass="columnaIzquierda" rendered="#{inicioBean.showPrevPage}">
								<a4j:support ajaxSingle="true" event="onclick" action="#{inicioBean.anteriorPagineo}" reRender="panelSubPrincipalIzquierdo,hiddenLoad" />
							</h:graphicImage>

							<h:outputText id="labelPagineo" value="#{inicioBean.labelPaginas}" styleClass="subTituloPagina" />

							<h:graphicImage value="/images/right-arrows-disabled.png" styleClass="columnaDerecha" rendered="#{!inicioBean.showNextPage}" />
							<h:graphicImage id="nextButton" value="/images/right-arrows.png" styleClass="columnaDerecha" rendered="#{inicioBean.showNextPage}">
								<a4j:support ajaxSingle="true" event="onclick" action="#{inicioBean.siguientePagineo}" reRender="panelSubPrincipalIzquierdo,hiddenLoad" />
							</h:graphicImage>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>




			</h:panelGrid>
		</a4j:form>


		<rich:hotKey key="left" handler="#{rich:element('prevButton')}.click()" />
		<rich:hotKey key="right" handler="#{rich:element('nextButton')}.click()" />

		<a4j:include id="listadoRecetas" viewId="/HomeDetalleReceta.jsp" ajaxRendered="false" />
	</f:view>
</body>