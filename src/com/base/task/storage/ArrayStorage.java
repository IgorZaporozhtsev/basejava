package com.base.task.storage;

import com.base.task.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

  @Override
  protected void fillDeletedElem(int index) {
      storage[index] = storage[size - 1];
  }

  @Override
  protected void insertElement(Resume resume, int index) {
      storage[size] = resume;
  }

  protected int getIndex(String uuid) {
    for (int i = 0; i < size; i++) {
      if (uuid.equals(storage[i].getUuid())) {
        return i;
      }
    }
    return -1;
  }
}
