package br.com.fatecmc.geacad.control.tablejson;

import br.com.fatecmc.geacad.model.domain.*;
import java.util.List;

public class GeneratorJsonAluno implements IGeneratorJson {

    @Override
    public String gerar(List<EntidadeDominio> entidades) {
        String json = "{\"data\":[]}";
        String data = "";
        if(!(entidades.isEmpty())) {
            int totalLista = entidades.size();
            int cont = 1;
            for(EntidadeDominio e: entidades) {
                Aluno a = (Aluno) e;
                data += " ["
                    +"\""+ a.getId() + "\","
                    +"\""+ a.getStatus()+ "\","
                    +"\""+ a.getRa() + "\","
                    +"\""+ a.getTurma().getId() + "\","
                    +"\""+ a.getNome() + "\","
                    +"\""+ a.getEmail()+ "\","
                    +"\""+ a.getRg()+ "\","
                    +"\""+ a.getCpf()+ "\","
                    +"\""+ a.getData_nascimento()+ "\","
                    +"\""+ a.getSexo()+ "\","
                    +"\"<a href='/geacad/FormAluno.jsp"
                    +"?status="+ a.getStatus()
                    +"&ra=" +a.getRa()
                    +"&turma="+ a.getTurma().getId()
                    +"&pessoa="+ a.getId_pessoa()
                    +"&nome="+ a.getNome()
                    +"&email="+ a.getEmail()
                    +"&rg="+ a.getRg()
                    +"&cpf="+ a.getCpf()
                    +"&datanasc="+ a.getData_nascimento()
                    +"&sexo="+ a.getSexo()
                    +"&id="+ a.getId()
                    +"'>Atualizar</a>\","
                    +"\"<a href='/geacad/Aluno?operacao=EXCLUIR"
                    +"&id="+ a.getId()
                    +"&pessoa="+ a.getId_pessoa()
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
