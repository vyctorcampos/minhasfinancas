package com.jvyctor.minhasfinancas.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.example.minhasfinancas.model.enums.StatusLancamento;
import com.example.minhasfinancas.model.enums.TipoLancamento;

import lombok.Builder;
import lombok.Data;

@Entity
@Table( name = "lancamento", schema = "financas")
@Data
@Builder
public class Lancamento {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	
	@Column (name = "descricao")
	private  String descricao;
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "mes" )
	private Integer mes;
	
	@Column(name = "ano" )
	private Integer ano;
	
	
	@ManyToOne
	@JoinColumn ( name = "id_usuario ")
	private Usuario usuario;
	
	@Column(name= "Valor")
	private BigDecimal valor;
	
	@Column( name= "data_cadastro")
	@Convert( converter = Jsr310JpaConverters.class)
	private LocalDate dataCadastroDate;
	
	
	 	@Column (name = "tipo")
	 	@Enumerated ( value= EnumType.STRING)
		private TipoLancamento tipo;
	 	
	 	
	 	@Column (name= "tipo")
	 	@Enumerated ( value = EnumType.STRING)
	 	private StatusLancamento statusLancamento;
	 	
	
}
