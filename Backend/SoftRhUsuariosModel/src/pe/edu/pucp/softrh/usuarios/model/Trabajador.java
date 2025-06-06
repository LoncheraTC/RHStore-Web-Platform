package pe.edu.pucp.softrh.usuarios.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Trabajador extends Usuario implements Funciones, Serializable{
	private String puesto;
	private Double sueldo;
	private Date fechaIngreso;
	private LocalTime horarioInicio;
	private LocalTime horarioFin;
	private ArrayList<Cupon> cupones;

    private static final long serialVersionUID = 1L;
    private transient DateTimeFormatter dtf; // Seguimos usando transient

	public Trabajador() {
		super();
		this.puesto = null;
		this.sueldo = null;
		this.fechaIngreso = null;
		this.horarioInicio = null;
		this.horarioFin = null;
		this.cupones = new ArrayList<>();
        this.dtf = DateTimeFormatter.ofPattern("HH:mm");
	}

	public Trabajador(String dni, String nombres, String apellidos, String correo, String contrasenha, String puesto, Double sueldo, Date fechaIngreso, String horarioInicio, String horarioFin) {
		super(dni, nombres, apellidos, correo, contrasenha);
		this.puesto = puesto;
		this.sueldo = sueldo;
		this.fechaIngreso = fechaIngreso;
		this.horarioInicio = LocalTime.parse(horarioInicio, dtf);
		this.horarioFin = LocalTime.parse(horarioFin, dtf);
		this.cupones = new ArrayList<>();
        this.dtf = DateTimeFormatter.ofPattern("HH:mm");
	}

	// Método especial para inicializar 'dtf' después de la deserialización
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject(); // Deserializa los campos no transitorios
		this.dtf = DateTimeFormatter.ofPattern("HH:mm"); // Reinstancia el DateTimeFormatter
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getHorarioInicio() {
		String horaInicio = this.horarioInicio.format(dtf);
		return horaInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = LocalTime.parse(horarioInicio, dtf);
	}

	public String getHorarioFin() {
		String horaFin = this.horarioFin.format(dtf);
		return horaFin;
	}

	public void setHorarioFin(String horarioFin) {
		this.horarioFin = LocalTime.parse(horarioFin, dtf);
	}

	public void agregarCupon(Cupon cupon) {
		cupones.add(cupon);
	}

	@Override
	public void crearPrenda() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void crearPromocion() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void crearCupon() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void listarPromociones() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void listarCupones() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void listarBoletas() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void listarFacturas() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
