package br.com.alura.Screenmatch.service;

import br.com.alura.Screenmatch.dto.SerieDTO;
import br.com.alura.Screenmatch.model.Serie;
import br.com.alura.Screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {
    @Autowired
    private SerieRepository repositorio;

    public List<SerieDTO> obterTodasAsSeries(){
        return conversorDTO(repositorio.findAll());
    }

    public List<SerieDTO> obterTop5Series(){
        return conversorDTO(repositorio.findTop5ByOrderByAvaliacaoDesc());
    }

    private List<SerieDTO> conversorDTO (List<Serie> series){
        return series.stream()
                .map(s -> new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse()))
                .collect(Collectors.toList());
    }
}
