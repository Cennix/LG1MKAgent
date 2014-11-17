package LG1MKAgent;

import LG1MKAgent.Enums.Player;
import LG1MKAgent.Enums.PlayerPosition;
import LG1MKAgent.Extensions.StringArray;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varuna on 12/11/2014.
 * Updated by Daniel Hopkins on 17/11/2014
 */
public class GameState
{
    private PlayerState _thisAgent;

    private PlayerState _opponent;

    private List<MoveSwap> _moves = new ArrayList<MoveSwap>();

    private Player _currentPlayer;

    public static final int constNumberOfSeedsAndPots = 7;

    public void initialise(PlayerPosition thisAgentsPlayerPosition)
    {
        _thisAgent = new PlayerState(thisAgentsPlayerPosition);
        if (thisAgentsPlayerPosition == PlayerPosition.North)
        {
            _opponent = new PlayerState(PlayerPosition.South);
        }
        else
        {
            _opponent = new PlayerState(PlayerPosition.North);
        }
    }

    public Player updateStateAndGetNextPlayer(String strMoveSwap, String strNumberOfSeedsInEachHoleForAll, String strNextTurn) throws IllegalArgumentException
    {
        MoveSwap moveSwap = getMoveSwap(strMoveSwap);
        addMove(moveSwap);
        if (moveSwap.isSwap())
        {
            swap();
        }
        updatePlayersNumberOfSeeds(strNumberOfSeedsInEachHoleForAll);
        updateCurrentPlayer(strNextTurn);
        return _currentPlayer;
    }

    private MoveSwap getMoveSwap(String strMoveSwap)
    {
        MoveSwap moveSwap;
        try
        {
            int move = Integer.parseInt(strMoveSwap);
            moveSwap = new MoveSwap(_currentPlayer, move);
        }
        catch (NumberFormatException ex)
        {
            moveSwap = new MoveSwap(_currentPlayer, true);
        }
        return moveSwap;
    }

    private void addMove(MoveSwap moveSwap)
    {
        _moves.add(moveSwap);
    }

    private void swap()
    {
        _opponent.swap();
        _thisAgent.swap();
    }

    private void updatePlayersNumberOfSeeds(String strNumberOfSeedsInEachHoleForAll) throws IllegalArgumentException
    {
        if (!strNumberOfSeedsInEachHoleForAll.contains(","))
        {
            throw new IllegalArgumentException("strNumberOfSeedsInEachHoleForAll");
        }

        String[] arrNumberOfSeedsInEachHoleForAll = strNumberOfSeedsInEachHoleForAll.split(",");
        int requiredNumberOfValues = 2 * (constNumberOfSeedsAndPots + 1);
        if (arrNumberOfSeedsInEachHoleForAll.length != requiredNumberOfValues)
        {
            throw new IllegalArgumentException("strNumberOfSeedsInEachHoleForAll");
        }

        int[] numberOfSeedsInEachHoleForAll = StringArray.toIntArray(arrNumberOfSeedsInEachHoleForAll);

        _opponent.updatePlayersNumberOfSeeds(numberOfSeedsInEachHoleForAll);
        _thisAgent.updatePlayersNumberOfSeeds(numberOfSeedsInEachHoleForAll);
    }

    private void updateCurrentPlayer(String strNextTurn) throws IllegalArgumentException
    {
        if (strNextTurn.equals("OPP"))
        {
            _currentPlayer = Player.Opponent;
        }
        else if (strNextTurn.equals(("YOU")))
        {
            _currentPlayer = Player.ThisAgent;
        }
        else
        {
            throw new IllegalArgumentException(("strNextTurn"));
        }
    }
}
