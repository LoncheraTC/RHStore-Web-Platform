﻿<%@ Page Title="" Language="C#" MasterPageFile="~/Admin/Admin.Master" AutoEventWireup="true" CodeBehind="GestionarPrendas.aspx.cs" Inherits="RHStoreWS.Admin.GestionarPrendas" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
	Gestión de prendas
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
				<h2>Gestión de Prendas</h2>
			</div>
			<div class="card-body">
				<div class="row align-items-center mb-3">
					<div class="col-12 col-md-auto me-2">
						<asp:Label ID="lblNombreDescripcion" runat="server" Text="Nombre o descripción de la prenda:" CssClass="col-form-label" />
					</div>
					<div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
						<asp:TextBox ID="txtNombreDescripcion" runat="server" CssClass="form-control" />
					</div>
					<div class="col-12 col-md-auto me-2 mt-3 mt-md-0">
						<asp:LinkButton ID="lbBuscar" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass'></i> Buscar" OnClick="lbBuscar_Click" />
					</div>
					<div class="col-12 col-md text-md-end mt-3 mt-md-0">
						<asp:LinkButton ID="lbRegistrar" runat="server" CssClass="btn btn-success" Text="<i class='fa-solid fa-plus'></i> Registrar" OnClick="lbRegistrar_Click" />
					</div>
				</div>
				<div class="row">
					<asp:GridView ID="gvPrendas" runat="server" AllowPaging="true" PageSize="5" OnRowDataBound="gvPrendas_RowDataBound" OnPageIndexChanging="gvPrendas_PageIndexChanging" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" ShowHeaderWhenEmpty="true">
						<Columns>
							<asp:BoundField HeaderText="Nombre" />
							<asp:BoundField HeaderText="Descripción" />
							<asp:BoundField HeaderText="Talla" />
							<asp:BoundField HeaderText="Género" />
							<asp:BoundField HeaderText="Color" />
							<asp:BoundField HeaderText="Stock" />
							<asp:BoundField HeaderText="Cant. Vendida" />
							<asp:BoundField HeaderText="Prec. Original" />
							<asp:BoundField HeaderText="Prec. Descontado" />
							<asp:TemplateField>
								<ItemTemplate>
									<div style="display: inline-flex; align-items: center;">
										<asp:LinkButton ID="lbModificar" runat="server" Text="<i class='fa-solid fa-edit ps-2'></i>" CommandArgument='<%# Eval("idPrenda") %>' OnClick="lbModificar_Click" />
										<asp:LinkButton ID="lbEliminar" runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("idPrenda") %>' OnClick="lbEliminar_Click" />
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
