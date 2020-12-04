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

        ExemploRN exemplo = new ExemploRN();
        
        ValidarExistenciaRN validarExistencia = new ValidarExistenciaRN(); 
        ValidarGradeCurricularAlunoRN ValidarGradeAluno = new ValidarGradeCurricularAlunoRN();
        ValidarLimiteAlunosNaTurmaRN validarLimiteAlunos = new ValidarLimiteAlunosNaTurmaRN();
        ValidarMatriculaAlunoRN validarMatriculaMesmoCurso = new ValidarMatriculaAlunoRN();
        

        List<IStrategy> rns_aluno = new ArrayList<>();
        rns_aluno.add(validarExistencia);
        
        List<IStrategy> rns_curso = new ArrayList<>();
        rns_curso.add(validarMatriculaMesmoCurso);
        
        List<IStrategy> rns_disciplina = new ArrayList<>();
        rns_disciplina.add(ValidarGradeAluno);
        
        List<IStrategy> rns_pessoa = new ArrayList<>();
        rns_pessoa.add(exemplo);
        
        List<IStrategy> rns_professor = new ArrayList<>();
        rns_professor.add(exemplo);
        
        List<IStrategy> rns_turma = new ArrayList<>();
        rns_turma.add(validarLimiteAlunos);

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
        return null;
    }

    @Override
    public String excluir(EntidadeDominio entidade) {
        return null;
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        return null;
    }
    
}
