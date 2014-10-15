package dao;

import conexao.Hibernate4Util_UnicaSessao;
import java.util.List;
import modelo.Apostador;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApostadorDao {

    public void salvar(Apostador apostador) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.save(apostador);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir o Apostador. Erro: " + e.getMessage());
        }
    }

    public void atualizar(Apostador apostador) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.update(apostador);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível alterar o apostador. Erro: " + e.getMessage());
        }
    }

    public void excluir(Apostador apostador) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.delete(apostador);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível excluir o apostador. Erro: " + e.getMessage());
        }
    }

    public List<Apostador> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Apostador> resultado = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Apostador");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.out.println("Não foi possível selecionar apostador. Erro: " + e.getMessage());
            throw new HibernateException(e);
        }
    }

    public List<Apostador> buscaApostador(int filtro, String busca) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        List<Apostador> lista = null;
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            switch (filtro) {
                case 1: //código
                    consulta = sessao.createQuery("from Apostador where cod_apostador = :parametro");
                    consulta.setInteger("parametro", Integer.valueOf(busca));
                    break;
                case 2: //nome
                    consulta = sessao.createQuery("from Apostador where nome LIKE :parametro order by nome asc, codigo asc");
                    consulta.setString("parametro", "%" + busca + "%");
                    break;
                case 3: //cidade
                    consulta = sessao.createQuery("from Apostador where cidade LIKE :parametro order by cidade asc, nome asc");
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
            System.out.println("Não foi possível buscar apostador. Erro: " + e.getMessage());
        }
        return lista;
    }
    
}