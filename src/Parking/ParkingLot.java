//package Parking;
//import java.util.*;
//
//// parkinglots 里有level 和 parkingspot
//public class ParkingLot {
//    private final Level[] levels;
//
//    public ParkingLot(int numLevels, int numSpotsPerLevel) {
//        levels = new Level[numLevels];
//        for (int i = 0; i < numLevels; i++) {
//            levels[i] = new Level(numSpotsPerLevel);
//        }
//    }
//    public boolean hasSpot(Vehicle v) {
//        for (Level l : levels) {
//            if (l.hasSpot(v)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean park(Vehicle v) {
//        for (Level l : levels) {
//            if (l.park(v)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean leave(Vehicle v) {
//        for (Level l : levels) {
//            if (l.leave(v)) {
//                return true;
//            }
//        }return false;
//    }
//
//
//    class ParkingSpot {
//        private final VehicleSize size;
//        private Vehicle currentVehicle;  //初始每个parkingSpot都没有放东西，都是null，所以constructor中不用初始化
//
//        ParkingSpot(VehicleSize size) {
//            this.size = size;
//        }
//
//        boolean fit(Vehicle v) {
//            return currentVehicle == null && size.getSize() >= v.getSize(); /** record a vehicle is parked in by updating the currentVehicle field */
//        }
//
//        void park(Vehicle v) {
//            currentVehicle = v;
//        }
//        void leave() {
//            currentVehicle = null;
//        }
//        Vehicle getVehicle() {
//            return currentVehicle;
//        }
//    }
//
//    class Level {
//        private final List<ParkingSpot> spots;
//
//        Level(int numOfSpots) {
//            List<ParkingSpot> list = new ArrayList<>(numOfSpots);
//            int i = 0;
//            for (; i < numOfSpots / 2; i++) {
//                list.add(new ParkingSpot(VehicleSize.Compact));
//            }
//            for (; i < numOfSpots; i++) {
//                list.add(new ParkingSpot(VehicleSize.Large));
//            }
//            spots = Collections.unmodifiableList(list);
//        }
//
//        boolean hasSpot(Vehicle v) {
//            for (ParkingSpot s :spots) {
//                if (s.fit(v)) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        boolean park(Vehicle v) {
//            for (ParkingSpot s: spots) {
//                if (s.fit(v)) {
//                    s.park(v);
//                    return true;
//                }
//            }
//            return false;
//        }
//        boolean leave(Vehicle v) {
//            for (ParkingSpot s: spots) {
//                if (s.getVehicle() == v) {
//                    s.leave();
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//}