package ucsal.gestaoaluno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucsal.gestaoaluno.entity.Aluno;
import ucsal.gestaoaluno.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno create(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public Optional<Aluno> findById(Long id) {
		return alunoRepository.findById(id);
	}

	public Optional<Aluno> update(Long id, Aluno aluno) {
		return alunoRepository.findById(id).map(existingAluno -> {
			existingAluno.setNome(aluno.getNome());
			existingAluno.setMatricula(aluno.getMatricula());
			existingAluno.setSemestre(aluno.getSemestre());
			return alunoRepository.save(existingAluno);
		});
	}

	public boolean delete(Long id) {
		if (alunoRepository.existsById(id)) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
