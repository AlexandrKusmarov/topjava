package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcMealRepositoryImpl implements MealRepository {

    @Override
    public Meal save(Meal meal ) {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public Meal get(int id) {
        return null;
    }

    @Override
    public List<Meal> getAll() {
        return null;
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    }
}
