package com.base.task;

import com.base.task.model.Resume;
import com.base.task.storage.SortedArrayStorage;

public class MainSortedArray {
    static Storage sortedStorage = new SortedArrayStorage();

  public static void main(String[] args) {
    Resume sortedIgor = new Resume("1", "sortedIgor", "Java Developer");
    Resume updatedIgor = new Resume("1", "updatedIgor", "Python Developer");
    Resume sortedJan = new Resume("2", "sortedJan", "JS Developer");

    System.out.println("--------- SORTED SAVE ------ ");
    sortedStorage.save(sortedIgor);
    sortedStorage.save(sortedJan);
    sortedStorage.save(sortedJan);

    sortedStorage.update(updatedIgor);
    sortedStorage.delete("2");
    Resume igor = sortedStorage.getByName("Igor");
    System.out.println(igor.toString());

    showArray(sortedStorage);
  }

  static private void showArray(Storage storage){
      Resume[] all =  sortedStorage.getAll();
    for (Resume resume : all) {
      System.out.println(resume.toString());
    }
  }
}
