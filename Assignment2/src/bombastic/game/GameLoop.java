package bombastic.game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    private final GameModel model;
    private final GameView view;
    private final ExecutorService executor = Executors.newSingleThreadExecutor(task -> {
        Thread thread = new Thread(task, "game-loop");
        thread.setDaemon(true);
        return thread;
    });

    private long lastTime = -1;

    public GameLoop(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void start() {
        lastTime = -1;
        super.start();
    }

    @Override
    public void handle(long currentTime) {
        double dt = lastTime == -1 ? 0 : (currentTime - lastTime) / 1_000_000_000.0;
        lastTime = currentTime;
        executor.execute(() -> model.update(dt));
        view.render(model.getEntities());
    }
}
