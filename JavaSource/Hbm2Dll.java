import java.io.File;
import java.net.URL;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Hbm2Dll {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		URL url = Hbm2Dll.class.getClassLoader().getResource("hibernate.cfg.xml");
		cfg.configure(new File(url.getPath())) ;
		SchemaExport export = new SchemaExport(cfg);
		export.setOutputFile("mySchema.ddl");
		export.setDelimiter(";");
		export.create(false, true);
	}

}
