package winningteam.minnehack.io.hackathonandroid.db;

import java.util.ArrayList;
import java.util.List;

import winningteam.minnehack.io.hackathonandroid.model.Sport;
import winningteam.minnehack.io.hackathonandroid.model.WarmUp;
import winningteam.minnehack.io.hackathonandroid.model.WarmUpImage;

class DataGenerator {
    private static final String[] SPORTS = new String[]{"football", "soccer", "baseball", "basketball", "track"};
    private static final String[] BASEBALL= new String[]{"WALKING HEEL UPS (Quad)", "1. Maintain good forward lean. 2. Keep knees pointed down towards the ground. 3. Heels should come in contact with the hips. 4. Get up on your toes and extend. 5. Repeat the procedure for 10 yards alternating right and left. ", "bb_1",
            "FORWARD LUNGE", "Begin by stepping forward with your right leg (exaggerate normal stride length). 2. When your right foot is planted, lower your right elbow to the ground. 3. Use right leg to pull your left leg off the ground so that you can then step forward with the left foot. 4. Repeat the procedure for 10 yards alternating right and left. ","bb_2",
            "BACKWARD LUNGE",  "1. Step back with left leg. 2. Twist to the right as you lower your hips. 3. Repeat the procedure for 10 yards alternating right and left. ","bb_3",
            "SIDE LUNGE", "1. Step laterally as far as possible and lower hips. 2. Keep toes pointed forward and feet flat on the ground. 3. Repeat the procedure for 5 yards and then step with opposite foot in opposite direction for 5 yards", "bb_4",
            "INCH WORM", "Start in pushup position. 2. Keep knees straight and take small steps rotating around the ankle joint toward the hands. 3. Walk forward as far as possible. 4. Go up on fingertips. 5. Do for five yards.", "bb_5",
            "SINGLE LEG RDL", "1. Balance on right foot and lean forward. 2. Return to start position while keeping balance. 3. Do not let left foot touch ground if possible. 4. Do not cross left leg behind right leg. 5. Keep left toes pointed straight down. 6. Do ten repetitions on each leg. ", "bb_6",
            "ARM SWINGS", "Start small circles moving hands forward. 2. Gradually increase size of circles. 3. Do for ten repetitions and repeat with backward circle. ", "bb_7_1",
            "CROSS IN FRONT","Keep hands at shoulder level and cross in front. 2. Do for ten reps alternating arms coming across. ", "8",
            "SCISSORS","Keep the arms straight with thumbs pointed in toward body. 2. Pull arms back for a two count. 3. Do for five repetitions alternating arms from top to bottom.", "9_1"
    };


    public static List<Sport> generateSports() {
        List<Sport> sports = new ArrayList<>(SPORTS.length);
        for (int i = 0; i < SPORTS.length; i++) {
            Sport sport = new Sport();
            sport.setId(i+1);
            sport.setName(SPORTS[i]);
        }
        return sports;
    }

    public static List<WarmUp> generateWarmUpsForSports(List<Sport> sports) {
        List<WarmUp> warmUps = new ArrayList<>(BASEBALL.length / 2);
        for (int i = 0; i < SPORTS.length / 2; i = i++) {
            WarmUp warmUp = new WarmUp();
            warmUp.setId(i*2);
            warmUp.setName(BASEBALL[i*2]);
            warmUp.setRepetitions("20");
            warmUp.setImage(new WarmUpImage(BASEBALL[i*2+1]));
            warmUp.setSportId(4);
        }
        return warmUps;
    }
}
