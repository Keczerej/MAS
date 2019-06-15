package fitenssclub.view;

import java.time.LocalDateTime;
import java.util.List;

class ActivityDTO {
    public final String name;
    public final LocalDateTime startTime;
    final List<ExerciseDTO> exerciseList;

    ActivityDTO(String name, LocalDateTime startTime, List<ExerciseDTO> exerciseList) {
        this.name = name;
        this.startTime = startTime;
        this.exerciseList = exerciseList;
    }

    @Override
    public String toString() {
        return "ActivityDTO{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", exerciseList=" + exerciseList +
                '}';
    }

    void validate() {
        if(this.name.trim().length() < 1) throw new IllegalArgumentException("Nazwa zajęć nie może być pusta");
        if(this.startTime.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("Nie można dodawać zajęć w czasie przeszłym.");
        if(getTimeOfSelectedExercises() < 1)
            throw new IllegalArgumentException("Nie wybrano żadnych ćwiczeń.");
    }

    private int getTimeOfSelectedExercises() {
        return this.exerciseList.stream().filter(it -> it.isSelected).map(it -> it.time).mapToInt(Integer::intValue).sum();
    }

    LocalDateTime getEndTime() {
        return this.startTime.plusMinutes(getTimeOfSelectedExercises());
    }


}
