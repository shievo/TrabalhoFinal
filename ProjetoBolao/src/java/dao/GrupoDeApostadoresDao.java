package dao;

import conexao.Hibernate4Util_UnicaSessao;
import java.util.List;
import modelo.GrupoDeApostadores;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GrupoDeApostadoresDao {

    public void salvar(GrupoDeApostadores grupoDeApostadores) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.save(grupoDeApostadores);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir o Grupo De Apostadores. Erro: " + e.getMessage());
        }
    }

    public void atualizar(GrupoDeApostadores grupoDeApostadores) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.update(grupoDeApostadores);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível alterar o Grupo De Apostadores. Erro: " + e.getMessage());
        }
    }

    public void excluir(GrupoDeApostadores grupoDeApostadores) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.delete(grupoDeApostadores);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível excluir o Grupo De Apostadores. Erro: " + e.getMessage());
        }
    }

    public List<GrupoDeApostadores> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<GrupoDeApostadores> resultado = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from GrupoDeApostadores");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.out.println("Não foi possível selecionar Grupo De Apostadores. Erro: " + e.getMessage());
            throw new HibernateException(e);
        }
    }

    public List<GrupoDeApostadores> buscaGrupoDeApostadores(int filtro, String busca) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        List<GrupoDeApostadores> lista = null;
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            switch (filtro) {
                case 1: //código
                    consulta = sessao.createQuery("from GrupoDeApostadores where cod_grupoDeApostadores = :parametro");
                    consulta.setInteger("parametro", Integer.valueOf(busca));
                    break;
                case 2: //nome
                    consulta = sessao.createQuery("from GrupoDeApostadores where nome LIKE :parametro order by nome asc, codigo asc");
                    consulta.setString("parametro", "%" + busca + "%");
                    break;
                case 3: //cidade
                    consulta = sessao.createQuery("from GrupoDeApostadores where cidade LIKE :parametro order by cidade asc, nome asc");
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
            System.out.println("Não foi possível buscar Grupo De Apostadores. Erro: " + e.getMessage());
        }
        return lista;
    }

    public GrupoDeApostadores buscaGrupoDeApostadoresUniqueResult(int cod_grupo) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        GrupoDeApostadores grupo = new GrupoDeApostadores();
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            consulta = sessao.createQuery("from GrupoDeApostadores where cod_grupo_de_apostadores = :parametro");
            consulta.setInteger("parametro", cod_grupo);

            try {
                grupo = (GrupoDeApostadores) consulta.uniqueResult();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            transacao.commit();
            return grupo;
        } catch (HibernateException e) {
            System.out.println("Não foi possível buscar Grupo De Apostadores. Erro: " + e.getMessage());
        }
        return grupo;
    }
}
