
import java.util.HashMap;
import java.util.Map;

    public class CahedCalc implements ICalc {
        private final Calc calculator;
        private final Map<Double, Double> resultByArg = new HashMap<>();

        public CachedCalculator(Calc calculator) {
            this.calculator = calculator;
        }

        @Override
        public int readAndCalc(double arg) {
            if (!resultByArg.containsKey(arg)) {
                double result = calculator.readAndCalc();
                resultByArg.put(arg, result);
            }

            return resultByArg.get(arg);
        }
    }

