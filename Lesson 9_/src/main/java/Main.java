
public class Main  {
    public static void main(String[] args)  {


  //Service service = CacheProxy.cache((Service) new ServiceImpl());
        CacheProxy proxy = new CacheProxy(new ServiceImpl());
       Service service = proxy.cache(Service.class);


       System.out.println(service.doHardWork("work1", 10));
       System.out.println(service.doHardWork("work2", 5));
       System.out.println(service.doHardWork("work1", 10));

    }
}
