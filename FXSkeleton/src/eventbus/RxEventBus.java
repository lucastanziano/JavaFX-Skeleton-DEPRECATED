package eventbus;

import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

public final class RxEventBus {
    private static ConcurrentHashMap<String, Subject> subjectMapper = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Object> eventStickyMapper = new ConcurrentHashMap<>();
    
    private RxEventBus() {
    }

    public static <T> Observable<T> dispatchEvent(Class<T> clazz) {
        Subject<T, T> subject = subjectMapper.get(clazz.getName());
        return subject == null ? subjectMapper.put(clazz.getName(), PublishSubject.create()) : subject;
    }

    public static <T> Observable<T> dispatchStickyEvent(Class<T> clazz) {
        Subject subject = subjectMapper.get(clazz.getName()+"_sticky");
        subject = subject == null ? subjectMapper.put(clazz.getName(), BehaviorSubject.create()) : subject;
        Object o = eventStickyMapper.get(clazz.getName());
        if (o != null)
            subject.onNext(o);
        return subject;
    }

    public static void post(Object o) {
        Subject subject = subjectMapper.get(o.getClass().getName());
        if (subject != null) {
            subject.onNext(o);
        }
    }

    public static void postSticky(Object o) {
        String name = o.getClass().getName();
        eventStickyMapper.put(name, o);
        Subject subject = subjectMapper.get(name+"_sticky");
        if (subject != null) {
            subject.onNext(o);
        }
    }
}