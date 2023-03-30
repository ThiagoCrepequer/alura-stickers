import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ReadProperties props = new ReadProperties();

        var http = new ClienteHttp();
        String json = http.buscaDados(props.getProps("NASA2"));

        ExtratorConteudo extrator = new ExtratorConteudoNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        var gerador = new ImageFactory();
        

        for(int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
            String nomeArquivo = conteudo.getTitulo();

            gerador.create(nomeArquivo, inputStream);
        }
    }
}