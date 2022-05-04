package com.dio.santander.bankline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repository;
	public void save(NovaMovimentacao novaMovimentacao) {
		
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor=novaMovimentacao.getTipo()==MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setId(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		repository.save(movimentacao);
	}	
}
