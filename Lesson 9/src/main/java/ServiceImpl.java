import java.io.Serializable;

public class ServiceImpl implements Service, Serializable{


    @Cache(fileNamePrefix = "data", identifyBy = {String.class, Double.class})
    public int doHardWork(String methodName, int param) {
        return (int) ( Math.random() * 100);

    }





}

