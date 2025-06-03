package br.com.alura.Screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //tudo que não for da lista abaixo, não sera convertido.
public record DadosSerie(@JsonAlias("Title") String titulo,

                         @JsonAlias("totalSeasons") Integer totalTemporadas,

                         @JsonAlias("imdbRating") String avaliacao,

                         @JsonAlias("Genre") String genero,

                         @JsonAlias("Actors") String atores,

                         @JsonAlias("Poster") String poster,

                         @JsonAlias("Plot") String sinopse){
}
