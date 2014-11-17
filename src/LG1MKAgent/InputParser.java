package LG1MKAgent;

import LG1MKAgent.Enums.Player;
import LG1MKAgent.Enums.PlayerPosition;
/**
 * Created by Varuna on 12/11/2014.
 * Updated by Daniel Hopkins on 17/11/2014
 */
public class InputParser
{

    public static Player parseInputLine(String line, GameTreeBuilder gameTreeBuilder) throws Exception {
        if (line == null || !line.contains(";"))
        {
            throw new IllegalArgumentException("line");
        }
        String[] commands = line.split(";");
        Player nextPlayer = Player.Opponent;
        if (commands[0].equals("START"))
        {
            if (commands.length != 2)
            {
                throw new IllegalArgumentException(("line"));
            }
            gameTreeBuilder.initialise(PlayerPosition.valueOf(commands[1]));
        }
        else
        {
            if (commands[0].equals("CHANGE")) {
                if (commands.length != 4) {
                    throw new IllegalArgumentException(("line"));
                }
                Move move = getMove(commands[1]);
                nextPlayer = getPlayer(commands[3]);
                gameTreeBuilder.updateMoves(move, nextPlayer);
            }
        }
//else -> exception ?
        return nextPlayer;
    }
    private static Move getMove(String strMoveSwap)
    {
        Player _currentPlayer = null;
        Move move;
        try
        {
            int nextMove = Integer.parseInt(strMoveSwap);
            move = new Move(_currentPlayer, nextMove);
        }
        catch (NumberFormatException ex)
        {
            move = new Move(_currentPlayer, 8);
        }
        return move;
    }
    private static Player getPlayer(String player)
    {
        Player _currentPlayer;
        if (player.equals("OPP"))
        {
            _currentPlayer = Player.Opponent;
        }
        else if (player.equals(("YOU")))
        {
            _currentPlayer = Player.ThisAgent;
        }
        else
        {
            throw new IllegalArgumentException(("player"));
        }
        return _currentPlayer;
    }
}