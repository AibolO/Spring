package com.example.sportsmaster.services;

import com.example.sportsmaster.model.Tournament;
import com.example.sportsmaster.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    public Tournament findOne(int id) {
        Optional<Tournament> foundTournament = tournamentRepository.findById(id);
        return foundTournament.orElse(null);
    }
}
