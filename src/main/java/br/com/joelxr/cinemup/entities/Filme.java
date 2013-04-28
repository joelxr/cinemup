package br.com.joelxr.cinemup.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entidade que representa um filme.
 *
 * @author joelxr
 * @since 2013-04-09
 */
@Entity
@Table(name = "filme")
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_filme")
    private Integer id;
    @Column(name = "nome_filme")
    private String nome;
    @Column(name = "nome_original")
    private String nomeOriginal;
    @Column(name = "dsc_filme")
    private String descricao;
    @Column(name = "duracao_min")
    private Integer duracao;
    @Column(name = "censura")
    private Integer censura;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "filme_diretor", joinColumns = {
        @JoinColumn(name = "cd_filme")}, inverseJoinColumns = {
        @JoinColumn(name = "cd_diretor")})
    private List<Diretor> diretor;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "filme_ator", joinColumns = {
        @JoinColumn(name = "cd_filme")}, inverseJoinColumns = {
        @JoinColumn(name = "cd_ator")})
    private List<Ator> elenco;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "filme_genero", joinColumns = {
        @JoinColumn(name = "cd_filme")}, inverseJoinColumns = {
        @JoinColumn(name = "cd_genero")})
    private List<Genero> genero;
    @Column(name = "poster")
    @Lob
    private byte[] poster;


    @Override
    public String toString() {
       return getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getCensura() {
        return censura;
    }

    public void setCensura(Integer censura) {
        this.censura = censura;
    }

    public List<Diretor> getDiretor() {
        return diretor;
    }

    public void setDiretor(List<Diretor> diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getElenco() {
        return elenco;
    }

    public void setElenco(List<Ator> elenco) {
        this.elenco = elenco;
    }

    public List<Genero> getGenero() {
        return genero;
    }

    public void setGenero(List<Genero> genero) {
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }
}
