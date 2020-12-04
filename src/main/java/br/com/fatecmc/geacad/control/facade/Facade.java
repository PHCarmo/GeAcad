package br.com.fatecmc.geacad.control.facade;

import br.com.fatecmc.geacad.model.dao.*;
import br.com.fatecmc.geacad.model.domain.*;
import br.com.fatecmc.geacad.model.strategy.*;
import java.util.*;

public class Facade implements IFacade {
    private Map<String, IDAO> daos;
    private Map<String, List<IStrategy>> rns;

    public Facade() {
        initDAO();
        initStrategy();
    }

    private void initDAO() {
        daos = new HashMap<>();
        daos.put(Aluno.class.getName(), new AlunoDAO());
        daos.put(Curso.class.getName(), new CursoDAO());
        daos.put(Disciplina.class.getName(), new DisciplinaDAO());
        daos.put(Pessoa.class.getName(), new PessoaDAO());
        daos.put(Professor.class.getName(), new ProfessorDAO());
        daos.put(Turma.class.getName(), new TurmaDAO());
    }

    private void initStrategy() {
        rns = new HashMap<>();

        ValidarExistenciaAluno validar_existencia_aluno = new ValidarExistenciaAluno(); 
        ValidarGradeCurricularAluno validar_grade_curricular_aluno = new ValidarGradeCurricularAluno();
        ValidarLimiteAlunosTurma validar_limite_alunos_turma = new ValidarLimiteAlunosTurma();
        ValidarMatriculaAluno validar_matricula_aluno = new ValidarMatriculaAluno();
        
        List<IStrategy> rns_aluno = new ArrayList<>();
        rns_aluno.add(validar_existencia_aluno);
        
        List<IStrategy> rns_curso = new ArrayList<>();
        rns_curso.add(validar_matricula_aluno);
        
        List<IStrategy> rns_disciplina = new ArrayList<>();
        rns_disciplina.add(validar_grade_curricular_aluno);
        
        List<IStrategy> rns_pessoa = new ArrayList<>();
        
        List<IStrategy> rns_professor = new ArrayList<>();
        
        List<IStrategy> rns_turma = new ArrayList<>();
        rns_turma.add(validar_limite_alunos_turma);

        rns.put(Aluno.class.getName(), rns_aluno);
        rns.put(Curso.class.getName(), rns_curso);
        rns.put(Disciplina.class.getName(), rns_disciplina);
        rns.put(Pessoa.class.getName(), rns_pessoa);
        rns.put(Professor.class.getName(), rns_professor);
        rns.put(Turma.class.getName(), rns_turma);
    }
    
    private String processStrategys(EntidadeDominio entidade) {
        List<IStrategy> regras = rns.get(entidade.getClass().getName());

        StringBuilder final_message = new StringBuilder();
        if (regras != null) {
            for (IStrategy strategy : regras) {
                String message = strategy.process(entidade);

                if(message != null) {
                    final_message.append(message);
                    final_message.append("\n");
                }
            }
        }

        return(final_message.length() > 0) ? final_message.toString() : null;
    }
    
    @Override
    public String salvar(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            dao.salvar(entidade);
            return null;
        } else {
            return error_message;
        }
    }

    @Override
    public String alterar(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            dao.alterar(entidade);
            return null;
        } else {
            return error_message;
        }
    }

    @Override
    public String excluir(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            dao.excluir(entidade.getId());
            return null;
        } else {
            return error_message;
        }
    }

    @Override
    public Object consultar(EntidadeDominio entidade) {
        String error_message = processStrategys(entidade);
        if (error_message == null) {
            IDAO dao = daos.get(entidade.getClass().getName());
            int id = entidade.getId();
            if(id != 0)
                return dao.consultar(id);
            else
                return dao.consultar();
        } else {
            return error_message;
        }
    }
    
}
