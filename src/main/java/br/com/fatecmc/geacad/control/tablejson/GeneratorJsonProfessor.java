package br.com.fatecmc.geacad.control.tablejson;

import br.com.fatecmc.geacad.model.domain.*;
import java.util.List;

public class GeneratorJsonProfessor implements IGeneratorJson{

    @Override
    public String gerar(List<EntidadeDominio> entidades) {
        String json = "{\"data\":[]}";
        String data = "";
        if(!(entidades.isEmpty())) {
            int totalLista = entidades.size();
            int cont = 1;
            for(EntidadeDominio e: entidades) {
                Professor p = (Professor) e;
                data += " ["
                    +"\""+ p.getId() + "\","
                    +"\""+ p.getSalario()+ "\","
                    +"\""+ p.getTitulacao() + "\","
                    +"\""+ p.getNome() + "\","
                    +"\""+ p.getEmail()+ "\","
                    +"\""+ p.getRg()+ "\","
                    +"\""+ p.getCpf()+ "\","
                    +"\""+ p.getData_nascimento()+ "\","
                    +"\""+ p.getSexo()+ "\","
                    +"\"<a href='/geacad/FormProfessor.jsp"
                    +"?salario="+ p.getSalario()
                    +"&titulacao="+ p.getTitulacao()
                    +"&pessoa="+ p.getId_pessoa()
                    +"&nome="+ p.getNome()
                    +"&email="+ p.getEmail()
                    +"&rg="+ p.getRg()
                    +"&cpf="+ p.getCpf()
                    +"&datanasc="+ p.getData_nascimento()
                    +"&sexo="+ p.getSexo()
                    +"&id="+ p.getId()
                    +"'>Editar</a>\","
                    +"\"<a href='/geacad/Professor?operacao=EXCLUIR"
                    +"&id="+ p.getId()
                    +"&pessoa="+ p.getId_pessoa()
                    +"'>Excluir</a>\""
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
