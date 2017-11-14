
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CahedCalc implements InvocationHandler {
    Object target;
    private Object ob;

    public CahedCalc(Object target) {
        this.target = target;
    }

    private static void writeCache( Connection conn, CreateCalc calc) {

        String query = " insert into CACHECALC (VALUE1, OPERATOR, VALUE2, RESULT)"  + " values (?, ?, ?, ?)";

        try (PreparedStatement statement =conn.prepareStatement(query);){
            statement.setDouble(1, calc.a);
            statement.setString(2, calc.operator);
            statement.setDouble(3, calc.b);
            statement.setDouble(4, calc.result);
            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }




    }





    private static List<CreateCalc> readCache(Statement st) throws IOException {
        ResultSet resultSet = null;
        StringBuilder str = new StringBuilder();
        List<CreateCalc> listCalc = new ArrayList<CreateCalc>();
        try {
            resultSet = st.executeQuery("SELECT * FROM CACHECALC");
            while (resultSet.next()){
                Double a = resultSet.getDouble("VALUE1");
                String operator = resultSet.getString("OPERATOR");
                Double b = resultSet.getDouble("VALUE2");
                Double res = resultSet.getDouble("RESULT");
                CreateCalc newCalc = new CreateCalc( a, b, operator, res);
                listCalc.add(newCalc);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }




        return listCalc;
    }


    @Override //метод который проверяет есть ли в кеше ето
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        boolean checkcache = false;
        try {
            Class.forName("org.h2.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test",
                    "sa", "");
            Statement st = null;
            st = conn.createStatement();


            if (!method.isAnnotationPresent(Cache.class)) {
                return method.invoke(target, args); //здесь, если метод не аннотирован, то он просто выполняется
            } else {
                CreateCalc calc = new CreateCalc((Double) args[0],(Double) args[2], (String) args[1], null);

                List<CreateCalc> list = readCache(st);//читаем из БД
                if (!(list.size() == 0 )) {
                    for (int i = 0; i < list.size(); i++) {
                        if ( ((list.get(i)).a.equals(calc.a) ) &&
                                ((list.get(i)).b.equals(calc.b) ) &&
                                ((list.get(i))).operator.equals(calc.operator)) {
                            checkcache = true;
                            System.out.println(list.get(i).result + " from cache");
                            res = new Double(list.get(i).result);
                            break;

                        }
                        } }

                 else {
                    res = method.invoke(target, args);
                    calc.result = (Double) res;
                    writeCache(conn, calc );



                }
                if (!checkcache){
                    res = method.invoke(target, args);
                    calc.result = (Double) res;
                    writeCache(conn, calc );
                }

            }



            st.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }





        return res;

    }
}



