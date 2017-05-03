package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;

public class Level {

    GigaGal gigaGal;
    Array<Platform> platforms;

    public Level() {
        platforms = new Array<Platform>();
        initDebugLevel();
    }

    public void update(float delta) {
        gigaGal.update(delta, platforms);
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        for (Platform platform : platforms) {
            platform.render(batch);
        }
        gigaGal.render(batch);
        batch.end();
    }

    private void initDebugLevel() {

        // TODO: Make a more interesting level!
        platforms.add(new Platform(15, 100, 30, 20));
        platforms.add(new Platform(75, 90, 100, 65));
        platforms.add(new Platform(35, 55, 50, 20));
        platforms.add(new Platform(10, 20, 20, 9));

        gigaGal = new GigaGal(new Vector2(15, 40));

        addRandomPlateform(
                platforms,
                20,
                20, 40,
                5, 10,
                20, 80,
                20, 40);

    }

    private void addRandomPlateform(Array<Platform> platforms,
                                      int num,
                                      float minGapX, float maxGapX,
                                      float minGapY, float maxGapY,
                                      float minWidth, float maxWidth,
                                      float minHeight, float maxHeight) {


        boolean firstRun = true;
        Vector2 lastPosition = new Vector2();

        Platform lastPlatForm = new Platform(
                platforms.get(platforms.size - 1).getLeft(),
                platforms.get(platforms.size - 1).getTop(),
                platforms.get(platforms.size - 1).getWidth(),
                platforms.get(platforms.size - 1).getHeight()
        );

        for (int i = 0; i < num; i++) {
//            if (firstRun) {
//                lastPosition = new Vector2(
//                        platforms.get(platforms.size - 1).getRight(),
//                        platforms.get(platforms.size - 1).getTop());
//
//                firstRun = false;
//            }

            //float left, float top, float width, float height

//            Platform newPlatForm = new Platform(
//                    MathUtils.random(lastPosition.x + minGapX, lastPosition.x + maxGapX),
//                    MathUtils.random(lastPosition.y + minGapY, lastPosition.y + maxGapY),
//                    MathUtils.random(minWidth, maxWidth),
//                    MathUtils.random(minHeight, maxHeight));

            float height = MathUtils.random(minHeight, maxHeight);

            Platform newPlatForm = new Platform(
                    MathUtils.random(lastPlatForm.getRight() + minGapX, lastPlatForm.getRight() + maxGapX),
                    MathUtils.random(lastPlatForm.getBottom() - minGapY, lastPlatForm.getTop() + height + maxGapY),
                    MathUtils.random(minWidth, maxWidth),
                    height);

            platforms.add(newPlatForm);

            //lastPosition.set(newPlatForm.getRight(), newPlatForm.getTop());

            lastPlatForm = new Platform(
                    newPlatForm.getLeft(),
                    newPlatForm.getTop(),
                    newPlatForm.getWidth(),
                    newPlatForm.getHeight()
            );
        }

    }

}
