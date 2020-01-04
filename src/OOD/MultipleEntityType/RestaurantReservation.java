//package OOD.MultipleEntityType;
//import java.util.*;
//
///**
// * main function:
// * users: - call to make reservation:
// *              - time slot
// *              - username
// *              - # of parties
// *              - phone#
// *              - extra request.....
// *        - restaurant can tell user:
// *              - successful or not
// *        - check tables' availability
// *              - time slot
// *              - username
// *              - # of parties
// *              - phone#
// *        - restaurant can tell user:
// *              - available or not
// *        - call to reschedule an existing reservation
// *        - call to cancel an existing reservation
// *        - notification
// *        - check-in the reservation
// *
// *
// * Work Flow:
// * user -> send reservation request -> return reservation confirmation
// *          [            reservation system method                   ]
// *  table, ble reservation ability, notification manager
// */
//
///**每个用户的信息 **/
//class User {
//    long userId;
//    String name;
//    String phoneNumber;
//}
//
///** 一个reservation的时间段 **/
//class TimeSpan {
//    long start;
//    long end;
//}
//
///** 用户发送的一个预订申请 **/
//class ReservationRequest {
//    TimeSpan interval;
//    long userId;
//    int numParties;  //共有多少个人
//}
//
///** 返回的一个预订信息 **/
//class ReservationConfirmation {
//    long id;
//    List<Long> tables;              //可预订的桌子
//    ReservationRequest request;
//}
//
///**  一张桌子的信息 **/
//class Table {
//    long tableId;
//    int capacity;   //table最多能坐的人数
//    boolean isAvailableNow;
//    Collection<ReservationConfirmation> bookedConfirmations;
//}
//
///**  管理所有的桌子 **/
//class TableAvailabilityManager {
//    Collection<Table> tables;
//    Table reserve(ReservationRequest request) {
//
//    }
//    boolean isAvailable(ReservationRequest request) {
//
//    }
//}
//
///**  管理预订过程 **/
//class ReservationSystem {
//    String restaurantName;
//    String address;
//    String phoneNum;
//    TableAvailabilityManager tableManager;
//
//    public ReservationConfirmation makeReservation(ReservationRequest request) {
//
//    }
//
//    public boolean checkAvailability(ReservationRequest request) {
//
//    }
//}
//
////public class RestaurantReservation {
////}
//
//
