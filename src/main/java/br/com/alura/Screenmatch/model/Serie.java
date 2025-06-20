package br.com.alura.Screenmatch.model;

import br.com.alura.Screenmatch.service.traducao.ConsultaMyMemory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 500)
    private String titulo;

    private Integer totalTemporadas;

    private Double avaliacao;
    @Enumerated(EnumType.STRING)

    private Categoria genero;

    @Column(length = 500)
    private String atores;

    @Column(length = 2000)
    private String poster;

    @Column(columnDefinition = "TEXT")
    private String sinopse;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios = new ArrayList<>();

    public Serie(){}

    public Serie (DadosSerie dadosSerie){
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse().trim());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Episodio> getEpisodio() {
        return episodios;
    }

    public void setEpisodio(List<Episodio> episodio) {
        this.episodios = episodio;
        episodio.forEach(e -> e.setSerie(this));
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Long getId() {
        return id;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    @Override
    public String toString() {
        return
                "Genero: " + genero + " | " +
                "Título: " + titulo + " | " +
                "Total Temporadas: " + totalTemporadas + " | " +
                "Avaliacao: " + avaliacao + " | " +
                "Atores: " + atores +  " | " +
                "Poster: " + poster +  " | " +
                "Sinópse: " + sinopse + " | " +
                        "Episodios: " + episodios;
    }
}
