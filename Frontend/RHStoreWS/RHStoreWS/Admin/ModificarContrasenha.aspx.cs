﻿using RHStoreBaseBO.ServiciosWeb;
using RHStoreUsuariosBO;
using System;
using System.CodeDom;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RHStoreWS.Admin
{
	public partial class ModificarContrasenha : Page
	{
		private UsuarioBO usuarioBO;

		public ModificarContrasenha()
		{
			usuarioBO = new UsuarioBO();
		}

		protected void Page_Load(object sender, EventArgs e)
		{

		}

		protected void btnCambiarContrasenha_Click(object sender, EventArgs e)
		{
			int idUsuario = 0;
			if (Session["administradorLogueado"] != null)
			{
				administrador _administrador = (administrador)Session["administradorLogueado"];
				idUsuario = _administrador.idUsuario;
			}
			else if (Session["trabajadorLogueado"] != null)
			{
				trabajador _trabajador = (trabajador)Session["trabajadorLogueado"];
				idUsuario = _trabajador.idUsuario;
			}

			string contrasenhaActual = txtContrasenhaActual.Text;

			int verificacion = usuarioBO.verificarContrasenha(idUsuario, contrasenhaActual);
			if (verificacion != 0)
			{
				string contrasenhaNueva = txtNuevaContrasenha.Text;
				if(contrasenhaNueva != contrasenhaActual)
				{
					string contrasenhaConfirmacion = txtConfirmarContrasenha.Text;
					if (contrasenhaNueva == contrasenhaConfirmacion)
					{
						int resultado = usuarioBO.cambiarContrasenha(idUsuario, contrasenhaNueva);
						if (resultado != 0)
							Response.Redirect("Perfil.aspx");
					}
					else
					{
						lblErrorContrasenhaActual.Visible = false;
						lblErrorContrasenhaNoActualizada.Visible = false;
						lblErrorContrasenhasNuevas.Visible = true;
					}
				} else
				{
					lblErrorContrasenhaActual.Visible = false;
					lblErrorContrasenhaNoActualizada.Visible = true;
				}
			}
			else
			{
				lblErrorContrasenhaActual.Visible = true;
			}
		}
	}
}
