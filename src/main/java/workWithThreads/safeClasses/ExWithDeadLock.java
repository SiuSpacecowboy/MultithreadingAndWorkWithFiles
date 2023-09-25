package workWithThreads.safeClasses;

public class ExWithDeadLock {

    public static void main(String[] args) {
        Friend friend = new Friend("В кепке");
        Friend friend1 = new Friend("Рэпер");
        new Thread(() -> friend.throwBallTo(friend1)).start();
        new Thread(() -> friend1.throwBallTo(friend)).start();
    }
}
