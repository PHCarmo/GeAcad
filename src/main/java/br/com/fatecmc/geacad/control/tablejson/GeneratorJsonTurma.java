package br.com.fatecmc.geacad.control.tablejson;

import br.com.fatecmc.geacad.model.domain.*;
import java.util.List;

public class GeneratorJsonTurma implements IGeneratorJson {

    @Override
    public String gerar(List<EntidadeDominio> entidades) {
        String json = "{\"data\":[]}";
        String data = "";
        if(!(entidades.isEmpty())) {
            int totalLista = entidades.size();
            int cont = 1;
            for(EntidadeDominio e: entidades) {
                Turma t = (Turma) e;
                data += " ["
                    +"\""+ t.getId() + "\","
                    +"\""+ t.getDescricao() + "\","
                    +"\""+ t.getData_inicio()+ "\","
                    +"\""+ t.getCurso().getId() + "\","
                    +"\"<a href='/geacad/FormTurma.jsp"
                    +"?descricao="+ t.getDescricao()
                    +"&datainicio="+ t.getData_inicio()
                    +"&curso="+ t.getCurso().getId()
                    +"&id="+ t.getId()
                    +"'>Atualizar</a>\","
                    +"\"<a href='/geacad/Turma?operacao=EXCLUIR"
                    +"&id="+ t.getId()
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
