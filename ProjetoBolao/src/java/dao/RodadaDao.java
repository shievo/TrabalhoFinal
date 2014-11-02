package dao;

import conexao.Hibernate4Util_UnicaSessao;
import java.util.List;
import modelo.Rodada;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RodadaDao {

    public void salvar(Rodada rodada) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.save(rodada);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir a Rodada. Erro: " + e.getMessage());
        }
    }

    public void atualizar(Rodada rodada) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.update(rodada);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível alterar a Rodada. Erro: " + e.getMessage());
        }
    }

    public void excluir(Rodada rodada) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.delete(rodada);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível excluir a Rodada. Erro: " + e.getMessage());
        }
    }

    public List<Rodada> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Rodada> resultado = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Rodada");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.out.println("Não foi possível selecionar Rodada. Erro: " + e.getMessage());
            throw new HibernateException(e);
        }
    }

    public List<Rodada> buscaRodada(int filtro, String busca) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        List<Rodada> lista = null;
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            switch (filtro) {
                case 1: //código
                    consulta = sessao.createQuery("from Rodada where cod_rodada = :parametro");
                    consulta.setInteger("parametro", Integer.valueOf(busca));
                    break;
                case 2: //apostador
                    consulta = sessao.createQuery("from Rodada where rodada LIKE :parametro order by rodada asc, codigo asc");
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
            System.out.println("Não foi possível buscar a Rodada. Erro: " + e.getMessage());
        }
        return lista;
    }

    public Rodada buscaRodadaUniqueResult(int cod_rodada) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        Rodada rodada = new Rodada();
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            consulta = sessao.createQuery("from Rodada where cod_rodada = :parametro");
            consulta.setInteger("parametro", cod_rodada);

            try {
                rodada = (Rodada) consulta.uniqueResult();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            transacao.commit();
            return rodada;
        } catch (HibernateException e) {
            System.out.println("Não foi possível buscar a Rodada. Erro: " + e.getMessage());
        }
        return rodada;
    }
}
