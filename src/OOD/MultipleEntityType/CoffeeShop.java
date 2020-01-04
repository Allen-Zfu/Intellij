//package OOD.MultipleEntityType;
//import java.util.*;
///**
// * 设计流程：
// * 过work flow
// * 找到public API
// * 返回workflow，找到entities，即找到需要抽象出来的class
// * 将public method放在对应的class中，并且思考其它的class都需要哪些method
// * 最后根据method具体需要做的事情，填上class中需要用到的field
// *
// */
//
///**
//design coffee shop
//        work flow->how customer use this system-> public APIs->check work flow(entities)->entities method->follow up(add class)
//
//        customer -> coffee shop->[[ buy coffee->select coffee->payment->(wait time-)>(get coffee)]]
//Core Public API:
//        select(coffee type)
//        pay(coffee type)
////showWaitTime(requestId)
// **/
//
//class CoffeeShop{
//    Set<String> menu;   //coffeeName
//    Enum payment;
//    public Order select(String coffeeName) {
//        // search
//        //if (menu.contains(coffeeName))
//
//        // generate order
//    }
//    public boolean pay(Order order) {
//        // select payment method
//
//        // pay
//    }
//}
//
//class Coffee {
//    String coffeName;
//    int price;
//}
//
//class Order {
//    String orderId;
//    List<Coffee> orderList;  //一个订单中总共定了哪些coffee
//}
//
//enum PaymentMethod {
//    card,
//    cash,
//    check;
//}
