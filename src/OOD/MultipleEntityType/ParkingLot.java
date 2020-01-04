//package OOD.MultipleEntityType;
//import java.util.*;
///*
//      多entity类型
// */
//
///*               ParkingLot              */
//public class ParkingLot {
//    private final Level[] levels;     //停车场有多少层
//    public ParkingLot(int numlevels, int numSpotsPerLevel) {
//
//    }
//
//    //当前parkinglot还有没有parkingSpot
//    public boolean hasSpot(Vehicle v) {
//    }
//    //当前parkinglot能不能成功park
//    public boolean park(Vehicle v) {
//    }
//    //当前parkinglot能不能成功leave
//    public boolean leave(Vehicle v) {
//    }
//
//
//    class Level {
//        private final List<ParkingSpot> spots;
//        Level(int numOfSpots) {
//
//        }
//
//        //当前level还有没有parkingSpot
//        boolean hasSpot(Vehicle v) {
//        }
//        //当前level能不能成功park
//        boolean park(Vehicle v) {
//        }
//        //当前level能不能成功leave
//        boolean leave(Vehicle v) {
//        }
//    }
//
//    class ParkingSpot {
//        private final VehicleSize size;  //当前parkingSpot能够停的vehicle的最大size是多少
//        private Vehicle currentVehicle;  //当前parkingSpot中停放的车辆size是多大
//
//        ParkingSpot(VehicleSize size) {
//        }
//
//        //进来的车辆parkingSpot能不能放下
//        boolean fit(Vehicle v) {
//        }
//        //进来的车辆parkingSpot能不能停放
//        void park(Vehicle v) {
//        }
//        //进来的车辆parkingSpot能不能离开
//        void leave() {
//        }
//        //拿到当前parkingSpot中停放的车辆
//        Vehicle getVehicle() {
//        }
//    }
//}
//
//public abstract class Vehicle {
//    public abstract VehicleSize getSize();
//}
//
//public class Car extends Vehicle {
//    @Override
//    public VehicleSize getSize() {
//
//    }
//}
//
//public class Truck extends Vehicle {
//    @Override
//    public VehicleSize getSize() {
//
//    }
//}
//
//public enum VehicleSize {
//    Compact(1),
//    Large(2);
//    private final int size;
//
//    VehicleSize(int size) {
//    }
//
//    public int getSize() {
//    }
//}
//
//
//
//
