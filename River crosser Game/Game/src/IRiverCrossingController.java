import java.util.List;

public interface IRiverCrossingController{

public void  newGame​(ICrossingStrategy gameStrategy);

public void resetGame();

public String[] getInstruction();

public List<ICrosser> getCrossersOnRightBank​();

public List<ICrosser> getCrossersOnLeftBank​();

public boolean isBoatOnTheLeftBank();

public int getNumberOfSails​();

public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank);

public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank);

public boolean canUndo();

public boolean canRedo();

public void Undo();

public void redo();
}



