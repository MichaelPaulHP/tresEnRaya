package com.example.mrrobot.tresenraya.ui.game;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mrrobot.tresenraya.Models.Cell;
import com.example.mrrobot.tresenraya.Models.Game;
import com.example.mrrobot.tresenraya.Models.Player;
import android.databinding.ObservableArrayMap;

import static com.example.mrrobot.tresenraya.Services.StringUtility.stringFromNumbers;

public class GameViewModel extends ViewModel {

   public ObservableArrayMap<String, String> cells;
    private Game game;

    public void init(String player1, String player2) {
        game = new Game(player1, player2);
        cells = new ObservableArrayMap<>();
    }

    public void onClickedCellAt(int row, int column) {
        if (game.cells[row][column] == null) {
            game.cells[row][column] = new Cell(game.currentPlayer);
            cells.put(stringFromNumbers(row, column), game.currentPlayer.value);
            if (game.hasGameEnded())
                game.reset();
            else
                game.switchPlayer();
        }
    }

    public LiveData<Player> getWinner() {
        return game.winner;
    }
}
