package stub;

import modele.Lapin;
import viewmodel.LapinVM;

public class LapinStub {

    public LapinVM lapinVM;

    public LapinStub(){
       lapinVM = new LapinVM(new Lapin("Wallace"));
    }
}
