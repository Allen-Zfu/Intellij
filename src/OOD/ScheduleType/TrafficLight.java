//package OOD.ScheduleType;
//import java.util.*;
//
///*
//http://www.flyne.org/article/266
//
// */
//在进入正题之前，先要知道面向对象设计中设计类时需要把握的一个重要的经验、原则：谁拥有数据，谁就对外提供操作这些数据的方法，这个经验对于交通灯系统中设计类时相当有帮助。为快速掌握这一设计原则，先来看几个例子：
//        ①人在黑板上画圆
//        Person，Blackboard，Circle
//        draw(){
//        x,y-->radius  //则该方法位于Circle中
//        }
//
//        ②列车司机紧急刹车
//        Train，Driver
//        brake(){
//        //则该方法位于Train中
//        }
//
//*/
// */
//
///**第一步：将交通灯用Lamp class模拟出来
// * 一个四方向路口，总共会有12个方向可以走：
// * 直行：s2n, n2s, e2w, w2e
// * 左转：n2e, e2s, s2w, w2n
// * 右转：n2w, w2s, s2e, e2n
// *
// * 我们假设交通灯只有红色，绿色两个颜色
// * 这三个方向中，假设右转一直是绿灯，所以不需要控制
// * 需要控制状态转换的就是直行，左转这两个方向
// *
// * 对于每一个lamp，我们都用三个状态去进行描述：
// * boolean status : 挡墙lamp的颜色，true是绿色，false是红色
// * String opposite : 当前lamp是绿色时候，相应也变成绿色的反方向
// * String next: 当前lamp变成红色时候，会变绿的下一个灯
// *             （这个是自己定义的，要求几个方向连在一起能够自动形成circle，触发一个，就能够触发一个循环的转换即可）
// */
//
//
//public enum Lamp {
//    /**直行 + 左转  (前四个：进行完整描述, status, opposite, next)**/
//    S2N(false,"N2S","S2W"),
//    S2W(false,"N2E","E2W"),
//    E2W(false,"W2E","E2S"),
//    E2S(false,"W2N","S2N"),
//    /**直行 + 左转 （后四个 ： ）
//    //下面元素表示与上面的元素的相反方向的灯，它们的“相反方向灯”和“下一个灯”不用再计算一遍了*//
//    N2S(false,null,null),
//    N2E(false,null,null),
//    W2E(false,null,null),
//    W2N(false,null,null),
//    /**右转 ：默认一直绿色即可*/
//    S2E(true,null,null),
//    E2N(true,null,null),
//    N2W(true,null,null),
//    W2S(true,null,null);
//
//    //field
//    private boolean status;
//    private String opposite;
//    private String next;
//    private Lamp(boolean status, String opposite, String next) {
//        this.status = status;
//        this.opposite = opposite;
//        this.next = next;
//    }
//
//    //拿到现在lamp的颜色
//    public boolean getStatus() {
//        return status;
//    }
//
//    //将lamp的颜色变成绿色
//    public void toGreen() {
//        this.status = true;
//        if (opposite != null) {  //将反方向也要变成绿灯
//            Lamp.valueOf(opposite).toGreen();
//        }
//    }
//
//    //将lamp的颜色变成绿色
//    public void toRed() {
//        this.status = true;
//        if (opposite != null) {  //将反方向也要变成绿灯
//            Lamp.valueOf(opposite).toRed();
//        }
//    }
//
//    //找到下一个灯
//    public Lamp next() {
//        if (next != null) {
//            return Lamp.valueOf(next);
//        }
//        return null;
//    }
//}
//
///**第二步：使用Road class来描述：如果当前road上车辆数量>0,并且灯是绿色，就可以将第一辆车放走
// *
// *
// */
//class Road {
//    private List<String> vehicles = new ArrayList<>();
//    private String name; // road's name
//    public Road(String name) {
//        this.name = name;
//    }
//
//    public void run() {
//        if (vehicles.size() > 0) {
//            boolean status = Lamp.valueOf(Road.this.name).getStatus();
//            if (status) {    //绿色，就放走第一辆车
//                vehicles.remove(0);
//            }
//        }
//    }
//}
//
///**第三步：使用lampcontroller，控制当前哪个方向的灯变绿来回切换的时间*/
//public class LampController {
//    private Lamp currentLamp;
//    public LampController() {
//
//    }
//
//    //模拟整套交通流程
//    public void start() {
//        currentLamp.toGreen();  //将当前灯变绿
//
//        //启动定时器，每隔10秒，将当前灯变红，并将下一个灯变绿
//        currentLamp.toRed();
//        currentLamp= currentLamp.next();
//        currentLamp.toGreen();
//    }
//}
