package workWithThreads.safeClasses;

public class Friend implements Comparable<Friend> {

    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Если мы напишем в этом методе synchronized, то получим DeadLock, когда каждый из потоков будет ждать друг друга,
    // так как у нас получается внутри рекурсия. Чтобы выйти из этого состояния надо выбрать конкретный объект, на котором можно синхронизироваться
    public void throwBallTo(Friend catcher) {
        System.out.println(this.getName() + " кинул мяч в " + catcher.getName());
        synchronized (this.compareTo(catcher) > 0 ? this : catcher) {
            catcher.throwBallTo(this);
        }
    }

    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
