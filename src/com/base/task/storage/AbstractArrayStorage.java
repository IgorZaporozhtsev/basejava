package com.base.task.storage;

import com.base.task.Storage;
import com.base.task.model.Resume;

public abstract class AbstractArrayStorage implements Storage {

  protected static final int STORAGE_LIMIT = 0;
  protected int size = 0;
  protected Resume[] storage = new Resume[1000];
}
