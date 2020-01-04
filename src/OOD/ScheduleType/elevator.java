//package OOD.ScheduleType;
//import java.util.*;
//
///*
//https://leetcode.com/discuss/interview-question/object-oriented-design/124660/OOD-or-Design-Elevator
//
//Elevator:
//DataFlow:
//            - request
//            - schedule and moving
//            - load onto elevator
//            - detail request
//            - schedule and moving
//            - unload
//
//For Elavator
//State: 	    current location
//	        current moving direction
//	        load request
//	        capacity
//Behavior:   move up / down
//	        load / unload
//For User：   轻量化user，可简单模拟为一条simulate
//State:      current location
//	        weight
//	        request
//Behavior:   send request
//	        enter / level
//For floor: 可简单抽象为List<List<Request>> floors, 因每一个floor的state只包含一组request的信息
//For request: which floor is requesting, to which floor
//For Scheduler: 给一组请求，返回一组电梯调度的状态
// */
//
//public class Elevator {
//    //maximum capacity of this eleveator
//    private final int maxCapacity;
//    //how many floors in this simulation
//    private final int maxFloor;
//    //current load (当前层请求的数量)
//    private int load;
//    //current location(在哪一层)
//    private int location;
//    //current direction
//    private boolean isGoingUp;
//
//    //all requests loaded on to this elevator.for each floor.
//    private int[] requests;
//
//    public Elevator(int maxCapacity, int maxFloor) {
//        this.maxCapacity = maxCapacity;
//        this.maxFloor = maxFloor;
//        this.load = load;
//        this.location = 1;
//        this.isGoingUp = true;
//        this.requests = new int[maxFloor];
//    }
//
//    //check if the elevator is empty or full
//    public boolean isEmpty() {
//        return load == 0;
//    }
//
//    public boolean isFull() {
//        return load >= maxCapacity;
//    }
//
//    //check the current location of this elevator
//    public int getLocation() {
//        return location;
//    }
//
//    //change the elevator's location by one floor according to the direction, return new location
//    public int move() {
//        if (isGoingUp) {
//            return location + 1 <= maxFloor ? location++ : location;
//        } else {
//            return location - 1 >= 0 ? location-- : location;
//        }
//    }
//
//    //reverse direction
//    public boolean changeMovingDirection() {
//        isGoingUp = !isGoingUp;
//        return isGoingUp;
//    }
//
//    //if the elevator has enough capacity, load all requests in the given queue
//    //load & unload 针对的是每一层的的request的数量
//    //currentQueue中存的是当前层的request，即为当前层这些人要去哪里
//    public int load(Queue<Integer> currentQueue) {
//        int numNewLoad = currentQueue.size();
//        if (load + numNewLoad > maxCapacity) {
//            return 0;
//        }
//        //for each floor's request
//        for (int requestedFloor : currentQueue) {
//            requests[requestedFloor - 1] += 1;
//        }
//        load += numNewLoad;
//        currentQueue.clear();
//        return numNewLoad;
//    }
//
//    //unload all request on the floor the elevator is currently on
//    public int unload() {
//        //拿到当前层有多少request
//        int numRequests = requests[location - 1];
//        //将当前层load全部置0
//        if (numRequests > 0) {
//            load -= numRequests;
//            requests[location - 1] = 0;
//            return numRequests;
//        }
//        return 0;
//    }
//}
//
////For Floors / users / requests can models as
////where requests.get(i), return all user's requests at floor i + 1
////List<Queue<Integer>> requests;
//
////deal with scedulers as a interface, given the state of system, update elevator's state
//public interface Scheduler {
//    public void schedule(List<Queue<Integer>> requests, List<Elevator> elevators, int floors);
//}
//
//public class Simulator {
//    //how many floors we're simulating
//    private final int floors;
//
//    //all user's request for all the level
//    private List<Queue<Integer>> requests;
//
//    //all elevators in the system
//    private List<Elevator> elevators;
//
//    //the current sceduler we use
//    private Scheduler scheduler;
//
//    public Simulator(int floors, int numElevators, Scheduler scheduler, List<Queue<Integer>> initialRequests, int elevatorCapacity) {
//        this.floors = floors;
//        this.scheduler = scheduler;
//        this.requests = initialRequests;
//        this.elevators = new ArrayList<>();
//        for (int i = 0; i < numElevators; i++) {
//                Elevator ele = new Elevator(elevatorCapacity, floors);
//                elevators.add(ele);
//            }
//
//        }
//
//        private void generateRequest() {
//
//        }
//
//        private void schedule() {
//            scheduler.schedule(requests, elevators, floors);
//        }
//
//        private void elevatorOp() {
//            for (Elevator e : elevators) {
//                //在当前层unload人
//                if (!e.isEmpty()) {
//                    e.unload();
//                }
//                //在当前层load人
//                if (!e.isFull()) {
//                    int location = e.getLocation();
//                    e.load(requests.get(location - 1));
//                }
//                e.move();
//            }
//        }
//
//        public void simulate(int steps) {
//            for (int i = 0; i < steps; i++) {
//                generateRequest();
//                schedule();
//                elevatorOp();
//                Thread.sleep(10);
//            }
//
//        }
//
//        private static class SimpleScheduler implements Scheduler {
//            @Override
//            public void schedule(List<Queue<Integer>> requests, List<Elevator> elevators, int floors) {
//                for (Elevator e : elevators) {
//                    if (e.getLocation() == 0) || e.getLocation() == floors) {
//                        e.changeMovingDirection();
//                    }
//                }
//            }
//        }
//
//        //测试函数
//        public static void main {
//            SimpleScheduler scheduler = new SimpleScheduler();
//            int floors = 10;
//            int numElevators = 1;
//            List<Queue<Integer>> initialRequests = new ArrayList<>();
//            //每一层randomly生成一些人作为起始输入
//            for (int i = 0; i < floors; i++) {
//                Queue<Integer> currentQueue = new LinkedList<>();
//                Random generator = new Random();
//                int req = generator.nextInt(10);
//                currentQueue.offer(req);
//                initialRequests.add(currentQueue);
//            }
//            Simulator mySimulator = new Simulator(floors, numElevators, scheduler, initialRequests, 14);
//            mySimulator.simulate(10);
//        }
//    }
//}