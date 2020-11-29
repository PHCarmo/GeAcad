package br.com.fatecmc.geacad.model.strategy;

import br.com.fatecmc.geacad.model.domain.EntidadeDominio;

public class ExemploRN implements IStrategy {

    @Override
    public String process(EntidadeDominio entidade) {
        boolean validacao_rn = false;
        
        if(validacao_rn)
            return "Mensagem de erro.";
        
        return null;
    }
    
}
