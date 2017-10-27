public class ServiceImpl implements Service {

    //@Cache(fileNamePrefix = "dataCache", identityBy = {String.class,Integer.class})
    public double doHardWork(String nameMethod, Integer param) {
        return param*Math.random();
    }
}

