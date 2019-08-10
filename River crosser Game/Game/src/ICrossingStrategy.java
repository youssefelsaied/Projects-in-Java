import java.util.List;

public interface ICrossingStrategy {

     boolean isvalid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders);

     List<ICrosser> getInitialCrosser ();

      String   getInstructions();


}