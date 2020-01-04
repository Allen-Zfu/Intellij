//package OOD.MultipleEntityType;
//
//import java.util.List;
//
///*
//modifier的讨论，三个层级的API 都可以设置成public的，其实对应的不同的use case，可能通过不同的use case体现出来
//*/
// */
//
///*     Amazon Locker      */
//public class Locker {
//    private final Cabinet[] cabinets;     //locker有哪些货柜
//    public Locker(int numCabinets, int numCubePerCabinet) {  //一个locker的cabinet数，一个cabinet的box数
//
//    }
//
//    //当前locker还有没有box
//    public boolean hasCube(Package p) {
//    }
//    //当前locker能不能成功storage
//    public boolean storage(Package p) {
//    }
//    //当前locker能不能成功pickup
//    public boolean pickup(Package p) {
//    }
//
//
//    class Cabinet {
//        private final List<Cube> cubes;
//        Cabinet(int numOfCubes) {
//
//        }
//
//        //当前Cabinet还有没有cube
//        boolean hasCube(Package p) {
//        }
//        //当前Cabinet能不能成功storage
//        boolean storage(Package p) {
//        }
//        //当前Cabinet能不能成功pickup
//        boolean pickup(Package p) {
//        }
//    }
//
//    class Cube {
//        private final PackageSize size;  //当前cube能够停的package的最大size是多少
//        private Package currentPackage;  //当前Cube中放的 package size是多大
//
//        Cube(PackageSize size) {
//        }
//
//        //进来的Pacakge能不能放下
//        boolean fit(Package p) {
//        }
//        //进来的Package能不能storage
//        void storage(Package p) {
//        }
//        //进来的package能不能pickup
//        void pickup() {
//        }
//        //拿到当前parkingSpot中停放的车辆
//        Vehicle getPackage() {
//        }
//    }
//}
//
//public abstract class Package {
//    public abstract PackageSize getSize();
//}
//
//public class Envolope extends Package {
//    @Override
//    public PackageSize getSize() {
//
//    }
//}
//
//public class Box extends Package {
//    @Override
//    public PackageSize getSize() {
//
//    }
//}
//
//public enum PackageSize {
//    Compact(1),
//    Large(2);
//    private final int size;
//
//    PackageSize(int size) {
//    }
//
//    public int getSize() {
//    }
//}
