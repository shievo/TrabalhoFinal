package dao;

import conexao.Hibernate4Util_UnicaSessao;
import java.util.List;
import modelo.Jogo;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class JogoDao {

    public void salvar(Jogo jogo) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.save(jogo);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir o Jogo. Erro: " + e.getMessage());
        }
    }

    public void atualizar(Jogo jogo) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.update(jogo);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível alterar o Jogo. Erro: " + e.getMessage());
        }
    }

    public void excluir(Jogo jogo) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.delete(jogo);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível excluir o Jogo. Erro: " + e.getMessage());
        }
    }

    public List<Jogo> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Jogo> resultado = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Jogo where finalizada = 'f'");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.out.println("Não foi possível selecionar Jogo. Erro: " + e.getMessage());
            throw new HibernateException(e);
        }
    }

    public List<Jogo> listarFinalizados() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Jogo> resultado = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Jogo where finalizada = 't'");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.out.println("Não foi possível selecionar Jogo. Erro: " + e.getMessage());
            throw new HibernateException(e);
        }
    }

    public List<Jogo> buscaJogo(int filtro, String busca) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        List<Jogo> lista = null;
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            switch (filtro) {
                case 1: //código
                    consulta = sessao.createQuery("from Jogo where cod_jogo = :parametro");
                    consulta.setInteger("parametro", Integer.valueOf(busca));
                    break;
                case 2: //nome
                    consulta = sessao.createQuery("from Jogo where nome LIKE :parametro order by nome asc, codigo asc");
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
            System.out.println("Não foi possível buscar Jogo. Erro: " + e.getMessage());
        }
        return lista;
    }

    public Jogo buscaJogoUniqueResult(int cod_jogo) {
        Session sessao = null;
        Jogo jogo = new Jogo();
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            jogo = (Jogo) sessao.createCriteria(Jogo.class).add(Restrictions.idEq(cod_jogo)).uniqueResult();
            return jogo;
        } catch (HibernateException e) {
            System.out.println("Não foi possível buscar Jogo. Erro: " + e.getMessage());
        }
        return jogo;
    }
}
