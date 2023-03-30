import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo {
    public List<Conteudo> extraiConteudos(String json) {
        var parser = new JsonParser();
        List<Map<String, String>> listaAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();
        
        for (Map<String, String> atributos : listaAtributos) {
            String titulo = atributos.get("title");
            String urlImage = atributos.get("url");

            var conteudo = new Conteudo(titulo, urlImage);

            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
