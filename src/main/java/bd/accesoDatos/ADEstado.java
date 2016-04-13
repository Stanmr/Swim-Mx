package bd.accesoDatos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.vaadin.ui.Notification;

import bd.configDB.SqlConfig;
import bd.modelos.Estado;;

public class ADEstado {
	private SqlSession sesion;
	
	public ADEstado(){
		sesion = SqlConfig.getSesion(); 
	}
	
	public List<Estado> obtenerTodos(){
		List<Estado> estados = null;
		try {
			estados=sesion.selectList("todosEstados");
		} catch (Exception e) {
			Notification.show("Error al obtener los estados "+e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}
		return estados;
	}
	
}
