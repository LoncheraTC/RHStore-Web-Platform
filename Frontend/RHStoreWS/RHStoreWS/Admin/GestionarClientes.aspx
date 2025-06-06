﻿<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="GestionarClientes.aspx.cs" Inherits="RHStoreWS.Admin.GestionarClientes" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Gestión de clientes
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphNombreUsuario" runat="server">
	<asp:Label ID="lblNombreUsuario" runat="server" Text="Nombre de usuario" />
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="cphContenido" runat="server">
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Gestión de Clientes</h2>
			</div>
			<div class="card-body">
				<div class="row align-items-center mb-3">
					<div class="col-12 col-md-auto me-2">
						<asp:Label ID="lblDniNombre" runat="server" Text="DNI o nombre del cliente:" CssClass="col-form-label" />
					</div>
					<div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
						<asp:TextBox ID="txtDniNombre" runat="server" CssClass="form-control" />
					</div>
					<div class="col-12 col-md-auto me-2 mt-3 mt-md-0">
						<asp:LinkButton ID="lbBuscar" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" OnClick="lbBuscar_Click" />
					</div>
				</div>
				<div class="row">
					<asp:GridView ID="gvClientes" runat="server" AllowPaging="true" PageSize="5" OnRowDataBound="gvClientes_RowDataBound" OnPageIndexChanging="gvClientes_PageIndexChanging" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
						<Columns>
							<asp:BoundField HeaderText="ID" />
							<asp:BoundField HeaderText="DNI" />
							<asp:BoundField HeaderText="Nombre completo" />
							<asp:BoundField HeaderText="Correo" />
							<asp:BoundField HeaderText="Teléfono" />
							<asp:BoundField HeaderText="Fecha de registro" />
							<asp:BoundField HeaderText="Suscripción" />
							<asp:TemplateField>
								<ItemTemplate>
									<div style="display: inline-flex; align-items: center;">
										<asp:LinkButton ID="lbModificar" runat="server" Text="<i class='fa-solid fa-edit ps-2'></i>" CommandArgument='<%# Eval("idUsuario") %>' OnClick="lbModificar_Click" />
										<asp:LinkButton ID="lbEliminar" runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("idUsuario") %>' OnClick="lbEliminar_Click" />
									</div>
								</ItemTemplate>
							</asp:TemplateField>
						</Columns>
					</asp:GridView>
				</div>
			</div>
		</div>
	</div>
</asp:Content>
