package bd.accesoDatos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.vaadin.ui.Notification;

import bd.configDB.SqlConfig;
import bd.modelos.Alumno;

public class ADAlumno {
	private SqlSession sesion;
	
	public ADAlumno(){
		sesion = SqlConfig.getSesion(); 
	}
	public boolean guardar(Alumno alumno){
		boolean ok=false;
		try {
			sesion.insert("guardar", alumno);
			sesion.commit();
			ok= true;
		} catch (Exception e) {
			Notification.show("Error al guardar el alumno "+e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}
		return ok;
	}
	public List<Alumno> obtenerTodos(){
		List<Alumno> alumnos = null;
		try {
			alumnos=sesion.selectList("todosAlumnos");
		} catch (Exception e) {
			Notification.show("Error al obtener los alumnos "+e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}
		return alumnos;
	}
	public boolean eliminar(int idAlumno){
		boolean ok=false;
		try {
			sesion.delete("eliminar", idAlumno);
			sesion.commit();
			ok=true;
		} catch (Exception e) {
			Notification.show("Error al elminar alumno "+e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}
		return ok;
	}
	public Alumno buscarAlumnoPorID(int idAlumno){
		Alumno alumno =null;
		try {
			alumno=sesion.selectOne("buscarAlumnoPorID", idAlumno);
		} catch (Exception e) {
			Notification.show("Error al recuperar al alumno "+e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}
		System.out.println(alumno);
		return alumno;
	}
	public boolean modificar(Alumno alumno){
		boolean ok = false;
		try {
			sesion.update("modificar", alumno);
			sesion.commit();
			ok=true;
		} catch (Exception e) {
			Notification.show("Error al editar el alumno "+e.getCause().getMessage(),Notification.Type.ERROR_MESSAGE);
		}
		return ok;
	}
}
