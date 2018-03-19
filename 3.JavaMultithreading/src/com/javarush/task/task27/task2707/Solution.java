package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }
    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread.State stateAfterObj1Lock1;
        Thread.State stateAfterObj1Lock2;

       Thread blockObject1 = new Thread() {
            @Override
            public void run() {
                synchronized (o1){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        };
        Thread blockObject2 = new Thread() {
            @Override
            public void run() {
                synchronized (o2){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread threadTest1 = new Thread() {
            @Override
            public void run() {
           solution.someMethodWithSynchronizedBlocks(o1,o2);
            }
        };
        Thread threadTest2 = new Thread() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o2,o1);
            }
        };
        Thread.sleep(10);
        blockObject1.start();
        Thread.sleep(10);
        threadTest1.start();
        Thread.sleep(10);
        threadTest2.start();
//        System.out.println("threadTest1 "+threadTest1.getState());
//        System.out.println("threadTest2 "+threadTest2.getState());
        Thread.sleep(10);
        blockObject2.start();
        Thread.sleep(500);
        stateAfterObj1Lock1 = threadTest1.getState();
        stateAfterObj1Lock2 = threadTest2.getState();
//        System.out.println("threadTest1 "+threadTest1.getState());
//        System.out.println("threadTest2 "+threadTest2.getState());

//        Thread.sleep(500);
//        System.out.println("threadTest1 "+threadTest1.getState());
//        System.out.println("threadTest2 "+threadTest2.getState());
        if (!stateAfterObj1Lock1.equals(stateAfterObj1Lock2)){
            return true;
        }






//        if (threadTest2.getState()==Thread.State.BLOCKED){
//            return true;
//        }

        //do something here
        return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
