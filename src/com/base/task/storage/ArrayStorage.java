package com.base.task.storage;

import java.util.Arrays;
import java.util.UUID;
import com.base.task.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

  public Resume[] getAll() {
    return Arrays.copyOf(storage, size);
  }

  public Resume getById(UUID uuid) {
    int index = getResumeIndex(uuid);
    if (index == -1) {
      System.out.println("Resume " + uuid + " not exist");
      return null;
    }
    return storage[index];
  }

  public Resume getByName(String name) {
    for (int i = 0; i < size; i++) {
      if (name.equalsIgnoreCase(storage[i].getName())) {
        return storage[i];
      }
    }
    return null;
  }

  public void save(Resume resume) {
    if (getResumeIndex(resume.getUuid()) != -1) {
      System.out.println("Resume " + resume.getUuid() + " already exist");
    } else if (size == STORAGE_LIMIT) {
      System.out.println("Storage overflow");
    } else {
      storage[size] = resume;
      size++;
    }
  }

  public void update(Resume resume) {
    int index = getResumeIndex(resume.getUuid());
    if (index == -1) {
      System.out.println("Resume " + resume.getName() + " not exist");
    } else {
      storage[index] = resume;
    }
  }

  public void delete(UUID uuid) {
    int index = getResumeIndex(uuid);
    if (index == -1) {
      System.out.println("Resume " + uuid + " not exist");
    } else {
      storage[index] = storage[size - 1];
      size--;
    }
  }

  private int getResumeIndex(UUID uuid) {
    for (int i = 0; i < size; i++) {
      if (uuid == storage[i].getUuid()) {
        return i;
      }
    }
    return -1;
  }

  public int size() {
    return size;
  }

  public void clear() {
    Arrays.fill(storage, 0, size, null);
    size = 0;
  }
}
