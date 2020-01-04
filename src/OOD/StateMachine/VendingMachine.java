//package OOD.StateMachine;
//
//public class VendingMachine {
//}
//
///*    Vending Machine   */
///*
//状态图：vending machine包括
//1.currentStatus 有四个状态
//HAS_MONEY  //已投币状态
//NO_MONEY   //未投币状态
//SOLD       //商品成功售出状态
//SOLD_OUT   //商品售罄状态
//
//2.三个public的动作
//insertMoney  投币
//backMoney    退币
//turnCrank    转动手柄
//
//过程：
//【】状态
// () 动作
//
//        【NO_MONEY】   -->(insertMoney)   【HAS_MONEY】  -->(turnCrank)   【SOLD】  --> 商品数量 > 0  【NO_MONEY】
//                      <--(backMoney)                                              --> 商品数量 <=0  【SOLD_OUT】
// */
//
//public class VendingMachine {
//    private final static int HAS_MONEY = 0;
//    private final static int NO_MONEY = 1;
//    private final static int SOLD = 2;
//    private final static int SOLD_OUT = 3;
//    private int currentStatus = NO_MONEY;
//
//    //the number of product
//    private int count = 0;
//    public VendingMachine(int count) {
//        this.count = count;
//        if (count > 0) {
//            currentStatus = NO_MONEY;  //初始化current status
//        }
//    }
//
//    //投币：任何状态的用户都可以投币 (购买到前)
//    public void insertMoney() {
//        if (currentStatus == NO_MONEY) {
//            currentStatus = HAS_MONEY;
//            System.out.println("Insert Money Successfully!");
//        } else if (currentStatus == HAS_MONEY) {
//            System.out.println("Already has money, do not need to insert money again!");
//        } if (currentStatus == SOLD) {
//            System.out.println("Please Waiting for next Round......");  //这一轮等待商品掉落中，只能下一轮再insert money
//        } if (currentStatus == SOLD_OUT) {
//            System.out.println("Already sold out, do not do operation!");
//        }
//    }
//
//    //退币：任何状态的用户都有可能退币 (购买到后)
//    public void backMoney() {
//        if (currentStatus == NO_MONEY) {
//            System.out.println("do not has money......");
//        } else if (currentStatus == HAS_MONEY) {
//            currentStatus = NO_MONEY;
//            System.out.println("backMoney Successfully!");
//        } if (currentStatus == SOLD) {
//            System.out.println("You already bought product!");
//        } if (currentStatus == SOLD_OUT) {
//            System.out.println("Already sold out, do not do operation!");
//        }
//    }
//
//    //转动手柄：任何状态的=用户都可能转动手柄
//    public void turnCrank() {
//        public void backMoney() {
//            if (currentStatus == NO_MONEY) {
//                System.out.println("do not has money......");
//            } else if (currentStatus == HAS_MONEY) {
//                System.out.println("waiting....!");
//                currentStatus = SOLD;
//                dispense();               //发放商品
//            } if (currentStatus == SOLD) {
//                System.out.println("You already bought product!");
//            } if (currentStatus == SOLD_OUT) {
//                System.out.println("Already sold out, do not do operation!");
//            }
//        }
//    }
//
//    //发放商品
//    private void dispense() {
//        if (currentStatus == NO_MONEY || currentStatus == HAS_MONEY || currentStatus == SOLD_OUT) {
//            throw new IllegalStateException("cannot dispense product state!");
//        }
//        count--;
//        System.out.println("dispense production...");
//        if (count == 0) {
//            System.out.println("product sold out!");
//        } else {
//            currentStatus = NO_MONEY;
//        }
//    }
//}
//
//
