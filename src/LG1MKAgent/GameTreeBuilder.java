package LG1MKAgent;

        import LG1MKAgent.Enums.Player;
        import LG1MKAgent.Enums.PlayerPosition;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
/**
 * Created by Varuna on 12/11/2014.
 * Updated by Daniel Hopkins on 17/11/2014
 */
public class GameTreeBuilder
{
    private PlayerState _thisAgent;
    private PlayerState _opponent;
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
    public void updateMoves(Move move, Player nextPlayer) throws Exception {
        throw NotImplementedException();
    }

    private Exception NotImplementedException()
    {
        return null;
    }

    private void swap()
    {
        _opponent.swap();
        _thisAgent.swap();
    }
}