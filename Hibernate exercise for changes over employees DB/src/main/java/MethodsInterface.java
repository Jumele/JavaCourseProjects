import model.Angajat;

import java.util.List;

public interface MethodsInterface {

    List<Angajat> displayAll();

    List<Angajat> displaySelective(String criteriu);

    boolean insert(Angajat angajat);

    boolean modify(Angajat oldData, Angajat newData);

    boolean delete(Angajat angajat);
}

