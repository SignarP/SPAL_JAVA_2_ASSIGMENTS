package bombastic.game;

import bombastic.game.entities.DestructibleWall;
import bombastic.game.entities.Entity;
import bombastic.game.entities.Floor;
import bombastic.game.entities.Wall;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameModel {

    private static final int TILE_SIZE = 32;
    private static final int MAP_OFFSET_X = 0;
    private static final int MAP_OFFSET_Y = 0;

    private static final int GRASS = 0;
    private static final int SOLID_WALL = 1;
    private static final int BREAKABLE_WALL = 2;

    private static final int[][] MAP = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private final List<Entity> entities = new ArrayList<>();
    private final List<Entity> entityView = Collections.unmodifiableList(entities);

    public GameModel() {
        initializeArena();
    }

    public List<Entity> getEntities() {
        return entityView;
    }

    public void update(double dt) {
        for (Entity entity : entities) {
            entity.update(dt);
        }
    }

    private void initializeArena() {
        for (int row = 0; row < MAP.length; row++) {
            for (int column = 0; column < MAP[row].length; column++) {
                double x = MAP_OFFSET_X + column * TILE_SIZE;
                double y = MAP_OFFSET_Y + row * TILE_SIZE;
                int tileType = MAP[row][column];

                entities.add(new Floor(x, y, TILE_SIZE));

                switch (tileType) {
                    case GRASS:
                        break;
                    case SOLID_WALL:
                        entities.add(new Wall(x, y, TILE_SIZE));
                        break;
                    case BREAKABLE_WALL:
                        entities.add(new DestructibleWall(x, y, TILE_SIZE));
                        break;
                    default:
                        throw new IllegalStateException("Unknown tile type: " + tileType);
                }
            }
        }
    }
}
