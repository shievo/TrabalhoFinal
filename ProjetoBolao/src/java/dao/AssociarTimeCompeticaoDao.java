package dao;

import conexao.Hibernate4Util_UnicaSessao;
import java.util.List;
import modelo.AssociarTimeCompeticao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AssociarTimeCompeticaoDao {

    public void salvar(AssociarTimeCompeticao associarTimeCompeticao) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.save(associarTimeCompeticao);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível inserir o Associar Time Competicao. Erro: " + e.getMessage());
        }
    }

    public void atualizar(AssociarTimeCompeticao associaTimeCompeticao) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.update(associaTimeCompeticao);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível alterar a Associar Time Competicao. Erro: " + e.getMessage());
        }
    }

    public void excluir(AssociarTimeCompeticao associarTimeCompeticao) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            sessao.delete(associarTimeCompeticao);
            transacao.commit();
        } catch (HibernateException e) {
            System.out.println("Não foi possível excluir o Associar Time Competicao. Erro: " + e.getMessage());
        }
    }

    public List<AssociarTimeCompeticao> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<AssociarTimeCompeticao> resultado = null;

        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from AssociarTimeCompeticao");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException e) {
            System.out.println("Não foi possível selecionar Associar Time Competicao. Erro: " + e.getMessage());
            throw new HibernateException(e);
        }
    }

    public List<AssociarTimeCompeticao> buscaAssociarTimeCompeticao(int filtro, String busca) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        List<AssociarTimeCompeticao> lista = null;
        try {
            sessao = Hibernate4Util_UnicaSessao.getSessionFactory();
            transacao = sessao.beginTransaction();

            switch (filtro) {
                case 1: //código
                    consulta = sessao.createQuery("from AssociarTimeCompeticao where cod_associartimecompeticao = :parametro");
                    consulta.setInteger("parametro", Integer.valueOf(busca));
                    break;
                case 2: //time
                    consulta = sessao.createQuery("from AssociarTimeCompeticao where time LIKE :parametro order by apostador asc, codigo asc");
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
            System.out.println("Não foi possível buscar Associar Time Competicao. Erro: " + e.getMessage());
        }
        return lista;
    }
    
}
