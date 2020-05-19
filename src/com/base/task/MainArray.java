package com.base.task;

import java.util.Arrays;
import java.util.UUID;
import com.base.task.model.Resume;
import com.base.task.storage.ArrayStorage;

public class MainArray {

  public static void main(String[] args) {
    Resume resumeIgor = new Resume(UUID.randomUUID(), "Igor", "Java Developer");
    Resume resumeIgorUpadated = new Resume(UUID.randomUUID(),"Igor", "C++ Developer");
    Resume resumeSam = new Resume(UUID.randomUUID(),"Sam", "Python Developer");
    Resume resumeTom = new Resume(UUID.randomUUID(),"Tom", "JS Developer");

    ArrayStorage storage = new ArrayStorage();

    storage.save(resumeIgor);

    Resume igorByName = storage.getByName("Igor");
    System.out.println("igorByName " + igorByName);
    Resume igorByID = storage.getById(resumeIgor.getUuid());
    System.out.println("igorByID " + igorByID);

    storage.save(resumeSam);
    storage.save(resumeSam);
    storage.save(resumeTom);
    System.out.println(storage.size());

    storage.update(resumeIgorUpadated);
    storage.delete(resumeSam);

    Resume[] all = storage.getAll();
    System.out.println(Arrays.asList(all));
  }
}
