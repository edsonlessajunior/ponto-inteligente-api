package br.unisul.pontointeligente.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import br.unisul.pontointeligente.api.enums.TipoEnum;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = -1519375019553217731L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable=false)
	private Date data;
	
	@Column(name = "descricao", nullable=true)
	private String descricao;
	
	@Column(name = "localizacao", nullable=true)
	private String localizacao;
	
	@Column(name="data_atualizacao", nullable=false)
	private Date dataAtualizacao;
	
	@Column(name="data_criacao", nullable=false)
	private Date dataCriacao;
	
	@Enumerated(EnumType.STRING)
	private TipoEnum tipo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Funcionario funcionario;
	
	public Lancamento() {
		
	}
	
	@PreUpdate
	public void preUpdate() {
		this.dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		this.dataCriacao = new Date();
		this.dataAtualizacao=(Date) this.dataCriacao.clone();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public TipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", data=" + data + ", descricao=" + descricao + ", localizacao=" + localizacao
				+ ", dataAtualizacao=" + dataAtualizacao + ", dataCriacao=" + dataCriacao + ", tipo=" + tipo
				+ ", funcionario=" + funcionario + "]";
	}


}
