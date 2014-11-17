package LG1MKAgent;

import LG1MKAgent.Enums.Player;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by Varuna on 12/11/2014.
 * Updated by Daniel Hopkins on 17/11/2014
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String inputLine = bufferedReader.readLine();
        GameTreeBuilder gameTreeBuilder = new GameTreeBuilder();
        Agent agent = new Agent();
        Player nextPlayer = null;
        while (!inputLine.contains("END"))
        {
            try
            {
                nextPlayer = InputParser.parseInputLine(inputLine, gameTreeBuilder);?????
                if (nextPlayer == Player.ThisAgent)
                {
                    MoveSwap nextMove = agent.getNextMove(gameState);
                    System.out.println(nextMove.toString());
                }
            }
            catch (Exception ex)
            {
//Implement fallback
            }
            inputLine = bufferedReader.readLine();
        }
    }
}