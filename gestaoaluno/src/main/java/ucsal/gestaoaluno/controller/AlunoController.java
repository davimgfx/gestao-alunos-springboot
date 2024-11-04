package ucsal.gestaoaluno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ucsal.gestaoaluno.entity.Aluno;
import ucsal.gestaoaluno.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping("/add")
	public Aluno create(@RequestBody Aluno aluno) {
		return alunoService.create(aluno);
	}

	@GetMapping("/all")
	public List<Aluno> findAll(){
		return alunoService.findAll();
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id) {
		Optional<Aluno> aluno = alunoService.findById(id);
		return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
		Optional<Aluno> updatedAluno = alunoService.update(id, aluno);
		return updatedAluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (alunoService.delete(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
