package dao;

import conexao.Hibernate4Util_UnicaSessao;
import java.util.List;
import modelo.Time;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TimeDao {

    public void salvar(Time time) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.save(time);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir o time. Erro: " + e.getMessage());
        }
    }

    public void atualizar(Time time) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.update(time);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível alterar o time. Erro: " + e.getMessage());
        }
    }

    public void excluir(Time time) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.delete(time);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível excluir o time. Erro: " + e.getMessage());
        }
    }

    public List<Time> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Time> resultado = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Time");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.out.println("Não foi possível selecionar times. Erro: " + e.getMessage());
            throw new HibernateException(e);
        }
    }

    public List<Time> buscaTime(int filtro, String busca) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        List<Time> lista = null;
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            switch (filtro) {
                case 1: //código
                    consulta = sessao.createQuery("from Time where codigo = :parametro");
                    consulta.setInteger("parametro", Integer.valueOf(busca));
                    break;
                case 2: //nome
                    consulta = sessao.createQuery("from Time where nome LIKE :parametro order by nome asc, codigo asc");
                    consulta.setString("parametro", "%" + busca + "%");
                    break;
                case 3: //cidade
                    consulta = sessao.createQuery("from Time where cidade LIKE :parametro order by cidade asc, nome asc");
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
            System.out.println("Não foi possível buscar contato. Erro: " + e.getMessage());
        }
        return lista;
    }

    public List<Time> buscaTimeIntervalo(int filtro, String busca1, String busca2) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        List<Time> lista = null;
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            switch (filtro) {
                case 1: //codigo
                    consulta = sessao.createQuery("from Time where codigo between :busca1 and :busca2  order by codigo asc, data_cadastro desc");
                    consulta.setInteger("busca1", Integer.valueOf(busca1));
                    consulta.setInteger("busca2", Integer.valueOf(busca2));
                    break;
                case 2: //data_cadastro
                    consulta = sessao.createQuery("from Time where data_cadastro between :busca1 and :busca2  order by data_cadastro desc, codigo asc");
                    consulta.setString("busca1", busca1);
                    consulta.setString("busca2", busca2);
                    break;
                case 3: //data_fundacao
                    consulta = sessao.createQuery("from Time where data_fundacao between :busca1 and :busca2  order by data_fundacao desc, codigo asc");
                    consulta.setString("busca1", busca1);
                    consulta.setString("busca2", busca2);
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
            System.out.println("Não foi possível buscar contato. Erro: " + e.getMessage());
        }
        return lista;
    }
}
