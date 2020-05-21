package com.base.task.storage;

import com.base.task.model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
  //read JavaDoc Ctrl + Q
  @Override
  protected void fillDeletedElem(int index) {
    int numMoved = size - index - 1;
    if (numMoved> 0){
      System.arraycopy(storage, index + 1, storage, index, numMoved);
    }
  }
  //https://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array
  @Override
  protected void insertElement(Resume resume, int index) {
    int insertIndex = - index - 1;
    System.arraycopy(storage, insertIndex, storage, size, insertIndex);
    storage[insertIndex] = resume;
  }

  @Override
  protected int getIndex(String uuid) {
    Resume searchKey = new Resume(uuid, "", "");
    return Arrays.binarySearch(storage, 0, size, searchKey);
  }
}
