package LG1MKAgent;

import com.sun.istack.internal.Nullable;
import LG1MKAgent.Enums.Player;
/**
 * Created by Varuna on 12/11/2014.
 * Updated by Daniel Hopkins on 17/11/2014
 */
public class Move
{
    private Player _madeBy;
    private int _move;

    public Move(Player madeBy, int move)
    {
        _madeBy = madeBy;
        _move = move;
    }
    @Override
    public String toString()
    {
        if (_move == 8)
            return "SWAP";
        else
            return "MOVE;" + Integer.toString(_move);
    }
}