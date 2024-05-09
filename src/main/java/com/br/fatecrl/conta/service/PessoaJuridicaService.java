package com.br.fatecrl.conta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fatecrl.conta.model.PessoaJuridica;
import com.br.fatecrl.conta.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService implements IService<PessoaJuridica> {
	@Autowired
	private PessoaJuridicaRepository repository;

	public PessoaJuridicaService() {
	}

	@Override
	public PessoaJuridica findById(Long id) {
		Optional<PessoaJuridica> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<PessoaJuridica> findAll() {
		return repository.findAll();
	}

	@Override
	public PessoaJuridica create(PessoaJuridica pessoaJuridica) {
		repository.save(pessoaJuridica);
		return pessoaJuridica;
	}

	@Override
	public boolean update(PessoaJuridica pessoaJuridica) {
		if (repository.existsById(pessoaJuridica.getId())) {
			repository.save(pessoaJuridica);
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
