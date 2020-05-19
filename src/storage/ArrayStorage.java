package storage;

import java.util.Arrays;
import java.util.UUID;
import model.Resume;

public class ArrayStorage {

  private static int size = 0;
  private Resume[] storage = new Resume[1000];

  public Resume[] getAll() {
    Resume[] resumes = new Resume[size];
    //Resume[] resumes = Arrays.copyOf(storage, size);
    for (int i = 0; i < size; i++) {
      resumes[i] = storage[i];
    }
    return resumes;
  }

  public Resume getById(UUID uuid) {
    for (int i = 0; i < size; i++) {
      if (uuid == storage[i].getUuid()) {
        return storage[i];
      }
    }
    return null;
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
    if (!resumeIsPresent(resume)) {
      storage[size] = resume;
      size++;
    }
  }

  public void update(Resume resume) {
    if (resumeIsPresent(resume)) {
      Resume byName = getByName(resume.getName());
      byName.setUuid(resume.getUuid());
      byName.setName(resume.getName());
      byName.setPosition(resume.getPosition());
    }
  }

  public void delete(Resume resume) {
    if (resumeIsPresent(resume)) {
      for (int i = 0; i < size; i++) {
        if (resume.getUuid() == storage[i].getUuid()) {
          storage[i] = storage[size - 1];
          size--;
        }
      }
    }
  }

  private boolean resumeIsPresent(Resume resume) {
    for (int i = 0; i < size; i++) {
      if (resume.getName().equalsIgnoreCase(storage[i].getName())) {
        System.out.println("Resume " + resume.getName() + " present in storage");
        return true;
      }
    }
    return false;
  }

  public int size() {
    return size;
  }

  public void clear() {
    storage = null;
    size = 0;
  }


}