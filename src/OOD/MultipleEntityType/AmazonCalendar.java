//package OOD.MultipleEntityType;
//import java.util.*;
///*
//要求实现的功能：
//1） add employee
//2） create meeting
//3） list all meetings of a employee
// */
//
///*
//思考的过程：
//addEmployee(Employee e)    --> class Meeting //一个会议
//createMeeting(long start, long end, String topic)   --> class Meeting
//allMeeting()     --> class Employee
// */
//
// */
// */
//
// */
//
//
//
//
//public class AmazonCalendar {
//
//
//}
//
//public class Meeting {
//    private String topic; //topic一开始需要传一个值进去
//    private long start;
//    private long end;
//    List<Employee> invitees;
//
////    public Meeting(String topic, long start, long end) {
////        this.invitees = new ArrayList<>();
////        this.topic = topic;
////        this.start = start;
////        this.end = end;
////    }
//
//    public boolean addEmployee(Employee e) {
//        invitees.add(e);
//        e.addMeeting(this);  //把当前这个meeting加入到e的meeting list中去
//    }
//
//    /*  cerate meeting实际上就是Meeting的constructor在完成的事情，所以可以
//    * 将constructor改成默认的内容，将constructor内容写在cerateNewMeeting中 */
//    public boolean createNewMeeting(long start, long end, String topic) {
//        this.topic = topic;
//        this.start = start;
//        this.end = end;
//    }
//
//}
//
//
///* 子类 */
//abstract class People {
//    public final int ID;
//    public final String NAME;
//
//    public People(int id, String name) {
//        this.ID = id;
//        this.NAME = name;
//    }
//}
//
//
//class Employee extends People {
//    private final List <Meeting> allMeeting;
//    public Employee(int id, String name) {
//        super(id, name);
//        allMeeting = new ArrayList<>();
//    }
//
//    public List<Meeting> getAllMeeting() {
//        //做一个list，手动copy传出去 （不要传origin的reference，防止原版被别人拿到随便更改）
//        //return Collections.copy(allMeeting);
//    }
//
//    public void addMeeting(Meeting m) {
//        allMeeting.add(m);
//    }
//}