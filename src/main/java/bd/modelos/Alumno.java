package bd.modelos;

import java.util.Date;

public class Alumno {
	private String nombre,apellidos,mail;
	private int idAlumno,matricula;
	private Date fechaNac;
	private Estado estado;
	
	
	
	public Alumno(){
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@ Override
	public String toString(){
		return this.nombre+" "+this.apellidos;
	}
	
}
