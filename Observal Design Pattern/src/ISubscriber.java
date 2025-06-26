import java.util.ArrayList;
import java.util.List;

// ✅ Observer Interface
public interface ISubscriber {
    /**
     * Yeh method tab call hota hai jab koi video upload hota hai.
     * @param channelName - jis channel ne video upload kiya
     * @param latestVideo - us video ka title
     */
    void update(String channelName, String latestVideo);
}

// ✅ Concrete Observer
class Subscriber implements ISubscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String channelName, String latestVideo) {
        System.out.println("🔔 " + name + ", new video uploaded on " + channelName + ": \"" + latestVideo + "\"");
    }

    public String getName() {
        return name;
    }
}

// ✅ Subject Interface
interface IChannel {
    void subscribe(ISubscriber subscriber);
    void unSubscribe(ISubscriber subscriber);
    void notiffy(); // notify all subscribers
}

// ✅ Concrete Subject

class Channel implements IChannel {
    private String name;
    private String latestVideo;
    private List<ISubscriber> subscribers;

    public Channel(String name) {
        this.name = name;
        subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println(((Subscriber) subscriber).getName() + " subscribed to " + name);
    }

    @Override
    public void unSubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println(((Subscriber) subscriber).getName() + " unsubscribed from " + name);
    }

    @Override
    public void notiffy() {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(name, latestVideo);
        }
    }

    /**
     * Jab bhi channel video upload karega, turant sabko notify karega
     * @param titleVideo - uploaded video ka title
     */
    public void uploadVideo(String titleVideo) {
        this.latestVideo = titleVideo;
        System.out.println("✅ '" + titleVideo + "' uploaded on " + name);
        notiffy();
    }

    public String getLatestVideo() {
        return latestVideo;
    }
}

// ✅ Client (Simulation Class)
class YouTubeDemo {
    public static void main(String[] args) {
        // Step 1: Create a channel
        Channel techChannel = new Channel("Devil Coder");

        // Step 2: Create subscribers with names
        Subscriber subscriber1 = new Subscriber("Rahul");
        Subscriber subscriber2 = new Subscriber("Sneha");
        Subscriber subscriber3 = new Subscriber("Amit");

        // Step 3: Subscribing
        techChannel.subscribe(subscriber1);
        techChannel.subscribe(subscriber2);

        // Step 4: Upload video - 2 subscribers will be notified
        techChannel.uploadVideo("My new Java Roadmap Video");

        // Step 5: One more subscriber after first video
        techChannel.subscribe(subscriber3);

        // Step 6: Upload another video - now all 3 will be notified
        techChannel.uploadVideo("Spring Boot Real-time Notification System");

        // Step 7: Unsubscribe 1
        techChannel.unSubscribe(subscriber3);

        // Step 8: Upload 3rd video - only 2 subscribers notified
        techChannel.uploadVideo("DSA Masterclass Series - Episode 1");
    }
}

/*
------------------------------------------
🧠 INTERNAL WORKING & THOUGHT PROCESS:
------------------------------------------
- Channel = Subject
- Subscriber = Observer
- Jab bhi koi video upload hota hai, channel "notify()" call karta hai
- Har subscriber ka update() method call hota hai
- Yeh loosely coupled hai: Channel ko nahi pata kis type ke subscribers hai

------------------------------------------
💬 INTERVIEW MEIN KAISAY BOLNA HAI:
------------------------------------------
"Observer Design Pattern ek behavioral pattern hai jisme Subject (Channel) jab bhi update hota hai,
wo saare Observers (Subscribers) ko notify karta hai bina tight coupling ke.
Isse real-time notification system jaise use-case implement kiye ja sakte hain."

------------------------------------------
✅ REAL-WORLD EXAMPLE:
------------------------------------------
- YouTube channel upload karta hai to subscribers ko instant notification milti hai
- Stock market updates
- WhatsApp chat notifications
*/
