package bd.configDB;

import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.vaadin.ui.Notification;

public class SqlConfig {
	private static SqlSession sesion;

	static {
		try {
			String resource = "uaz/edu/mx/formularios/ConfigDB/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sesion = sqlMapper.openSession();
		} catch (Exception e) {
			Notification.show("Error al tratar de conectarse a la base de datos: " + e.getCause().getMessage(), Notification.Type.ERROR_MESSAGE);
		}
	}

	public static SqlSession getSesion() {
		return sesion;
	}
}
