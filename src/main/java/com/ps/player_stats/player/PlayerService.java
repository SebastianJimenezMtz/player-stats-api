package com.ps.player_stats.player;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String team) {
        return playerRepository.findByTeamIgnoreCase(team);
    }

    public List<Player> getPlayersByName(String name) {
        return playerRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Player> getPlayersByPos(String pos) {
        return playerRepository.findByPosIgnoreCase(pos);
    }

    public List<Player> getPlayersByNation(String nation) {
        return playerRepository.findByNationIgnoreCase(nation);
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String pos) {
        return playerRepository.findByTeamIgnoreCaseAndPosIgnoreCase(team, pos);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findById(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setNation(updatedPlayer.getNation());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setPos(updatedPlayer.getPos());
            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    public void deletePlayer(String playerName) {
        playerRepository.deleteById(playerName);
    }
}