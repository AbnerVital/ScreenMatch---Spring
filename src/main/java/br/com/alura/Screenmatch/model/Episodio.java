package br.com.alura.Screenmatch.model;

import jakarta.persistence.*;

import java.time.DateTimeException;
import java.time.LocalDate;

@Entity
@Table (name = "episodios")
public class Episodio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer temporada;

    private String titulo;

    private Integer numeroEpisodio;

    private Double avaliacao;

    private LocalDate dataLancamento;

    @ManyToOne
    private Serie serie;

    private Episodio(){}

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.titulo();
        this.numeroEpisodio = dadosEpisodio.numero();

        try {
            this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
            this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
        } catch (NumberFormatException ex) {
            this.avaliacao = 0.0;
        } catch (DateTimeException ex) {
            this.dataLancamento = null;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNumeroEpsodio(Integer numeroEpsodio) {
        this.numeroEpisodio = numeroEpsodio;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }



    @Override
    public String toString() {
        // Formata a data para exibir de forma legível
        String dataFormatada = (dataLancamento != null) ? dataLancamento.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";

        return "temporada: " + temporada +
                " | titulo: " + titulo +
                " | numeroEpsodio: " + numeroEpisodio +
                " | avaliacao: " + avaliacao +
                " | dataLancamento: " + dataFormatada +
                " | série: " + (serie != null ? serie.getTitulo() : "N/A"); // Adicione o título da série também!
    }
}
