
package ec.edu.espe.arquitectura.service;

import ec.edu.espe.arquitectura.dao.TipoProductoFacade;
import ec.edu.espe.arquitectura.model.TipoProducto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;


@Stateless
@LocalBean
public class TipoProductoService {

    @EJB
    private TipoProductoFacade tipoProductoFacade;

    public List<TipoProducto> obtenerTodos() {
        return this.tipoProductoFacade.findAll();
    }

//    public TipoCamarote obtenerPorCodigo(String codigo) {
//        return this.tipoCamaroteFacade.find(codigo);
//    }

    public void crear(TipoProducto tipoProducto) {
        this.tipoProductoFacade.create(tipoProducto);
    }


}
