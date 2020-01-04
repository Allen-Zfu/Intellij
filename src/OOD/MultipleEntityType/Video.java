//package OOD.MultipleEntityType;
//import java.util.*;
//
////public class Video {
////    private String title;
////    private int availableNum;
////
////    public Video(String title, int availableNum) {
////        this.title = title;
////        this.availableNum = availableNum;
////    }
////
////    public String getTitle() {
////        return title;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    public Boolean isAvailable() {
////        return availableNum;
////    }
////
////    public void setAvability(boolean avability) {
////        this.availableNum = availableNum;
////    }
////}
//
///*
//class User {
//	int userID;
//	public User(int userID) {
//		this.userID = userID;
//	}
//
//	public int getUser() {
//		return userID;
//	}
//}
//*/
//
//public class Video {
//    private String title;
//    private int availableNum;
//
//    public Video(String title, int availableNum) {
//        this.title = title;
//        //—> 这里应该放list<VideoCopy> -> 用list信息直接拿到最终信息，不要用available num
//        List<VideoCopy> list;
//        //this.availableNum = availableNum;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public int getAvailableNum() {
//        return availableNum;
//    }
//
//    public void setAvailableNum(int availableNum) {  //update available num
//        this.availableNum = availableNum;
//    }
//}
//
//public class VideoCopy {
//    private Video v;
//    private int index; //ID
//    private int activeDay;
//    private int expireTime;
//
//    public VideoCopy(int index, int activeDay, int expireTime) {
//        this.index = index;
//        this.activeDay = activeDay;
//        this.expireTime = expireTime;
//    }
//
//    public Video getVideo() {
//        return v;
//    }
//
//    public int getIndex() {
//        return index;
//    }
//
//    public int getActiveDay() {
//        return activeDay;
//    }
//
//    public void setActiveDay(int activeDay) {
//        this.activeDay = activeDay;
//    }
//
//    public int getExpireTime() {
//        return expireTime;
//    }
//
//    public boolean checkIfExpire(int curTime) {       /* curTime？*/
//
//    }
//}
//
//
//public class RentalMachine {
//    //private User user;
//    private Video v;
//    private VideoCopy vc; // ->这里应该是一个list<VideoCopy>
//    private int curTime;
//
//    //return : the availableNum of the video
//    public int search(String title) {
//
//    }
//
//    public boolean rental(VideoCopy vc, int curTime) {
////INPUT应该是video v(video是输入，用户能拿到的信息是video，通过rental machine找到的是videoCopy的信息)
//        //Video v = vc.getVideo();
//        //v.setAvailableNum(v.getAvailableNum() - 1);
//
//    }
//
//    public boolean return(VideoCopy vc) {  //
//        //boolean expired = vc.checkIfExpire();
//        //if (expired) // do extra operation
//    }
//}
//
