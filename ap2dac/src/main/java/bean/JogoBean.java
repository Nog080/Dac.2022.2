package bean;

import java.util.List;

import static util.MessageUtil.addInfoMessage;
import static util.MessageUtil.addErrorMessage;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.primefaces.component.messages.Messages;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import Dao.JogoDao;
import entidade.Jogo;

@javax.faces.bean.ManagedBean
public class JogoBean {
	private Jogo jogo = new Jogo();
	private JogoDao jogoDao = new JogoDao();
	private List<Jogo> lista;

	// Salvar
	public String salvar() {
		try {
			JogoDao.salvar(jogo);
			addInfoMessage("Sucesso", "Valor o valor foi salvo.");
			jogo = new Jogo();
		} catch (Exception e) {
			addErrorMessage("Erro", "por gentileza,tente novamente.");
		}
		return null;
	}

	// Excluir
	public String excluir() {
		JogoDao.excluir(jogo);
		addInfoMessage("Sucesso", "valores removidos.");
		lista = JogoDao.listar();
		return null;
	}

	// Action bottom Editar
	public void onRowEdit(RowEditEvent<Jogo> event) {
		
		addInfoMessage("Editado", "valores removidos.");

	}

	// Action bottom Editar/Cancelar
	public void onRowCancel(RowEditEvent<Jogo> event) {
		
		addErrorMessage("Cancelado", "por gentileza,tente novamente.");

	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getLista() {
		if (lista == null) {
			lista = JogoDao.listar();
		}
		return lista;
	}

	public void setLista(List<Jogo> lista) {
		this.lista = lista;
	}

}