
import dao.TimeDao;
import java.util.Date;
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
        System.out.println("Total de registros cadastrados: " + timeDao.listar().size());
        System.out.println("Data fim:" + new Date().toString());
    }
}
