package com.base.task.storage;

import com.base.task.Storage;
import com.base.task.model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

  protected static final int STORAGE_LIMIT = 10;
  protected int size = 0;
  protected Resume[] storage = new Resume[1000];

  public Resume[] getAll() {
    return Arrays.copyOf(storage, size);
  }

  public Resume getById(String uuid) {
    int index = getIndex(uuid);
    if (index < 0) {
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
    int index = getIndex(resume.getUuid());
    if (index > 0) {
      System.out.println("Resume " + resume.getName() + " already exist");
    } else if (size == STORAGE_LIMIT) {
      System.out.println("Storage overflow");
    } else {
      insertElement(resume, index);
      size++;
    }
  }

  public void update(Resume resume) {
    int index = getIndex(resume.getUuid());
    if (index < 0) {
      System.out.println("Resume " + resume.getName() + " not exist");
    } else {
      storage[index] = resume;
    }
  }

  public void delete(String uuid) {
    int index = getIndex(uuid);
    if (index < 0) {
      System.out.println("Resume " + uuid + " not exist");
    } else {
      fillDeletedElem(index);
      size--;
    }
  }

  public int size() {
    return size;
  }

  public void clear() {
    Arrays.fill(storage, 0, size, null);
    size = 0;
  }

  protected abstract void fillDeletedElem(int index);

  protected abstract void insertElement(Resume resume, int index);

  protected abstract int getIndex(String uuid);
}
