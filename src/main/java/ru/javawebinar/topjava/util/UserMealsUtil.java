package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class UserMealsUtil {

    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        List<UserMealWithExceed> userMealWithExceedArrayList = new ArrayList<>();
        Map<LocalDate, Integer> mapCaloriesPerDay;

        mapCaloriesPerDay = mealList.stream()
                .collect(Collectors.groupingBy(y -> y.getDateTime().toLocalDate()
                                .withDayOfMonth(y.getDateTime().toLocalDate().getDayOfMonth()),
                        Collectors.summingInt(UserMeal::getCalories)));

        for (Map.Entry<LocalDate, Integer> pair : mapCaloriesPerDay.entrySet()) {
            for (int i = 0; i < mealList.size(); i++) {
                if (pair.getKey().equals(mealList.get(i).getDateTime().toLocalDate())) {
                    if (pair.getValue() > 2000) {
                        userMealWithExceedArrayList.add(new UserMealWithExceed
                                (mealList.get(i).getDateTime()
                                        , mealList.get(i).getDescription()
                                        , pair.getValue(), true));
                    } else {
                        userMealWithExceedArrayList.add(new UserMealWithExceed
                                (mealList.get(i).getDateTime()
                                        , mealList.get(i).getDescription()
                                        , pair.getValue(), false));
                    }
                }
            }
        }

        for (UserMealWithExceed user : userMealWithExceedArrayList) {
            if (TimeUtil.isBetween(user.getDateTime().toLocalTime(), startTime, endTime))
                System.out.println(user.getDateTime() + " ; " + user.getDescription() + " ; " + user.getCalories() + " ; " + user.isExceed());
        }

        return userMealWithExceedArrayList;
    }
}
