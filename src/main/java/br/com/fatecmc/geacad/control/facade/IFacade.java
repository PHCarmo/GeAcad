package br.com.fatecmc.geacad.control.facade;

import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import java.util.List;

public interface IFacade {
    
    public String salvar(EntidadeDominio entidade);
    public String alterar(EntidadeDominio entidade);
    public String excluir(EntidadeDominio entidade);
    public List<EntidadeDominio> consultar(EntidadeDominio entidade);
    
}
