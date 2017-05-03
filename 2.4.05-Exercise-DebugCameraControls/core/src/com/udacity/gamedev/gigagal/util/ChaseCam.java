package com.udacity.gamedev.gigagal.util;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.udacity.gamedev.gigagal.entities.GigaGal;

public class ChaseCam {

    private Camera camera;
    private GigaGal target;

    // Add following flag
    boolean isFollowing;


    public ChaseCam(Camera camera, GigaGal target) {
        this.camera = camera;
        this.target = target;

        // Initialize following flag
        isFollowing = true;

    }

    // Accept a float time delta
    public void update(float delta) {

        // TODO: Toggle the following flag when spacebar is pressed
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            isFollowing = !isFollowing;
        }


        // If following, update the camera's position to match the target
        if(isFollowing) {
            camera.position.x = target.position.x;
            camera.position.y = target.position.y;
        }


        // If not following, check if Gdx.input.isKeyPressed(Keys.A)
        if(!isFollowing) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                camera.position.x -= delta * Constants.CHASE_CAM_MOVE_SPEED;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                camera.position.x += delta * Constants.CHASE_CAM_MOVE_SPEED;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                camera.position.y += delta * Constants.CHASE_CAM_MOVE_SPEED;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                camera.position.y -= delta * Constants.CHASE_CAM_MOVE_SPEED;
            }
        }


        // If so, move the camera in the -x direction by delta * camera move speed


        // Move the camera right if D is pressed


        // Move the camera up if W is pressed


        // Move the camera down if S is pressed


    }
}
