package dao;
import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.*;

public class DAOParticipante extends DAO  <Participante> {
	public Participante read(Object key) {
		String nome = (String) key;
		Query fofis = manager.query();
		
		fofis.constrain(Participante.class);
		fofis.descend("nome").constrain(nome);
		List<Participante> resultado = fofis.execute();
		if (resultado.size() > 0) {
			return resultado.get(0);
			
		} return null;
	}
	public List <Participante> consulta(String nome, int mes) {
		Query querynha = manager.query();
		querynha.constrain(Participante.class);
		querynha.descend("reunioes").constrain(new Filtro(nome, mes));
		List<Participante> resultadozitinho = querynha.execute();
		return resultadozitinho;
	}
}
class Filtro implements Evaluation {
	private int mes;
	private String nome;
	
	public Filtro(String nome,int mes) {
		this.nome = nome;
		this.mes = mes;
		
	}
	public void evaluate(Candidate candidatinho) {
		Reuniao r = (Reuniao) candidatinho.getObject();
		boolean teste = false;
		for(Participante p : r.getParticipantes()) {
			if (r.getDatahora().getMonthValue() == mes
					&& p.getNome().equals(nome)) {
				teste = true;
				break;
			}
		}
		candidatinho.include(teste);
	}
}


