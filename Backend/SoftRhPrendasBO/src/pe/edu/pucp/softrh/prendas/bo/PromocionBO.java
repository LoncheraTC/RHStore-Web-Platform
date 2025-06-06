package pe.edu.pucp.softrh.prendas.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softrh.prendas.dao.PromocionDAO;
import pe.edu.pucp.softrh.prendas.daoimp.PromocionDAOImp;
import pe.edu.pucp.softrh.prendas.model.Prenda;
import pe.edu.pucp.softrh.prendas.model.Promocion;
import pe.edu.pucp.softrh.prendas.model.TipoPromocion;
import pe.edu.pucp.softrh.usuarios.model.Trabajador;

public class PromocionBO {
    private PromocionDAO promocionDAO;

    public PromocionBO(){
        this.promocionDAO = new PromocionDAOImp();
    }

    public Integer insertar(String nombre, String descripcion, Double valorDescuento, TipoPromocion tipo, Date fechaInicio, Date fechaFin, ArrayList<Prenda> prendasSeleccionadas, Trabajador trabajador){
        Promocion promocion = new Promocion(nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin, prendasSeleccionadas, trabajador);
        return this.promocionDAO.insertar(promocion);
    }

    public Integer modificar(Integer idPromocion, String nombre, String descripcion, Double valorDescuento, TipoPromocion tipo, Date fechaInicio, Date fechaFin, ArrayList<Prenda> prendasSeleccionadas, Trabajador trabajador){
		Promocion promocion = new Promocion(nombre, descripcion, valorDescuento, tipo, fechaInicio, fechaFin, prendasSeleccionadas, trabajador);
		promocion.setIdPromocion(idPromocion);
        return this.promocionDAO.modificar(promocion);
    }

    public Integer eliminar(Integer idPromocion){
        return this.promocionDAO.eliminar(idPromocion);
    }

    public ArrayList<Promocion> listarTodos() {
        return this.promocionDAO.listarTodos();
    }

    public Promocion obtenerPorId(Integer idPromocion) {
        return this.promocionDAO.obtenerPorId(idPromocion);
    }

	public ArrayList<Promocion> listarPorNombreDescripcion(String cadena) {
        return this.promocionDAO.listarPorNombreDescripcion(cadena);
    }

	public ArrayList<Prenda> listarPrendasAgregadas(int idPromocion){
        return this.promocionDAO.listarPrendasAgregadas(idPromocion);
    }
}
