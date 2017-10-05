public interface ICalc{
    @Cache
    double readAndCalc(double a, double b, String operator);
}
