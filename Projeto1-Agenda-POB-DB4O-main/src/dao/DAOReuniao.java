package dao;
import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.*;

public class DAOReuniao extends DAO <Reuniao> {
	public Reuniao read(Object chavinha) {
		int identificador = (int) chavinha;
		Query fofurinha = manager.query();
		
		fofurinha.constrain(Reuniao.class);
		fofurinha.descend("id").constrain(identificador);
		List<Reuniao> resultadozito = fofurinha.execute();
		
		if (resultadozito.size() > 0) {
			return resultadozito.get(0);
		}return null;
	}
	public void create(Reuniao firula) {
		Reuniao r = firula;
		int id = super.getMaxId();
		id ++;
		r.setId(id);
		manager.store(r);
	}
	public List<Reuniao> consulta() {
		Query querona = manager.query();
		querona.constrain(Reuniao.class);
		querona.descend("participantes").constrain(Convidado.class);
		List<Reuniao> resultinho = querona.execute();
		return resultinho;
	}
}

/*class Filtro implements Evaluation {
	public Filtro() {}
	public void evaluate(Candidate canditonho ) {
		Reuniao r = (Reuniao) canditonho.getObject();
		boolean teste = false;
		for(Object oriundo : r.getParticipantes()) {
			if (oriundo instanceof Convidado) {
				teste = true;
				break;
			}
		}
		canditonho.include(teste);
	}*/