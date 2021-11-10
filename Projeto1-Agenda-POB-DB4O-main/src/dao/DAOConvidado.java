package dao;
import java.util.List;

import com.db4o.query.Query;

import modelo.*;

public class DAOConvidado extends DAO <Convidado> {
	public Convidado read(Object bonitinho) {
		String nome_do_bonitinho = (String) bonitinho;
		Query bonitonho = manager.query();
		bonitonho.constrain(Convidado.class);
		bonitonho.descend("nome").constrain(nome_do_bonitinho);
		List<Convidado> results = bonitonho.execute();
		
		if (results.size() > 0) {
			return results.get(0);

		}return null;
	}
}
