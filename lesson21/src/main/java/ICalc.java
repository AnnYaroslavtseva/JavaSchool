public interface ICalc{
    @Cache
    double readAndCalc(Double a,String operator, Double b);
}
