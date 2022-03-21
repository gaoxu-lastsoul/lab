//package thread;
//
//public class ThreadJoinDemo {
//
//    public static void main(String[] args) {
//        final ThreadTest threadTest1 = new ThreadTest(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("产品经理规划新需求");
//            }
//        });
//
//        final ThreadTest threadTest2 = new ThreadTest(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    threadTest1.join();
//                    System.out.println("开发人员开发新需求功能");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        ThreadTest threadTest3 = new ThreadTest(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    threadTest2.join();
//                    System.out.println("测试人员测试新功能");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        System.out.println("早上：");
//        System.out.println("测试人员来上班了...");
//        threadTest3.start();
//        System.out.println("产品经理来上班了...");
//        threadTest1.start();
//        System.out.println("开发人员来上班了...");
//        threadTest2.start();
//    }
//}