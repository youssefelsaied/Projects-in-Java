import javafx.scene.canvas.GraphicsContext;
import org.w3c.dom.Element;

public interface ICommandStory {
     void draw(GraphicsContext gc);
     void movef(GraphicsContext gc,String s);
     void mover(GraphicsContext gc,String s);
     void resetGame(GraphicsContext gc);
     void save();
     void readxml(GraphicsContext gc);
     void undo(GraphicsContext gc);
     void redo(GraphicsContext gc);
     boolean canUndo();
     boolean canRedo();
}
