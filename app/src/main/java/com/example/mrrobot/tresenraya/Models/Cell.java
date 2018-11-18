package com.example.mrrobot.tresenraya.Models;

import com.example.mrrobot.tresenraya.Services.StringUtility;

public class Cell {

    public Player player;

    public Cell(Player player) {
        this.player = player;
    }

    public boolean isEmpty() {
        return player == null || StringUtility.isNullOrEmpty(player.value);
    }
}
