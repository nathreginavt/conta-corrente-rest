package com.br.fatecrl.conta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fatecrl.conta.model.PessoaFisica;
import com.br.fatecrl.conta.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService implements IService<PessoaFisica> {
	@Autowired
	private PessoaFisicaRepository repository;

	public PessoaFisicaService() {
	}

	@Override
	public PessoaFisica findById(Long id) {
		Optional<PessoaFisica> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<PessoaFisica> findAll() {
		return repository.findAll();
	}

	@Override
	public PessoaFisica create(PessoaFisica pessoaFisica) {
		repository.save(pessoaFisica);
		return pessoaFisica;
	}

	@Override
	public boolean update(PessoaFisica pessoaFisica) {
		if (repository.existsById(pessoaFisica.getId())) {
			repository.save(pessoaFisica);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
