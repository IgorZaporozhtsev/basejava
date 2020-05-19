package com.base.task;

import com.base.task.model.Resume;
import java.util.UUID;

public interface Storage {

  Resume[] getAll();

  Resume getById(UUID uuid);

  Resume getByName(String name);

  void save(Resume resume);

  void update(Resume resume);

  void delete(Resume resume);

  boolean resumeIsPresent(Resume resume);

  int size();

  void clear();

}
