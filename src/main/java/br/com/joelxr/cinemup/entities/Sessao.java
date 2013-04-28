package br.com.joelxr.cinemup.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Entidade que representa uma sessão de cinema.
 *
 * @author joelxr
 * @since 2013-04-09
 */
@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_sessao")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cd_filme")
    private Filme filme;
    @Column(name = "data_sessao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Column(name = "hora_fim")
    private String horaFim;
    @Column(name = "legendado")
    private boolean legendado;
    @Column(name = "exibicao3d")
    private boolean exibicao3d;

    @Override
    public String toString() {
        return filme.getNome() + " (" + getHoraInicio() + " - " + getHoraFim()
                + ")";
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isLegendado() {
        return legendado;
    }

    public void setLegendado(boolean legendado) {
        this.legendado = legendado;
    }

    public boolean isExibicao3d() {
        return exibicao3d;
    }

    public void setExibicao3d(boolean exibicao3d) {
        this.exibicao3d = exibicao3d;
    }
}
