package com.ps.player_stats.player;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, String> {

    List<Player> findByTeamIgnoreCase(String team);

    List<Player> findByPosIgnoreCase(String pos);

    List<Player> findByNationIgnoreCase(String nation);

    List<Player> findByNameContainingIgnoreCase(String name);

    List<Player> findByTeamIgnoreCaseAndPosIgnoreCase(String team, String pos);

}