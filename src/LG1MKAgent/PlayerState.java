package LG1MKAgent;

import LG1MKAgent.Enums.PlayerPosition;

import java.util.Arrays;
/**
 * Created by Varuna on 12/11/2014.
 * Updated by Daniel Hopkins on 17/11/2014
 */
public class PlayerState
{
    private PlayerPosition _playerPosition;

    public PlayerState(PlayerPosition playerPosition)
    {
        _playerPosition = playerPosition;
    }

    public void swap()
    {
        if (_playerPosition == PlayerPosition.North)
        {
            _playerPosition = PlayerPosition.South;
        }
        else
        {
            _playerPosition = PlayerPosition.North;
        }
    }

}