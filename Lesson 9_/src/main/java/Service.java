public interface Service {
    @Cache(fileNamePrefix = "dataCache", identityBy = {String.class,Integer.class})
    double doHardWork (String nameMethod, Integer param);
}
