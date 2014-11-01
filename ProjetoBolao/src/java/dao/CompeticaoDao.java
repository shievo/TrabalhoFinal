package dao;

import conexao.Hibernate4Util_UnicaSessao;
import java.util.List;
import modelo.Competicao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompeticaoDao {

    public void salvar(Competicao competicao) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.save(competicao);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir uma Competicao. Erro: " + e.getMessage());
        }
    }

    public void atualizar(Competicao competicao) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.update(competicao);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível alterar uma Competicao. Erro: " + e.getMessage());
        }
    }

    public void excluir(Competicao competicao) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.delete(competicao);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível excluir uma Competicao. Erro: " + e.getMessage());
        }
    }

    public List<Competicao> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Competicao> resultado = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Competicao");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.out.println("Não foi possível selecionar Competicao. Erro: " + e.getMessage());
            throw new HibernateException(e);
        }
    }

    public List<Competicao> buscaCompeticao(int filtro, String busca) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        List<Competicao> lista = null;
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            switch (filtro) {
                case 1: //código
                    consulta = sessao.createQuery("from Competicao where cod_apostador = :parametro");
                    consulta.setInteger("parametro", Integer.valueOf(busca));
                    break;
                case 2: //nome
                    consulta = sessao.createQuery("from Competicao where nome LIKE :parametro order by nome asc, codigo asc");
                    consulta.setString("parametro", "%" + busca + "%");
                    break;
            }

            try {
                lista = consulta.list();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            transacao.commit();
            return lista;
        } catch (HibernateException e) {
            System.out.println("Não foi possível buscar Competicao. Erro: " + e.getMessage());
        }
        return lista;
    }
    
    public Competicao buscaCompeticaoUniqueResult(int cod_competicao) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        Competicao competicao = new Competicao();
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            consulta = sessao.createQuery("from Competicao where cod_competicao = :parametro");
            consulta.setInteger("parametro", cod_competicao);

            try {
                competicao = (Competicao) consulta.uniqueResult();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            transacao.commit();
            return competicao;
        } catch (HibernateException e) {
            System.out.println("Não foi possível buscar Grupo De Apostadores. Erro: " + e.getMessage());
        }
        return competicao;
    }
}
