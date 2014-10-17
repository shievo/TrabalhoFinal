
import dao.ApostadorDao;
import dao.GrupoDeApostadoresDao;
import dao.TimeDao;
import java.util.Date;
import modelo.Apostador;
import modelo.GrupoDeApostadores;
import modelo.Time;

public class CarregaDados {

    public static void main(String[] args) {
        TimeDao timeDao = new TimeDao();
        String[] nomes = {"Internacional", "Grêmio", "Santos", "Flamengo", "Vasco", "São Paulo", "Fluminense"};
        String[] fones = {"(47) 2222-1111", "(47) 7777-5555", "(47) 9090-2525", "(47) 9090-2525", "(47) 9090-2525", "(47) 9090-2525", "(47) 9090-2525"};
        String[] emails = {"inter@teste.com.br", "gremio@teste.com.br", "santos@teste.com.br", "flamengo@teste.com.br", "vasco@teste.com.br", "saopaulo@teste.com.br", "fluminense@teste.com.br"};
        String[] historicos = {"Histórico", "Histórico", "Histórico", "Histórico", "Histórico", "Histórico", "Histórico"};
        String[] enderecos = {"Rua 1", "Rua 2", "Rua 3", "Rua 4", "Rua 5", "Rua 6", "Rua 8"};
        String[] cidades = {"Joaçaba", "Herval", "Luzerna", "Catanduvas", "Jaborá", "Vargem Bonita", "Capinzal"};
        String[] sites = {"www.joacaba.com.br", "www.herval.com.br", "www.luzerna.com.br", "www.luzerna.com.br", "www.luzerna.com.br", "www.luzerna.com.br", "www.luzerna.com.br"};
        Time time = null;
        
        for (int i = 0; i < nomes.length; i++) {
            time = new Time();
            time.setNome(nomes[i]);
            time.setFone(fones[i]);
            time.setEmail(emails[i]);
            time.setData_cadastro(new Date());
            time.setData_fundacao(new Date());
            time.setHistorico(historicos[i]);
            time.setCidade(cidades[i]);
            time.setSite(sites[i]);
            time.setEndereco(enderecos[i]);

            timeDao.salvar(time);
        }
        
        //Grupo
        String[] nome_g = {"Grupo Internacional", "Grupo Grêmio", "Grupo Santos", "Grupo Flamengo", "Grupo Vasco", "Grupo São Paulo", "Grupo Fluminense"};
        GrupoDeApostadores grupoDeApostadores = null;
        GrupoDeApostadoresDao grupoDeApostadoresDao = new GrupoDeApostadoresDao();
        
        for (int i = 0; i < nome_g.length; i++) {
            grupoDeApostadores = new GrupoDeApostadores();
            grupoDeApostadores.setNome(nome_g[i]);
            grupoDeApostadoresDao.salvar(grupoDeApostadores);
        }
        
        
        ApostadorDao apostadorDao = new ApostadorDao();
        
        String[] nomes_ap = {"Internacional", "Grêmio", "Santos", "Flamengo", "Vasco", "São Paulo", "Fluminense"};
        String[] cpf_ap = {"085.356.499-05", "084.513.529-52", "071.674.919-00", "085.356.499-05", "084.513.529-52", "071.674.919-00", "071.674.919-00"};
        String[] emails_ap = {"inter@teste.com.br", "gremio@teste.com.br", "santos@teste.com.br", "flamengo@teste.com.br", "vasco@teste.com.br", "saopaulo@teste.com.br", "fluminense@teste.com.br"};
        String[] apelido_ap = {"Internacional", "Grêmio", "Santos", "Flamengo", "Vasco", "São Paulo", "Fluminense"};
        Apostador apostador = null;
        
        for (int i = 0; i < nomes_ap.length; i++) {
            apostador = new Apostador();
            apostador.setNome(nomes_ap[i]);
            apostador.setCpf(cpf_ap[i]);
            apostador.setEmail(emails_ap[i]);
            apostador.setApelido(apelido_ap[i]);
            apostador.setData_nascimento(new Date());
            apostador.setTime_preferido(new TimeDao().buscaTimeUniqueResult(i+1));
            apostador.setGrupo(new GrupoDeApostadoresDao().buscaGrupoDeApostadoresUniqueResult(i+1));
            
            apostadorDao.salvar(apostador);
        }
        
        System.out.println("Total de registros cadastrados: " + apostadorDao.listar().size());
        System.out.println("Data fim:" + new Date().toString());
    }
}
