package br.com.fatecmc.geacad.control.tablejson;

import br.com.fatecmc.geacad.model.domain.*;
import java.util.List;

public class GeneratorJsonCurso implements IGeneratorJson {

    @Override
    public String gerar(List<EntidadeDominio> entidades) {
        String json = "{\"data\":[]}";
        String data = "";
        if(!(entidades.isEmpty())) {
            int totalLista = entidades.size();
            int cont = 1;
            for(EntidadeDominio e: entidades) {
                Curso c = (Curso) e;
                data += " ["
                    +"\""+ c.getId() + "\","
                    +"\""+ c.getNome() + "\","
                    +"\""+ c.getTurno() + "\","
                    +"\""+ c.getDescricao() + "\","
                    +"\""+ c.getDuracao()+ "\","
                    +"\"<a href='/geacad/FormCurso.jsp"
                    +"?nome="+ c.getNome()
                    +"&turno="+ c.getTurno()
                    +"&descricao="+ c.getDescricao()
                    +"&duracao="+ c.getDuracao()
                    +"&id="+ c.getId()
                    +"'>Atualizar</a>\","
                    +"\"<a href='/geacad/Curso?operacao=EXCLUIR"
                    +"&id="+ c.getId()
                    +"'>Deletar</a>\""
                    +"]";
                if(cont < totalLista){
                    data += ",";
                }
                cont++;
            }
            json = "{"
                + "  \"draw\": 1,"
                + "  \"recordsTotal\": "+ entidades.size() +","
                + "  \"recordsFiltered\": "+ entidades.size() +","
                + "  \"data\": ["+
                data +
                "]"+
                "}";
        }
        return json;
    }

}
