package dao;

import conexao.Hibernate4Util_UnicaSessao;
import java.util.List;
import modelo.Aposta;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApostaDao {

    public void salvar(Aposta aposta) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.save(aposta);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir o Aposta. Erro: " + e.getMessage());
        }
    }

    public void atualizar(Aposta aposta) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.update(aposta);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível alterar a Aposta. Erro: " + e.getMessage());
        }
    }

    public void excluir(Aposta aposta) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.delete(aposta);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível excluir a Aposta. Erro: " + e.getMessage());
        }
    }

    public List<Aposta> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Aposta> resultado = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Aposta");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.out.println("Não foi possível selecionar Aposta. Erro: " + e.getMessage());
            throw new HibernateException(e);
        }
    }

    public List<Aposta> buscaAposta(int filtro, String busca) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        List<Aposta> lista = null;
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            switch (filtro) {
                case 1: //código
                    consulta = sessao.createQuery("from Aposta where cod_aposta = :parametro");
                    consulta.setInteger("parametro", Integer.valueOf(busca));
                    break;
                case 2: //apostador
                    consulta = sessao.createQuery("from Aposta where apostador LIKE :parametro order by apostador asc, codigo asc");
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
            System.out.println("Não foi possível buscar Aposta. Erro: " + e.getMessage());
        }
        return lista;
    }
    
}
