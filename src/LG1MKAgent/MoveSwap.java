package LG1MKAgent;

import LG1MKAgent.Enums.Player;
import com.sun.istack.internal.Nullable;
/**
 * Created by Varuna on 12/11/2014.
 * Updated by Daniel Hopkins on 17/11/2014
 */
public class MoveSwap
{
    private Player _madeBy;
    private boolean _isSwap;
    public boolean isSwap()
    {
        return _isSwap;
    }
    private int _move;
    public MoveSwap(Player madeBy, boolean isSwap)
    {
        _madeBy = madeBy;
        _isSwap = isSwap;
        _move = 0;
    }
    public MoveSwap(Player madeBy, int move)
    {
        _madeBy = madeBy;
        _isSwap = false;
        _move = move;
    }
    @Override
    public String toString()
    {
        if (_isSwap)
            return "SWAP";
        else
            return "MOVE;" + Integer.toString(_move);
    }
}